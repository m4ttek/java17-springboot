package com.chrosciu.java17.process;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessService {

    public List<ProcessInfo> getAllAliveProcesses() {
        return ProcessHandle.allProcesses()
                .filter(ProcessHandle::isAlive)
                .map(ph -> ProcessInfo
                        .builder()
                        .pid(ph.pid())
                        .user(ph.info().user().orElse("N/A"))
                        .commandLine(ph.info().commandLine().orElse("N/A"))
                        .build())
                .toList();
    }

    public ProcessHandle getCurrentProcess() {
        return ProcessHandle.current();
    }

    public void destroyProcess(long pid) {
        ProcessHandle.of(pid)
                .ifPresent(ProcessHandle::destroy);
    }
}
