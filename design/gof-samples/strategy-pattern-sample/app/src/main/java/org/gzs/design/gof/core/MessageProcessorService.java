package org.gzs.design.gof.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageProcessorService implements MessageProcessor {

    private final Map<String, MessageSender> messageSenderMap;

    public MessageProcessorService(List<MessageSender> messageSenderList) {
        messageSenderMap = new HashMap<>();
        messageSenderList.forEach(messageSender -> {
            String target = messageSender.getSupportedTarget();
            if (messageSenderMap.containsKey(target)) {
                throw new IllegalArgumentException("Duplicated MessageSender for the target " + target);
            }
            messageSenderMap.put(target, messageSender);
        });
    }

    @Override
    public void process(MessageWrapper messageWrapper, List<String> targets) {
        targets.forEach(target -> {
            MessageSender messageSender = messageSenderMap.get(target);
            if (messageSender == null) {
                throw new IllegalArgumentException("Not supported target: " + target);
            }
            messageSender.send(messageWrapper.message());
        });
    }
}
