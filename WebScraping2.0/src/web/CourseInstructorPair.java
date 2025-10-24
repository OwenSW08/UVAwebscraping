package web;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseInstructorPair {
    // Fields
    private int courseId;
    private int instructorId;
    private List<String> semesters;

    // Default constructor
    public CourseInstructorPair() {
        this.courseId = 0;
        this.instructorId = 0;
        this.semesters = new ArrayList<>();
    }

    // Constructor that takes one semester and adds it to the list
    public CourseInstructorPair(int courseId, int instructorId, String semester) {
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.semesters = new ArrayList<>();
        if(semester != null) {
        	this.semesters.add(semester);
        }
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public List<String> getSemesters() {
        return new ArrayList<>(semesters); // Defensive copy
    }

    // Setters
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setSemesters(List<String> semesters) {
        this.semesters = semesters != null ? new ArrayList<>(semesters) : new ArrayList<>();
    }

    // Add a semester
    public void addSemester(String semester) {
        if (!semesters.contains(semester)) {
            semesters.add(semester);
        }
    }

    // equals and hashCode based on courseId and instructorId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseInstructorPair)) return false;
        CourseInstructorPair that = (CourseInstructorPair) o;
        return courseId == that.courseId &&
               instructorId == that.instructorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, instructorId);
    }

    // toString
    @Override
    public String toString() {
        return "CourseInstructorPair{" +
                "courseId=" + courseId +
                ", instructorId=" + instructorId +
                ", semesters=" + semesters +
                '}';
    }
}