package com.example.design_pattern.command.b;

// 生成报告命令
class GenerateReportCommand implements Command {
    private String reportName;

    public GenerateReportCommand(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public void execute() {
        System.out.println("Generating report: " + reportName);
    }
}
