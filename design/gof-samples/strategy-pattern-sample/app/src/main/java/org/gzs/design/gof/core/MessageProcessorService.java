package org.gzs.design.gof.core;

import java.util.List;

public class MessageProcessorService implements MessageProcessor {

    private final List<MessageSender> messageSenderList;

    public MessageProcessorService(List<MessageSender> messageSenderList) {
        this.messageSenderList = messageSenderList;
    }

    @Override
    public void process(String message, List<String> targets) {
        for (String target : targets) {
            for (MessageSender messageSender : messageSenderList) {
                if (messageSender.support(target)) {
                    messageSender.send(message);
                    break;
                }
            }
        }
    }
}
