package com.chrosciu.java17.weekend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weekend")
public class WeekendController {
    private final WeekendService weekendService;

    @GetMapping
    public String weekend(@RequestParam("day") Day day) {
        return weekendService.whenWillBeWeekend(day);
    }
}
