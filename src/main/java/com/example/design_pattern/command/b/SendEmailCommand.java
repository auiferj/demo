package com.example.design_pattern.command.b;

// 发送邮件命令
class SendEmailCommand implements Command {
    private String email;

    public SendEmailCommand(String email) {
        this.email = email;
    }

    @Override
    public void execute() {
        System.out.println("Sending email to: " + email);
    }
}
