package com.chrosciu.java17.covid;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidController {
    private final CovidService covidService;

    @GetMapping
    @SneakyThrows
    public CovidTestResults analyzeTestsResults() {
        return covidService.analyzeTestsResults();
    }
}
