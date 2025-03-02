package com.example.design_pattern.command.b;

public class Client {
    public static void main(String[] args) {
        // 创建任务调度器
        TaskScheduler scheduler = new TaskScheduler();

        // 添加任务到队列
        scheduler.addTask(new SendEmailCommand("user1@example.com"));
        scheduler.addTask(new GenerateReportCommand("Monthly Report"));
        scheduler.addTask(new BackupDataCommand("SalesDB"));
        scheduler.addTask(new SendEmailCommand("user2@example.com"));
        scheduler.addTask(new GenerateReportCommand("Weekly Report"));

        // 1. 立即执行所有任务
        System.out.println("--- Immediate Execution ---");
        scheduler.processTasks();

        // 重新添加任务
        scheduler.addTask(new SendEmailCommand("user3@example.com"));
        scheduler.addTask(new GenerateReportCommand("Daily Report"));
        scheduler.addTask(new BackupDataCommand("HRDB"));

        // 2. 延迟执行任务（延迟 3 秒）
        System.out.println("--- Delayed Execution ---");
        scheduler.processTasksWithDelay(3000); // 3 秒后执行

        // 重新添加任务
        scheduler.addTask(new SendEmailCommand("user4@example.com"));
        scheduler.addTask(new GenerateReportCommand("Yearly Report"));
        scheduler.addTask(new BackupDataCommand("FinanceDB"));

        // 3. 批处理任务（每批处理 2 个任务）
        System.out.println("--- Batch Processing ---");
        scheduler.processTasksInBatches(2);
    }
}
