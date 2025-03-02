package com.example.design_pattern.command.a;

// 命令接口
public interface Command {
    void execute(); // 执行命令

    void undo();    // 撤销命令
}
