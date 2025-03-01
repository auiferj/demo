package com.example.jdk8.proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Proxy {
    private static final Map<String, byte[]> bytesMap = new HashMap<>();
    private static final AtomicInteger count = new AtomicInteger();

    public static Object newProxyInstance(Class<?> intaface, InvocationHandler handler) {
        //代码①处
        String rn = "\r\n";
        String className = "Proxy" + count.getAndIncrement();
        String str = "package com.yanghui.study.proxy.custom;" + rn +
                "public class " + className + " implements " + intaface.getName() + "{" + rn +
                "    private InvocationHandler handler;" + rn +
                "    public " + className + "(InvocationHandler handler){" + rn +
                "        this.handler=handler;" + rn +
                "    }" + rn;

        String methodStr = "";
        for (Method m : intaface.getMethods()) {
            methodStr = methodStr + "    @Override" + rn +
                    "    public " + m.getReturnType().getName() + " " + m.getName() + "(";
            String parameterStr = "";
            String psType = "";
            String pname = "";
            for (Parameter p : m.getParameters()) {
                parameterStr = parameterStr + p + ",";
                psType = psType + p.getType().getName() + ".class,";
                pname = pname + p.getName() + ",";
            }
            if (!parameterStr.equals("")) {
                parameterStr = parameterStr.substring(0, parameterStr.length() - 1);
            }
            parameterStr = parameterStr + "){" + rn +
                    "        try{" + rn +
                    "            " + Method.class.getName() + " method = " + intaface.getName() + ".class.getDeclaredMethod(\"" + m.getName() + "\"";
            if (!psType.equals("")) {
                psType = psType.substring(0, psType.length() - 1);
                parameterStr = parameterStr + "," + psType + ");" + rn;
            } else {
                parameterStr = parameterStr + ");" + rn;
            }
            if (pname.length() > 0) {
                pname = pname.substring(0, pname.length() - 1);
            }
            String returnStr = "";
            if (!"void".equals(m.getReturnType().getName())) {
                returnStr = returnStr + "            return (" + m.getReturnType().getName() + ")";
            }
            parameterStr = parameterStr +
                    returnStr + "this.handler.invoke(this,method," + (pname.length() == 0 ? "null" : "new Object[]{" + pname + "}") + ");" + rn +
                    "        } catch (Throwable e) {" + rn +
                    "        throw new RuntimeException(e);" + rn +
                    "    }" + rn +
                    "    }" + rn;
            methodStr = methodStr + parameterStr;
        }
        String endStr = "}";
        str = str + methodStr + endStr;
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "com/yanghui/study/proxy/custom/";
        String fileStr = path + className + ".java";
        //代码②处
        //写入文件
        writeToFile(fileStr, str);
        //代码③处
        //动态编译
        String className1 = "com.yanghui.study.proxy.custom." + className;
        return compileToFileAndLoadclass(className1, fileStr, handler);
    }

    /**
     * 从源文件到字节码文件的编译方式
     *
     * @param className
     * @param fileStr
     * @param handler
     * @return
     */
    private static Object compileToFileAndLoadclass(String className, String fileStr, InvocationHandler handler) {
        //获取系统Java编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //获取Java文件管理器
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        //定义要编译的源文件
        File file = new File(fileStr);
        //通过源文件获取到要编译的Java类源码迭代器，包括所有内部类，其中每个类都是一个 JavaFileObject，也被称为一个汇编单元
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(file);
        //生成编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);
        //执行编译任务
        task.call();
        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class<?> c = Thread.currentThread().getContextClassLoader().loadClass(className);
            Constructor<?> ct = c.getConstructor(InvocationHandler.class);
            Object object = ct.newInstance(handler);
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFile(String file, String context) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(file));
            fw.write(context);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
