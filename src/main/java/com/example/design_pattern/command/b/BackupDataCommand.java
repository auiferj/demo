package com.example.design_pattern.command.b;

// 备份数据命令
class BackupDataCommand implements Command {
    private String database;

    public BackupDataCommand(String database) {
        this.database = database;
    }

    @Override
    public void execute() {
        System.out.println("Backing up database: " + database);
    }
}
