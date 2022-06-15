package com.roi.demos.persistence;

import com.roi.demos.domain.Course;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class FauxDataService {
    //TODO hide
    private List<Course> fauxRepo;

    public FauxDataService() {
        this.fauxRepo =
                Arrays.asList(
                        Course.builder().id(1L).title("Sample course 1").build(),
                        Course.builder().id(2L).title("Sample course 2").build(),
                        Course.builder().id(3L).title("Sample course 3").build()
                );
    }

    public void addCourses(List<Course> newCourses) {
        this.fauxRepo.addAll(newCourses);
    }

    public Mono<Course> getSampleCourse() {
        Course course = Course.builder().id(0L).title("Sample course").build();
        return Mono.just(course);
    }

    public Flux<Course> getCurrentCourses() {
        return Flux.fromIterable(this.fauxRepo);
    }

    public Mono<Course> findCourseById(long id) {
                return getCurrentCourses().filter(c -> id == c.getId()).singleOrEmpty();
    }
}
