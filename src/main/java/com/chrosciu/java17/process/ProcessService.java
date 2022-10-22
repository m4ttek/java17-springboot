package com.chrosciu.java17.process;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessService {

    public List<ProcessInfo> getAllAliveProcesses() {
        //TODO : Implement
        return Collections.emptyList();
    }

    public void destroyProcess(long pid) {
        //TODO : Implement
    }
}
