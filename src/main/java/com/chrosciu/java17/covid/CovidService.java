package com.chrosciu.java17.covid;

import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class CovidService {
    private static final String RESULTS_FILE_PATH = "covid-tests-results.txt";
    private static final String SEPARATOR = " ";
    private static final String POSITIVE = "+";
    private static final String NEGATIVE = "-";
    private static final Set<String> ALLOWED = Set.of(POSITIVE, NEGATIVE);

    @SneakyThrows
    public CovidTestResults analyzeTestsResults() {
        var inputStream = new ClassPathResource(RESULTS_FILE_PATH).getInputStream();
        var scanner = new Scanner(inputStream).useDelimiter(SEPARATOR);
        try (inputStream; scanner) {
            var tokens = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED), false);
            return tokens
                    .filter(ALLOWED::contains)
                    .collect(Collectors.teeing(
                            Collectors.counting(),
                            Collectors.filtering(POSITIVE::equals, Collectors.counting()),
                            CovidTestResults::new));
        }
    }
}
