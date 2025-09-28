package com.example.coddojo.model;

public class SubmissionResult {
    private String problemId;
    private boolean passed;
    private String message;

    // getters/setters
    public String getProblemId() { return problemId; }
    public void setProblemId(String problemId) { this.problemId = problemId; }
    public boolean isPassed() { return passed; }
    public void setPassed(boolean passed) { this.passed = passed; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
