package com.example.coddojo.service;

import com.example.coddojo.model.Problem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class ProblemService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<String, List<Problem>> cache = new HashMap<>();

    public List<Problem> loadProblems(String lang) {
        return cache.computeIfAbsent(lang.toLowerCase(Locale.ROOT), this::loadFromResources);
    }

    private List<Problem> loadFromResources(String lang) {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] files = resolver.getResources("classpath:problems/" + lang + "/*.json");
            List<Problem> list = new ArrayList<>();
            for (Resource r : files) {
                try (InputStream in = r.getInputStream()) {
                    String json = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                    Problem p = mapper.readValue(json, new TypeReference<Problem>(){});
                    list.add(p);
                }
            }
            return list;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
