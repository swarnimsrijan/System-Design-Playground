package entity;

import enums.IssueType;

import java.util.List;
import java.util.Queue;

public class Agent {
    private String id;
    private String name;
    private String email;
    private List<IssueType> expertise;
    private String assignedIssueId;
    private List<String> history;
    private Queue<String> waitlist;

    public Agent(String id, String name, String email, List<IssueType> expertise) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.expertise = expertise;
        this.assignedIssueId = assignedIssueId;
        this.history = history;
    }

    public boolean isAvailable() { return assignedIssueId == null; }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IssueType> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<IssueType> expertise) {
        this.expertise = expertise;
    }

    public String getAssignedIssueId() {
        return assignedIssueId;
    }

    public void setAssignedIssueId(String assignedIssueId) {
        this.assignedIssueId = assignedIssueId;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public Queue<String> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(Queue<String> waitlist) {
        this.waitlist = waitlist;
    }

}
