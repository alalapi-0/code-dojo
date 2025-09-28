package com.example.coddojo.controller;

import com.example.coddojo.model.Problem;
import com.example.coddojo.model.SubmissionPayload;
import com.example.coddojo.model.SubmissionResult;
import com.example.coddojo.service.ProblemService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping(value = "/problems", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Problem> list(@RequestParam(defaultValue = "java") String lang) {
        return problemService.loadProblems(lang);
    }

    @PostMapping(value = "/submit", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SubmissionResult submit(@Valid @RequestBody SubmissionPayload payload) {
        // TODO: 调用 Judge0 或自建判题服务
        // 这里先返回“伪通过”结果，便于前端联调
        SubmissionResult res = new SubmissionResult();
        res.setProblemId(payload.getProblemId());
        res.setPassed(true);
        res.setMessage("Stub: 判题未接入，默认通过。稍后对接 Judge0。");
        return res;
    }
}
