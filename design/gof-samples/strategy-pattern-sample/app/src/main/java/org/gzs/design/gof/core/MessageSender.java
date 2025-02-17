package org.gzs.design.gof.core;

/**
 * Interface that represents a message sender for a specific target.
 */
public interface MessageSender {

    /**
     * Indicates if the message sender support the specified target;
     * @param target Specified target.
     * @return {@code true} if the target is supported, {@code false} otherwise.
     */
    default boolean support(String target) {
        return getSupportedTarget().equalsIgnoreCase(target);
    }

    /**
     * Returns the supported target of this message sender.
     * @return The supported target.
     */
    String getSupportedTarget();

    /**
     * Sends a message for a specific target.
     *
     * @param message Message to send.
     */
    void send(String message);
}
