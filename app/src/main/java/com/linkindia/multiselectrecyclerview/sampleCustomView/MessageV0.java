package com.linkindia.multiselectrecyclerview.sampleCustomView;

class MessageV0 {

    private final String messageTitle;
    private final String messageContent;

    MessageV0(String messageTitle, String messageContent) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
    }

     String getMessageTitle() {
        return messageTitle;
    }

    String getMessageContent() {
        return messageContent;
    }
}
