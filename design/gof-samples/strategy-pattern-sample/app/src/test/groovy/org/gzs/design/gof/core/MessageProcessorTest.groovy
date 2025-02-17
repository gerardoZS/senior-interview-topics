package org.gzs.design.gof.core

import spock.lang.Specification

class MessageProcessorTest extends Specification {

    def "receives a message and send it to the specified targets using sender mockups"() {
        given:
        def messageId = UUID.randomUUID()
        def userId = UUID.randomUUID()
        def subject = "Test message"
        def message = "Hello world!"
        def messageWrapper = MessageWrapper.builder().messageId(messageId)
                .userId(userId)
                .subject(subject)
                .message(message)
                .build()
        def targets = ["sms", "email"]

        and:
        MessageSender smsStrategy = Mock()
        MessageSender emailStrategy = Mock()
        MessageSender pushStrategy = Mock()
        smsStrategy.getSupportedTarget() >> "sms"
        emailStrategy.getSupportedTarget() >> "email"
        pushStrategy.getSupportedTarget() >> "push"
        smsStrategy.support("sms") >> true
        emailStrategy.support("email") >> true
        pushStrategy.support("push") >> true

        and:
        MessageProcessor messageProcessor = new MessageProcessorService([smsStrategy, emailStrategy, pushStrategy])

        when:
        messageProcessor.process(messageWrapper, targets)

        then:
        1 * smsStrategy.send(message)
        1 * emailStrategy.send(message)
        0 * pushStrategy.send(message)
    }

}
