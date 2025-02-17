package org.gzs.design.gof.core

import spock.lang.Specification

class MessageProcessorTest extends Specification {

    def "receives a message and send it to the specified targets using sender mockups"() {
        given:
        def targets = ["sms", "email"]
        String message = "Hello world!"
        MessageSender smsStrategy = Mock()
        MessageSender emailStrategy = Mock()
        MessageSender pushStrategy = Mock()
        MessageProcessor messageProcessor = new MessageProcessorService([smsStrategy, emailStrategy, pushStrategy])

        and:
        smsStrategy.support("sms") >> true
        emailStrategy.support("email") >> true
        pushStrategy.support("push") >> true

        when:
        messageProcessor.process(message, targets)

        then:
        1 * smsStrategy.send(message)
        1 * emailStrategy.send(message)
        0 * pushStrategy.send(message)
    }

}
