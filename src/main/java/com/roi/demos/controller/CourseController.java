package com.roi.demos.controller;

import com.roi.demos.domain.Course;
import com.roi.demos.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
    private final CourseService courseSvc;

    public CourseController(CourseService courseSvc) {
        this.courseSvc = courseSvc;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Course> sampleCourse() {
        return courseSvc.getSampleCourse();
    }
}