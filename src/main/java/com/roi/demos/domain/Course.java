package com.roi.demos.domain;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    private long id;

    private String title;
}
