package com.chrosciu.java17.process;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class ProcessInfo {
    long pid;
    String command;
    String commandLine;
    Instant startInstant;
    String user;
}
