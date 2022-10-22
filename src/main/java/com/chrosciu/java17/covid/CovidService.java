package com.chrosciu.java17.covid;

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
    private static final Set<String> ALLOWED = new HashSet<String>() {{
        add(POSITIVE);
        add(NEGATIVE);
    }};

    @SneakyThrows
    public CovidTestResults analyzeTestsResults() {
        try (InputStream inputStream = new ClassPathResource(RESULTS_FILE_PATH).getInputStream();
             Scanner scanner = new Scanner(inputStream).useDelimiter(SEPARATOR)) {
            Stream<String> tokens = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED), false);
            return tokens
                    .filter(ALLOWED::contains)
                    .map(POSITIVE::equals)
                    .reduce(CovidTestResults.builder().total(0).positive(0).build(),
                            (r, positive) -> CovidTestResults
                            .builder()
                            .total(r.getTotal() + 1)
                            .positive(positive ? r.getPositive() + 1 : r.getPositive())
                            .build(),
                            (r1, r2) -> CovidTestResults
                                    .builder()
                                    .total(r1.getTotal() + r2.getTotal())
                                    .positive(r1.getPositive() + r1.getPositive())
                                    .build()
                    );


        }
    }
}
