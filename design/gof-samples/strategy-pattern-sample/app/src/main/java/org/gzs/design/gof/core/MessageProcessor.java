package org.gzs.design.gof.core;

import java.util.List;

/**
 * Interface that represents a message processor.
 */
public interface MessageProcessor {

    /**
     * Process a message that must be sent to the specified targets.
     * @param messageWrapper An instance of {@link MessageWrapper}.
     * @param targets The targets.
     */
    void process(MessageWrapper messageWrapper, List<String> targets);
}
