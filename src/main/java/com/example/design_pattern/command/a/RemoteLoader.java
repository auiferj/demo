package com.example.design_pattern.command.a;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        // 创建接收者
        Light livingRoomLight = new Light();
        CeilingFan ceilingFan = new CeilingFan();

        // 创建命令对象
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);

        // 设置命令到遥控器
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, ceilingFanHigh, new NoCommand());

        // 测试按钮
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0); // 开灯
        remoteControl.offButtonWasPushed(0); // 关灯
        remoteControl.undoButtonWasPushed(); // 撤销关灯

        remoteControl.onButtonWasPushed(1); // 风扇高速
        remoteControl.undoButtonWasPushed(); // 撤销风扇高速
    }
}
