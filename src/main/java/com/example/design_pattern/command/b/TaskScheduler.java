package com.example.design_pattern.command.b;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {
    private Queue<Command> taskQueue = new LinkedList<>();

    // 添加任务到队列
    public void addTask(Command command) {
        taskQueue.add(command);
    }

    // 执行队列中的所有任务
    public void processTasks() {
        while (!taskQueue.isEmpty()) {
            Command command = taskQueue.poll();
            command.execute();
        }
    }

    // 延迟执行任务
    public void processTasksWithDelay(long delayMillis) {
        new Thread(() -> {
            try {
                Thread.sleep(delayMillis); // 延迟
                processTasks(); // 执行任务
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // 批处理任务（每批处理指定数量的任务）
    public void processTasksInBatches(int batchSize) {
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing a batch of " + batchSize + " tasks:");
            for (int i = 0; i < batchSize && !taskQueue.isEmpty(); i++) {
                Command command = taskQueue.poll();
                command.execute();
            }
        }
    }
}
