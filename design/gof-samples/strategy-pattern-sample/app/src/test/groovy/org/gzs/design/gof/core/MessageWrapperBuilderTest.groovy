package org.gzs.design.gof.core

import spock.lang.Specification

class MessageWrapperBuilderTest extends Specification {
    def "Gets an instance of MessageWrapperBuilder"() {
        expect:
        MessageWrapper.MessageWrapperBuilder.isInstance(MessageWrapper.builder())
    }
}
