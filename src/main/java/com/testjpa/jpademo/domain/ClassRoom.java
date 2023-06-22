package com.testjpa.jpademo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ClassRoom { // 테이블명과 매핑됨 -> class_room으로 치환됨.
    @Id //PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment 설정
    private int cid;

    private String className;

    private String teacher;

    @CreationTimestamp // insert 시점 시간자동입력
    private String created;

    @UpdateTimestamp // update 시점 시간 자동입력
    private String updated;

    @Builder
    public ClassRoom (int cid, String className, String teacher) {
        this.cid = cid;
        this.className = className;
        this.teacher = teacher;
    }

    //update api 호출에서 사용
    public void update (int cid, String className, String teacher) {
        this.cid = cid;
        this.className = className;
        this.teacher = teacher;
    }
}
