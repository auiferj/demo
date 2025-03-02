package com.example.design_pattern.command.a;

public class CeilingFanHighCommand implements Command{
    private CeilingFan fan;
    private int prevSpeed; // 记录之前的速度，用于撤销

    public CeilingFanHighCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed(); // 记录当前速度
        fan.high(); // 设置为高速
    }

    @Override
    public void undo() {
        // 根据之前的速度恢复
        if (prevSpeed == CeilingFan.HIGH) {
            fan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            fan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            fan.low();
        } else {
            fan.off();
        }
    }
}
