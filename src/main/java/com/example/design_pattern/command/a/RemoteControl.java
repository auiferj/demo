package com.example.design_pattern.command.a;

// 遥控器类
public class RemoteControl {
    private Command[] onCommands; // 开命令数组
    private Command[] offCommands; // 关命令数组
    private Command undoCommand; // 记录最后一个命令，用于撤销

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        // 初始化所有按钮为空命令
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    // 设置命令
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    // 按下开按钮
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot]; // 记录最后一个命令
    }

    // 按下关按钮
    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot]; // 记录最后一个命令
    }

    // 按下撤销按钮
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
}
