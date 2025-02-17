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

        private UUID messageId;
        private UUID userId;
        private String subject;
        private String message;

        @Override
        public MessageWrapperBuilder messageId(UUID messageId) {
            this.messageId = messageId;
            return this;
        }

        @Override
        public MessageWrapperBuilder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public MessageWrapperBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        @Override
        public MessageWrapperBuilder message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public MessageWrapper build() {
            return new MessageWrapper(this.messageId, this.userId, this.subject, this.message);
        }
    }
}