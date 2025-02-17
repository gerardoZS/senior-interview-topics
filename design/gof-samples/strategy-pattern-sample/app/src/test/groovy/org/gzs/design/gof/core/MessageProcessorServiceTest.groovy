package org.gzs.design.gof.core

import spock.lang.Specification

class MessageProcessorServiceTest extends Specification {

    def "fails on initialization if message senders for a target are not unique"() {
        given:
        MessageSender smsStrategy1 = Mock()
        MessageSender smsStrategy2 = Mock()
        smsStrategy1.getSupportedTarget() >> "sms"
        smsStrategy2.getSupportedTarget() >> "sms"

        when:
        new MessageProcessorService([smsStrategy1, smsStrategy2])

        then:
        thrown(IllegalArgumentException)
    }

}
