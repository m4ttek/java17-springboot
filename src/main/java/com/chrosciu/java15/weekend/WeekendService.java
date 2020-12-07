package com.chrosciu.java15.weekend;

import org.springframework.stereotype.Service;

import static com.chrosciu.java15.weekend.Day.SUNDAY;

@Service
public class WeekendService {
    private static final String NO_CHANCE = "" +
            "            <div style=\"border: solid; padding: 2px\">\n" +
            "                <div>Kiedyś na pewno będzie, ale na razie.... :(</div>\n" +
            "            <div>";
    private static final String HOPE = "" +
            "            <div style=\"border: dotted; border-color: green; padding: 2px\">\n" +
            "                <div>Jest nadzieja że się zbliża :)</div>\n" +
            "            <div>";
    private static final String ALMOST = "" +
            "            <div>\n" +
            "                <div style=\"color: red\">Już prawie !</div>\n" +
            "            <div>";
    private static final String IN_PROGRESS = "" +
            "            <div>\n" +
            "                <div style=\"color: blue\">Chwilo trwaj!</div>\n" +
            "            <div>";

    public String whenWillBeWeekend(Day day) {
        switch (day) {
            case MONDAY:
            case TUESDAY:
                return NO_CHANCE;
            case WEDNESDAY:
            case THURSDAY:
                return HOPE;
            case FRIDAY:
                return ALMOST + ALMOST;
            case SATURDAY:
            case SUNDAY:
                String result = IN_PROGRESS;
                if (SUNDAY == day) {
                    result = result.replace("!", " - bo wiele już nie zostało :(");
                }
                return result;
        }
        throw new IllegalArgumentException("Unknown day");
    }
}
