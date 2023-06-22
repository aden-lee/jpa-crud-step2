package com.testjpa.jpademo.dto;

import com.testjpa.jpademo.domain.ClassRoom;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassRoomRequestDto {

    private String className;

    private String teacher;

    public ClassRoom toEntity(){
        return ClassRoom.builder()
                .className(className)
                .teacher(teacher)
                .build();
    }
}
