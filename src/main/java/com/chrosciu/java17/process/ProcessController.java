package com.chrosciu.java17.process;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/process")
@RequiredArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @GetMapping
    public List<ProcessInfo> getAllAliveProcesses() {
        return processService.getAllAliveProcesses();
    }

    @GetMapping("/current")
    public ProcessHandle getCurrentProcess() {
        return processService.getCurrentProcess();
    }

    @PostMapping("/kill")
    public void destroyProcess(@RequestParam("pid") long pid) {
        processService.destroyProcess(pid);
    }

}
