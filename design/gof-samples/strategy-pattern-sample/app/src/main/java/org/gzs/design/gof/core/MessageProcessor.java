package org.gzs.design.gof.core;

import java.util.List;

/**
 * Interface that represents a message processor.
 */
public interface MessageProcessor {

    /**
     * Process a message that must be sent to the specified targets.
     * @param message Message.
     * @param targets Targets to which the message will be sent.
     */
    void process(String message, List<String> targets);
}
