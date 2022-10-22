package com.chrosciu.java17.process;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcessService {
    private final ProcessInfoMapper processInfoMapper;

    public List<ProcessInfo> getAllAliveProcesses() {
        return ProcessHandle.allProcesses()
                .filter(ProcessHandle::isAlive)
                .map(processInfoMapper::toProcessInfo)
                .toList();
    }

    public ProcessHandle getCurrentProcess() {
        return ProcessHandle.current();
    }

    public void destroyProcess(long pid) {
        var processHandle = ProcessHandle.of(pid);
        processHandle.ifPresentOrElse(
                ph -> {if (!ph.destroy()) throw new IllegalStateException("Cannot destroy process");},
                () -> {throw new IllegalArgumentException("No process with given PID found");}
        );
    }
}
