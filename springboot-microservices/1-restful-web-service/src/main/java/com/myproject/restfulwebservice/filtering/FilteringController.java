package com.myproject.restfulwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
    
    @GetMapping("/filtering")
    public FilterBean filtering() {
        return new FilterBean("id1", "name1", "pwd1");
    }

    @GetMapping("/filtering-list")
    public List<FilterBean> filteringList() {
        return Arrays.asList(
            new FilterBean("id2", "name2", "pwd2"),
            new FilterBean("id3", "name3", "pwd3")
        );
    }
}
