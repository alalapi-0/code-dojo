package com.example.coddojo.model;

import java.util.List;

public class Problem {
    private String id;
    private String title;
    private String language; // java/python/...
    private String starterCode;
    private String description;
    private List<TestCase> tests;

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getStarterCode() { return starterCode; }
    public void setStarterCode(String starterCode) { this.starterCode = starterCode; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<TestCase> getTests() { return tests; }
    public void setTests(List<TestCase> tests) { this.tests = tests; }
}
