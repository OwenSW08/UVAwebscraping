package web;

import java.util.Objects;

public class Course {
    // Fields
    private String department;
    private String number;
    private String name;
    private String description;
    private int id;

    // Constructors
    public Course() {
        this.department = "";
        this.number = "";
        this.name = "";
        this.description = "";
    }

    public Course(String department, String number, String name, String description) {
        this.department = department;
        this.number = number;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    // equals and hashCode based on number and name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return department.equalsIgnoreCase(course.department)
                && number.equalsIgnoreCase(course.number)
                && name.equalsIgnoreCase(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department.toUpperCase(), number.toUpperCase(), name.toUpperCase());
    }

    // toString
    @Override
    public String toString() {
        return "Course{" +
                "department='" + department + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}