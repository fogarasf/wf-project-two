package com.roi.demos.service;

import com.roi.demos.domain.Course;
import reactor.core.publisher.Mono;

public class CourseServiceFaux implements CourseService {
    @Override
    public Mono<Course> getSampleCourse() {
        Course course = Course.builder().title("Sample course").build();
        return Mono.just(course);
    }
}
