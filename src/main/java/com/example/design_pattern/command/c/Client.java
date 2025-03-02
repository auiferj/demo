package com.example.design_pattern.command.c;

public class Client {
    public static void main(String[] args) {
        // 创建文档（接收者）
        StringBuilder document = new StringBuilder("Hello, World!");

        // 创建日志管理器
        CommandLogger logger = new CommandLogger();

        // 创建命令
        Command addTextCommand1 = new AddTextCommand(document, " Awesome", 5);
        Command deleteTextCommand1 = new DeleteTextCommand(document, 7, 5);
        Command addTextCommand2 = new AddTextCommand(document, " Universe", document.length());

        // 执行命令并记录日志
        addTextCommand1.execute();
        logger.logCommand(addTextCommand1);

        deleteTextCommand1.execute();
        logger.logCommand(deleteTextCommand1);

        addTextCommand2.execute();
        logger.logCommand(addTextCommand2);

        // 打印日志
        logger.printLog();

        // 重放所有命令
        logger.replayCommands();

        // 打印最终文档内容
        System.out.println("Final document: " + document.toString());

        //撤销
        logger.undoAllCommands();
        System.out.println("Document after undo: " + document.toString());
    }
}
