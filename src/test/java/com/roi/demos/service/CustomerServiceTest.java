package com.roi.demos.service;

import com.roi.demos.domain.Course;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {
    private CourseService courseService = new CourseServiceFaux();

    @Test
    public void testGetSampleCourseBlocking() {
        //Given

        //When
        Mono<Course> sampleCourse = courseService.getSampleCourse();

        //Then
        assertEquals("Sample course", sampleCourse.block().getTitle());
    }


    @Test
    public void testGetSampleCourseNonBlocking() {
        //Given

        //When
        Mono<Course> sampleCourse = courseService.getSampleCourse();

        //Then
        //sampleCourse.subscribe(result -> assertEquals("Sample course", result.getTitle()));
        StepVerifier.create(sampleCourse)
                .expectNext(Course.builder().title("Sample course").build())
                .verifyComplete();

    }
}
