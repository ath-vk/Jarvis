package com.project.jarvis.entity;

import com.project.jarvis.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;

    ChatSession chatSession;

    String content;

    MessageRole role;

    String toolCalls; // json array of tools calls

    Integer tokenUsed;

    Instant  createdAt;
    Instant deletedAt;
}
