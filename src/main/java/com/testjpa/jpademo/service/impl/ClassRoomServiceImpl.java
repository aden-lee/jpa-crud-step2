package com.testjpa.jpademo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.testjpa.jpademo.domain.ClassRoom;
import com.testjpa.jpademo.dto.ClassRoomRequestDto;
import com.testjpa.jpademo.dto.ClassRoomResponseDto;
import com.testjpa.jpademo.repository.ClassRoomRepository;
import com.testjpa.jpademo.service.ClassRoomService;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ClassRoomRepository classRoomRepository;

    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public List<ClassRoomResponseDto> findAll() {
        List<ClassRoom> classRoom = classRoomRepository.findAll();
        return classRoom.stream().map(ClassRoomResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public Integer save(ClassRoomRequestDto classRoomRequestDto) {
        ClassRoom classRoom = classRoomRepository.save(classRoomRequestDto.toEntity());
        return classRoom.getCid();
    }

    @Override
    @Transactional
    public Integer update(Integer cid, ClassRoomRequestDto param) {
        ClassRoom classRoom = classRoomRepository.findById(cid).orElseThrow(() -> new RuntimeException("Not found cid"));
        classRoom.update(cid, param.getClassName(), param.getTeacher());
        return cid;
    }

    @Override
    public Integer delete(Integer cid) {
        classRoomRepository.deleteById(cid);
        return cid;
    }

}
