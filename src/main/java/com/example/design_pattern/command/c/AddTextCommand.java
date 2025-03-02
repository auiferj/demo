package com.example.design_pattern.command.c;

// 添加文本命令
class AddTextCommand implements Command {
    private StringBuilder document; // 接收者
    private String text; // 要添加的文本
    private int position; // 添加文本的位置

    public AddTextCommand(StringBuilder document, String text, int position) {
        this.document = document;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        document.insert(position, text); // 在指定位置插入文本
        System.out.println("Added text: \"" + text + "\" at position " + position);
    }

    @Override
    public void undo() {
        document.delete(position, position + text.length()); // 删除添加的文本
        System.out.println("Undo: Removed text: \"" + text + "\" from position " + position);
    }
}

