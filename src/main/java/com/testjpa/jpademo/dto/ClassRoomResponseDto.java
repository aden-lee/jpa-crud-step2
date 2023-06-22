package com.testjpa.jpademo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.testjpa.jpademo.domain.ClassRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassRoomResponseDto {
    private int cid;

    private String className;

    private String teacher;

    private String created;

    private String updated;

    public ClassRoomResponseDto(ClassRoom classRoom) {
        this.cid = classRoom.getCid();
        this.className = classRoom.getClassName();
        this.teacher = classRoom.getTeacher();
        this.created = classRoom.getCreated();
        this.updated = classRoom.getUpdated();
    }
}
