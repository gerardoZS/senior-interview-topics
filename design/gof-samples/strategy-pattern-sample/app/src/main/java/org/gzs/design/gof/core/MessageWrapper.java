package org.gzs.design.gof.core;

import java.util.UUID;

public record MessageWrapper(UUID messageId, UUID userId, String subject, String message) {

    public static MessageWrapperBuilder builder() {
      return new MessageWrapperBuilderImpl();
    }

    public interface MessageWrapperBuilder {
        MessageWrapperBuilder messageId(UUID messageId);
        MessageWrapperBuilder userId(UUID userId);
        MessageWrapperBuilder subject(String subject);
        MessageWrapperBuilder message(String message);
        MessageWrapper build();
    }

    private static class MessageWrapperBuilderImpl implements MessageWrapperBuilder {
        @Override
        public MessageWrapperBuilder messageId(UUID messageId) {
            return null;
        }

        @Override
        public MessageWrapperBuilder userId(UUID userId) {
            return null;
        }

        @Override
        public MessageWrapperBuilder subject(String subject) {
            return null;
        }

        @Override
        public MessageWrapperBuilder message(String message) {
            return null;
        }

        @Override
        public MessageWrapper build() {
            return null;
        }
    }
}