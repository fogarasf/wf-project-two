package com.roi.demos.service;

import com.roi.demos.domain.Course;
import com.roi.demos.persistence.FauxDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final FauxDataService dataService;

    @Override
    public Mono<Course> getSampleCourse() {
        return dataService.getSampleCourse();
    }

    @Override
    public Flux<Course> getCurrentCourses() {
        return dataService.getCurrentCourses();
    }

    @Override
    public Mono<Course> findCourseById(long id) {
        return dataService.findCourseById(id);
    }
}
