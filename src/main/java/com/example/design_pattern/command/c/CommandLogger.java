package com.example.design_pattern.command.c;

import java.util.ArrayList;
import java.util.List;

class CommandLogger {
    private List<Command> commandHistory = new ArrayList<>(); // 命令历史记录

    // 记录命令
    public void logCommand(Command command) {
        commandHistory.add(command);
    }

    // 打印日志
    public void printLog() {
        System.out.println("--- Command History Log ---");
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println((i + 1) + ": " + commandHistory.get(i).getClass().getSimpleName());
        }
    }

    // 重放所有命令
    public void replayCommands() {
        System.out.println("--- Replaying Commands ---");
        for (Command command : commandHistory) {
            command.execute();
        }
    }

    //撤销所有命令
    public void undoAllCommands() {
        System.out.println("--- Undoing All Commands ---");
        for (int i = commandHistory.size() - 1; i >= 0; i--) {
            commandHistory.get(i).undo();
        }
    }
}
