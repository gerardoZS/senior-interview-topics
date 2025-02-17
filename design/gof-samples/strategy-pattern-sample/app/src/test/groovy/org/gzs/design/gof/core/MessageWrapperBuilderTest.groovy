package org.gzs.design.gof.core

import spock.lang.Specification

class MessageWrapperBuilderTest extends Specification {
    def "gets an instance of MessageWrapperBuilder"() {
        expect:
        MessageWrapper.MessageWrapperBuilder.isInstance(MessageWrapper.builder())
    }

    def "creates an instance of MessageWrapper using the builder"() {
        given:
        def messageId = UUID.randomUUID()
        def userId = UUID.randomUUID()
        def subject = "Test message"
        def message = "Hello world!"

        when:
        MessageWrapper messageWrapper = MessageWrapper.builder().messageId(messageId)
                .userId(userId)
                .subject(subject)
                .message(message)
                .build();

        then:
        with(messageWrapper) {
            messageId() == messageId;
            userId() == userId
            subject() == subject
            message() == message
        }
    }
}
