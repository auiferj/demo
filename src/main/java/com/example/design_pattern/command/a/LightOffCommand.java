package com.example.design_pattern.command.a;

public class LightOffCommand implements Command{
    private Light light; // 接收者

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off(); // 调用接收者的方法
    }

    @Override
    public void undo() {
        light.on(); // 撤销操作
    }
}
