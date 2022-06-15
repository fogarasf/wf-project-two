package com.roi.demos.domain;

import lombok.*;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private UUID id;

    private String firstName;
}
