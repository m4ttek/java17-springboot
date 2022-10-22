package com.chrosciu.java17.covid;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CovidTestResults {
    long total;
    long positive;
}
