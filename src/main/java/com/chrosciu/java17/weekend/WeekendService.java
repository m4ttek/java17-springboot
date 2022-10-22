package com.chrosciu.java17.weekend;

import org.springframework.stereotype.Service;

import static com.chrosciu.java17.weekend.Day.SUNDAY;

@Service
public class WeekendService {

    private static final String NO_CHANCE = """
            <div style="border: solid; padding: 2px">
                <div>Kiedyś na pewno będzie, ale na razie.... :(</div>
            <div>
            """;
    private static final String HOPE = """
            <div style="border: dotted; border-color: green; padding: 2px">
                <div>Jest nadzieja że się zbliża :)</div>
            <div>
            """;
    private static final String ALMOST = """
            <div>
                <div style="color: red">Już prawie !</div>
            <div>
            """;
    private static final String IN_PROGRESS = """
            <div>
                <div style="color: blue">Chwilo trwaj!</div>
            <div>
            """;

    public String whenWillBeWeekend(Day day) {
        return switch (day) {
            case MONDAY, TUESDAY -> NO_CHANCE;
            case WEDNESDAY, THURSDAY -> HOPE;
            case FRIDAY -> ALMOST.repeat(2);
            case SATURDAY, SUNDAY -> {
               var result = IN_PROGRESS;
               if (SUNDAY == day) {
                   result = result.replace("!", " - bo wiele już nie zostało :(");
               }
               yield result;
            }
        };
    }
}
