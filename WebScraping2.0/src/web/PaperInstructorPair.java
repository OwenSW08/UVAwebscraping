package web;

import java.util.Objects;

public class PaperInstructorPair {
    // Fields
    private int paperId;
    private int instructorId;

    // Default constructor
    public PaperInstructorPair() {
        this.paperId = 0;
        this.instructorId = 0;
    }

    // Constructor
    public PaperInstructorPair(int paperId, int instructorId) {
        this.paperId = paperId;
        this.instructorId = instructorId;
    }

    // Getters
    public int getPaperId() {
        return paperId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    // Setters
    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    // equals and hashCode (based on paperId + instructorId)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaperInstructorPair)) return false;
        PaperInstructorPair that = (PaperInstructorPair) o;
        return paperId == that.paperId &&
               instructorId == that.instructorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperId, instructorId);
    }

    // toString
    @Override
    public String toString() {
        return "PaperInstructorPair{" +
                "paperId=" + paperId +
                ", instructorId=" + instructorId +
                '}';
    }
}