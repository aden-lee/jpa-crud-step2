CREATE TABLE IF NOT EXISTS `class_room` (
       `cid` INT(11) NOT NULL AUTO_INCREMENT COMMENT '학생아이디',
       `class_name` VARCHAR(20) NULL DEFAULT NULL COMMENT '학급이름',
       `teacher` VARCHAR(20) NULL DEFAULT NULL COMMENT '선생이름',
       `created` DATETIME NULL DEFAULT NULL COMMENT '등록일자',
       `updated` DATETIME NULL DEFAULT NULL COMMENT '수정일자',
       PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `student` (
      `sid` INT(11) NOT NULL AUTO_INCREMENT,
      `cid` INT(11) NOT NULL DEFAULT 0,
      `student_name` VARCHAR(20) NULL DEFAULT '' COMMENT '학생이름',
      PRIMARY KEY (`sid`),
      INDEX `FK_class_room_student` (`cid`),
      CONSTRAINT `FK_class_room_student` FOREIGN KEY (`cid`) REFERENCES `class_room` (`cid`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
