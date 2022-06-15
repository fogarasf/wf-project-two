package com.roi.demos.controller;

import com.roi.demos.domain.Course;
import com.roi.demos.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping(path = "/catalog/{publisher:\\w+}",            produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
    private final CourseService courseService;

    @GetMapping(path = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Course> sampleCourse() {
        return courseService.getSampleCourse();
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Course> getCurrentCourses() {
        return courseService.getCurrentCourses();
    }

    @GetMapping("/{id}")
    public Mono<Course> findCourseById(
            @PathVariable("id") long id) {
        return courseService.findCourseById(id);
    }
/*

    @GetMapping("/{crsnumber:\\d\\d\\d\\d?}")
    public Mono<Course> findByCourseNumber(
            @PathVariable("crsnumber") int catalogNumber) {
        return this.courseSvc.getCourseById(catalogNumber);
    }

    @GetMapping("/{category:\\d\\d\\d}/{keywords:[a z]+}")
    public Flux<Course> findByTopic(
            @PathVariable("category") int category,
            @PathVariable("keywords") String keys) {
        return this.courseSvc.findCoursesInCategory(category, keys);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Course> courseReqeust(
            @PathVariable("publisher") String subscriberId,
            @RequestBody Course crsDetails) {
        return this.catalogSvc.requestNewCourse(subscriberId, crsDetails);
    }*/

}