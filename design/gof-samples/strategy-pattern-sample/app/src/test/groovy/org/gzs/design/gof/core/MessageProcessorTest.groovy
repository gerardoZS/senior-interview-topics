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
        1 * smsStrategy.send(messageWrapper)
        1 * emailStrategy.send(messageWrapper)
        0 * pushStrategy.send(messageWrapper)
    }

    def "fails when trying to send a message to an unsupported target"() {
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
        def unsupportedTargets = ["push", "sqs"]

        and:
        MessageSender emailStrategy = Mock()
        emailStrategy.getSupportedTarget() >> "email"
        emailStrategy.support("email") >> true

        and:
        MessageProcessor messageProcessor = new MessageProcessorService([emailStrategy])

        when:
        messageProcessor.process(messageWrapper, unsupportedTargets)

        then:
        thrown(IllegalArgumentException)
        0 * emailStrategy.send(messageWrapper)
    }

}
