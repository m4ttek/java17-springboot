package com.chrosciu.java15.covid;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CovidTestResults {
    long total;
    long positive;
}
