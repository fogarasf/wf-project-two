package com.roi.demos.service;

import com.roi.demos.domain.Course;
import reactor.core.publisher.Mono;

public interface CourseService {
    public Mono<Course> getSampleCourse();
}
