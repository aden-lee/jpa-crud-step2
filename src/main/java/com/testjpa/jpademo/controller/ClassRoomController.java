package com.testjpa.jpademo.controller;

import java.util.List;

import com.testjpa.jpademo.dto.ClassRoomRequestDto;
import com.testjpa.jpademo.dto.ClassRoomResponseDto;
import com.testjpa.jpademo.service.ClassRoomService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassRoomController {

    private final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    /**
     * 학급 목록 조회
     * @return
     */
    @GetMapping("")
    public List<ClassRoomResponseDto> findAll(){
        return classRoomService.findAll();
    }

    /**
     * 학급 추가
     * @return
     */
    @PostMapping("")
    public Integer save(@RequestBody ClassRoomRequestDto classRoomRequestDto){
        return classRoomService.save(classRoomRequestDto);
    }

    /**
     * 학급 수정
     * @return
     */
    @PutMapping("/{cid}")
    public Integer update(@PathVariable Integer cid, @RequestBody ClassRoomRequestDto classRoomRequestDto){
        return classRoomService.update(cid, classRoomRequestDto);
    }

    /**
     * 학급 삭제
     * @return
     */
    @DeleteMapping("/{cid}")
    public Integer delete(@PathVariable Integer cid){
        return classRoomService.delete(cid);
    }
}
