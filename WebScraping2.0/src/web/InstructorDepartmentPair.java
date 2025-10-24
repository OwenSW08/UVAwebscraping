package web;

import java.util.Objects;

public class InstructorDepartmentPair {
    private int instructorId;
    private int departmentId;

    public InstructorDepartmentPair(int instructorId, int departmentId) {
        this.instructorId = instructorId;
        this.departmentId = departmentId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstructorDepartmentPair)) return false;
        InstructorDepartmentPair that = (InstructorDepartmentPair) o;
        return instructorId == that.instructorId &&
               departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructorId, departmentId);
    }

    @Override
    public String toString() {
        return "InstructorDepartmentPair{" +
                "instructorId=" + instructorId +
                ", departmentId=" + departmentId +
                '}';
    }
}