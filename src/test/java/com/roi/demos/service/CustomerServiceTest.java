package com.roi.demos.service;

import com.roi.demos.domain.Course;
import com.roi.demos.persistence.FauxDataService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {
    private CourseService courseService = new CourseServiceImpl(new FauxDataService());

    @Test
    public void testGetSampleCourseBlocking() {
        //When
        Mono<Course> sampleCourse = courseService.getSampleCourse();

        //Then
        assertEquals("Sample course", sampleCourse.block().getTitle());
    }


    @Test
    public void testGetSampleCourseNonBlocking() {
        //When
        Mono<Course> sampleCourse = courseService.getSampleCourse();

        //Then
        //sampleCourse.subscribe(result -> assertEquals("Sample course", result.getTitle()));
        StepVerifier.create(sampleCourse)
                .expectNext(Course.builder().title("Sample course").build())
                .verifyComplete();
    }

    @Test
    public void testGetCurrentCoursesNonBlocking() {
        //When
        Flux<Course> currentCourses = courseService.getCurrentCourses();

        //Then
        StepVerifier.create(currentCourses)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    public void testFindCourseByIdNonBlocking() {
        //When
        Mono<Course> sampleCourse = courseService.findCourseById(2L);

        //Then
        StepVerifier.create(sampleCourse)
                .expectNext(Course.builder().id(2L).title("Sample course 2").build())
                .verifyComplete();
    }

}
