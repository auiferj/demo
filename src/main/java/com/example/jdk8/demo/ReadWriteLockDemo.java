package com.example.jdk8.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 读写锁:
 *      多个线程在同时读一个资源类的时候没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 *      但是，如果一个线程想去写共享资源，就不应该再有其他的线程对该资源进行读或写操作。
 *
 *      写操作：原子+独占，整个过程必须是一个完整的统一体，中间不允许被分割，被打断
 */
public class ReadWriteLockDemo {
    private volatile Map<String,String> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private void put(String key,String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入："+ value);
            //暂停一会儿
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                map.put(key,value);
                System.out.println(Thread.currentThread().getName()+"\t写入完成");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    private void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取");
            //暂停一会儿
            try {
                TimeUnit.MILLISECONDS.sleep(300);

                System.out.println(Thread.currentThread().getName()+"\t读取完成:"+map.get(key));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        for(int i = 1;i <= 5 ;i++){
            int finalI = i;
            new Thread(()->{
                readWriteLockDemo.put(String.valueOf(finalI),String.valueOf(finalI));
                readWriteLockDemo.get(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }
    }
}
