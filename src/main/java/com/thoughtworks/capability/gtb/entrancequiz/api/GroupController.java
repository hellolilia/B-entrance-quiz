package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GroupController {

    private List<Student> students = GroupService.initStudents();

    private List<Group> groups = GroupService.initGroups();

    // TODO GTB-知识点: - @RestController和ResponseEntity使用重复
    // TODO GTB-工程实践: - ResponseEntity应指定类型参数
    @GetMapping("/students/list")
    public ResponseEntity getStudentList() {
        return ResponseEntity.ok(students);
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody String studentName){
        Student student = new Student(students.size()+1, studentName);
        students.add(student);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/students/group")
    public ResponseEntity getGroupList() {
        return ResponseEntity.ok(groups);
    }

}

