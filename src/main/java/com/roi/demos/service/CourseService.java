package com.roi.demos.service;

import com.roi.demos.domain.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {
    public Mono<Course> getSampleCourse();

    Flux<Course> getCurrentCourses();

    Mono<Course> findCourseById(long id);
}
