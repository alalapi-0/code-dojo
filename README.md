# Code Dojo (MVP)

Maven + Spring Boot 的代码练习网站骨架。内置题库目录结构（Java/Python/其它），提供：
- 页面：主页、练习页（Monaco Editor）
- API：GET /api/problems?lang=java ；POST /api/submit （占位，返回伪结果）
- 题库示例：src/main/resources/problems/<lang>/*.json

## 运行
要求：JDK 17+，Maven 3.9+
```bash
mvn spring-boot:run
# 浏览 http://localhost:8080
```

## 结构

* templates/index.html：入口页
* templates/practice.html：练习页（Monaco Editor）
* static/js/app.js：前端逻辑
* resources/problems：题库（JSON）
* ProblemService：加载/缓存题库
* ProblemController：题目与提交 API
* TODO：接入 Judge0 或自建判题服务

```
