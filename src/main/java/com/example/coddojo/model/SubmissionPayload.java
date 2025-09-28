package com.example.coddojo.model;

import jakarta.validation.constraints.NotBlank;

public class SubmissionPayload {
    @NotBlank
    private String problemId;
    @NotBlank
    private String language;
    @NotBlank
    private String sourceCode;

    // getters/setters
    public String getProblemId() { return problemId; }
    public void setProblemId(String problemId) { this.problemId = problemId; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getSourceCode() { return sourceCode; }
    public void setSourceCode(String sourceCode) { this.sourceCode = sourceCode; }
}
