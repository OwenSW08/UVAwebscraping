package web;

import java.util.Objects;

public class TopicInstructorPair {
    // Fields
    private int topicId;
    private int instructorId;

    // Constructors
    public TopicInstructorPair() {
        this.topicId = 0;
        this.instructorId = 0;
    }

    public TopicInstructorPair(int topicId, int instructorId) {
        this.topicId = topicId;
        this.instructorId = instructorId;
    }

    // Getters
    public int getTopicId() {
        return topicId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    // Setters
    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    // equals and hashCode based on both topicId and instructorId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopicInstructorPair)) return false;
        TopicInstructorPair that = (TopicInstructorPair) o;
        return topicId == that.topicId &&
               instructorId == that.instructorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId, instructorId);
    }

    // toString
    @Override
    public String toString() {
        return "TopicInstructorPair{" +
                "topicId=" + topicId +
                ", instructorId=" + instructorId +
                '}';
    }
}