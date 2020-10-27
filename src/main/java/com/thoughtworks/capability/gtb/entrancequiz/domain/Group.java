package com.thoughtworks.capability.gtb.entrancequiz.domain;

import java.util.List;

public class Group {
    private List<Student> students;

    public Group(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
