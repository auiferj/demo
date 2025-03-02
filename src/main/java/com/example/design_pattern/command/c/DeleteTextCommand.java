package com.example.design_pattern.command.c;

// 删除文本命令
class DeleteTextCommand implements Command {
    private StringBuilder document; // 接收者
    private int position; // 删除文本的位置
    private int length; // 删除文本的长度
    private String deletedText; // 被删除的文本（用于撤销）

    public DeleteTextCommand(StringBuilder document, int position, int length) {
        this.document = document;
        this.position = position;
        this.length = length;
    }

    @Override
    public void execute() {
        deletedText = document.substring(position, position + length); // 保存被删除的文本
        document.delete(position, position + length); // 删除文本
        System.out.println("Deleted text: \"" + deletedText + "\" from position " + position);
    }

    @Override
    public void undo() {
        document.insert(position, deletedText); // 恢复被删除的文本
        System.out.println("Undo: Restored text: \"" + deletedText + "\" at position " + position);
    }
}