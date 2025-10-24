package web;

import java.util.Objects;

public class Instructor {
    // Fields
    private String name;
    private int id;
    private String description;
    private String awards;

    // Default constructor
    public Instructor() {
        this.name = "";
        this.id = 0;
        this.description = "";
        this.awards = "";
    }

    // Constructor
    public Instructor(String name, String description, String awards) {
        this.name = name;
        this.description = description;
        this.awards = awards;
    }
    
    public Instructor(int id, String name, String description, String awards) {
    	this.id = id;
        this.name = name;
        this.description = description;
        this.awards = awards;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAwards() {
        return awards;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    // equals and hashCode based on name only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instructor)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // toString
    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", awards='" + awards + '\'' +
                '}';
    }
}