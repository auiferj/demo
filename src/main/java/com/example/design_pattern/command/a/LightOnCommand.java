package com.example.design_pattern.command.a;

public class LightOnCommand implements Command{
    private Light light; // 接收者

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on(); // 调用接收者的方法
    }

    @Override
    public void undo() {
        light.off(); // 撤销操作
    }
}
