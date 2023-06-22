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
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    private String className;

    private String teacher;

    @CreationTimestamp
    private String created;

    @UpdateTimestamp
    private String updated;

    @Builder
    public ClassRoom (int cid, String className, String teacher) {
        this.cid = cid;
        this.className = className;
        this.teacher = teacher;
    }

    public void update (int cid, String className, String teacher) {
        this.cid = cid;
        this.className = className;
        this.teacher = teacher;
    }
}
