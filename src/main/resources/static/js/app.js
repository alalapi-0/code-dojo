let currentProblems = [];
let current = null;

async function loadProblems(lang) {
  const res = await fetch(`/api/problems?lang=${encodeURIComponent(lang)}`);
  currentProblems = await res.json();
  // 简化：取第一题
  current = currentProblems[0];
  const title = document.getElementById('problemTitle');
  const desc = document.getElementById('problemDesc');
  if (current) {
    title.textContent = `${current.title} (${current.language})`;
    desc.textContent = current.description || "";
    if (window.editor) {
      window.editor.setValue(current.starterCode || "");
      // 切换高亮
      const map = { java: "java", python: "python", misc: "javascript" };
      const langName = map[current.language] || "javascript";
      monaco.editor.setModelLanguage(window.editor.getModel(), langName);
    }
  } else {
    title.textContent = "没有题目";
    desc.textContent = "";
  }
}

async function submitSolution() {
  if (!current) return;
  const payload = {
    problemId: current.id,
    language: current.language,
    sourceCode: window.editor ? window.editor.getValue() : ""
  };
  const res = await fetch('/api/submit', {
    method: 'POST',
    headers: { 'Content-Type':'application/json' },
    body: JSON.stringify(payload)
  });
  const data = await res.json();
  document.getElementById('resultBox').textContent =
    `通过: ${data.passed}\n消息: ${data.message}`;
}

document.addEventListener('DOMContentLoaded', () => {
  document.getElementById('loadProblems').addEventListener('click', () => {
    const lang = document.getElementById('lang').value;
    loadProblems(lang);
  });
  document.getElementById('submitBtn').addEventListener('click', submitSolution);
});
