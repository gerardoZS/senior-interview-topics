package org.gzs.design.gof.core;

import java.util.UUID;

public record MessageWrapper(UUID messageId, UUID userId, String subject, String message) {
}