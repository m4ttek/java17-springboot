package com.chrosciu.java15.process;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ProcessInfo {
    private long pid;
    private String command;
    private String commandLine;
    private Instant startInstant;
    private String user;
}
