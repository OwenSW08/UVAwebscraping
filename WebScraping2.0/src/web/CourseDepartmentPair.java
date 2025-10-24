package web;

import java.util.Objects;

public class CourseDepartmentPair {
    // Fields
    private int courseId;
    private int departmentId;

    // Default constructor
    public CourseDepartmentPair() {
        this.courseId = 0;
        this.departmentId = 0;
    }

    // Constructor
    public CourseDepartmentPair(int courseId, int departmentId) {
        this.courseId = courseId;
        this.departmentId = departmentId;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    // Setters
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // equals and hashCode (based on both fields)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseDepartmentPair)) return false;
        CourseDepartmentPair that = (CourseDepartmentPair) o;
        return courseId == that.courseId &&
               departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, departmentId);
    }

    // toString
    @Override
    public String toString() {
        return "CourseDepartmentPair{" +
                "courseId=" + courseId +
                ", departmentId=" + departmentId +
                '}';
    }
}