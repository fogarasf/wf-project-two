package com.roi.demos.controller;

import com.roi.demos.controller.CourseController;
import com.roi.demos.domain.Course;
import com.roi.demos.persistence.FauxDataService;
import com.roi.demos.service.CourseService;
import com.roi.demos.service.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CourseControllerTest {

    private final CourseService courseSvc = new CourseServiceImpl(new FauxDataService());
    private final WebTestClient client =
            WebTestClient.bindToController(new CourseController(courseSvc))
                    .configureClient().baseUrl("/course").build();

    @Test
    public void sampleCourse() {
        this.client.get()
                .uri("/sample")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Course.class).value(courses ->
                        assertTrue(courses.contains(new Course(0L, "Sample course")))
                );
    }

    @Test
    void contextLoads() {
    }

    @Test
    void findCourseById() {
        this.client.get()
                .uri("/3")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Course.class).value(courses ->
                        assertTrue(courses.contains(new Course(3L, "Sample course 3")))
                );
    }

    @Test
    void getCurrentCourses() {
        this.client.get()
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Course.class).value(courses ->
                        assertTrue(courses.contains(new Course(2L, "Sample course 2")))
                );
    }
}
