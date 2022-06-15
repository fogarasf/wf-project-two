package com.roi.demos.controller;

import com.roi.demos.controller.CourseController;
import com.roi.demos.domain.Course;
import com.roi.demos.service.CourseService;
import com.roi.demos.service.CourseServiceFaux;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseControllerTest {

    private final CourseService courseSvc = new CourseServiceFaux();
    private final WebTestClient client =
            WebTestClient.bindToController(new CourseController(courseSvc))
                    .configureClient().baseUrl("/course").build();
    @Test
    public void consumingEntityList() {
        this.client.get()
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Course.class).value(courses ->
                        assertTrue(courses.contains(new Course("Reactive Spring with Java")))
                );
    }
    @Test
    void contextLoads() {
    }

}
