package org.gzs.design.gof.core

import spock.lang.Specification

class MessageSenderTest extends Specification {

    MessageSender messageSender;

    def setup() {
        messageSender = new MessageSender() {
            @Override
            String getSupportedTarget() {
                return "email"
            }

            @Override
            void send(MessageWrapper messageWrapper) {
            }
        }
    }


    def "checks if the target is supported"(String target, boolean expected) {
        expect:
        messageSender.support(target) == expected

        where:
        target  | expected
        "email" | true
        "push"  | false
    }
}
