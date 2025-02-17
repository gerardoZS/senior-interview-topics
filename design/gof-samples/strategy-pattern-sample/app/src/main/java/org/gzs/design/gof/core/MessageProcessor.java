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
     * @throws IllegalArgumentException If a target is not supported.
     */
    void process(MessageWrapper messageWrapper, List<String> targets) throws IllegalArgumentException;
}
