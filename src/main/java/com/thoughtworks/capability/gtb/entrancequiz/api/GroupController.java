package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GroupController {

    private List<Student> students = GroupService.initStudents();

    @GetMapping("/students/list")
    public ResponseEntity getStudentList() {
        return ResponseEntity.ok(students);
    }

    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student){
        students.add(student);
        return ResponseEntity.created(null).build();
    }

}

