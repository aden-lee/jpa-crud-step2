package com.testjpa.jpademo.service;

import java.util.List;

import com.testjpa.jpademo.dto.ClassRoomRequestDto;
import com.testjpa.jpademo.dto.ClassRoomResponseDto;

public interface ClassRoomService {
    List<ClassRoomResponseDto> findAll();

    Integer save(ClassRoomRequestDto classRoomRequestDto);

    Integer update(Integer cid, ClassRoomRequestDto classRoomRequestDto);

    Integer delete(Integer cid);
}
