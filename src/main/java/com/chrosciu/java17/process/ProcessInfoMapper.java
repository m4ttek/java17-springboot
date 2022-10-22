package com.chrosciu.java17.process;

import org.springframework.stereotype.Service;

@Service
public class ProcessInfoMapper {
    public ProcessInfo toProcessInfo(ProcessHandle processHandle) {
        var info = processHandle.info();
        return ProcessInfo.builder()
                .pid(processHandle.pid())
                .command(info.command().orElse("(N/A"))
                .commandLine(info.commandLine().orElse("N/A"))
                .startInstant(info.startInstant().orElse(null))
                .user(info.user().orElse("N/A"))
                .build();
    }

}
