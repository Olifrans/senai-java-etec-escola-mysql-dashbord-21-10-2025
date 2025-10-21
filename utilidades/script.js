let grafico;

// Carregar JSON e inicializar
async function carregarDados(anoSelecionado = "2025") {
  const response = await fetch("dados.json");
  const dados = await response.json();

  atualizarDashboard(dados[anoSelecionado]);
  atualizarGrafico(dados[anoSelecionado].matriculas);
}

// Atualizar Cards e Alertas
function atualizarDashboard(info) {
  document.getElementById("matriculas").textContent = info.cards.matriculas;
  document.getElementById("pendentes").textContent = info.cards.pendentes;
  document.getElementById("professores").textContent = info.cards.professores;
  document.getElementById("cursos").textContent = info.cards.cursos;

  const lista = document.getElementById("lista-alertas");
  lista.innerHTML = "";
  info.alerts.forEach(msg => {
    const div = document.createElement("div");
    div.className = "alert";
    div.textContent = msg;
    lista.appendChild(div);
  });
}

// Criar ou atualizar gráfico
function atualizarGrafico(dados) {
  if (grafico) {
    grafico.data.datasets[0].data = dados;
    grafico.update();
    return;
  }

  const ctx = document.getElementById("graficoMatriculas");
  grafico = new Chart(ctx, {
    type: 'line',
    data: {
      labels: ["Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"],
      datasets: [{
        label: "Matrículas",
        data: dados,
        borderColor: "#e30613",
        backgroundColor: "rgba(227,6,19,0.2)",
        fill: true,
        tension: 0.3
      }]
    },
    options: { responsive: true, plugins: { legend: { position: 'top' } } }
  });
}

// Evento para troca de ano
document.getElementById("ano").addEventListener("change", (e) => {
  carregarDados(e.target.value);
});

// Inicializar com ano padrão
carregarDados();



//
//
//Perfeito 🚀
//Vamos adicionar o modo escuro (dark mode) com um botão que alterna entre claro e escuro no seu dashboard.
//
//Isso vai dar um toque profissional e realista ao sistema.
//
//🔧 Alterações
//1️⃣ index.html
//
//Adicione um botão de alternância no header:
//
//<header>
//  📊 Dashboard Escolar - SENAI
//  <button id="toggleDarkMode">🌙</button>
//</header>
//
//2️⃣ style.css
//
//Adicione estilos para o botão e o modo escuro:
//
///* Botão de dark mode */
//header {
//  display: flex;
//  justify-content: space-between;
//  align-items: center;
//}
//
//#toggleDarkMode {
//  background: white;
//  border: none;
//  padding: 8px 12px;
//  border-radius: 8px;
//  cursor: pointer;
//  font-size: 1rem;
//  transition: 0.3s;
//}
//#toggleDarkMode:hover {
//  background: #ddd;
//}
//
///* ===== DARK MODE ===== */
//body.dark {
//  background: #121212;
//  color: #e0e0e0;
//}
//
//body.dark header {
//  background: #1f1f1f;
//  color: #fff;
//}
//
//body.dark .card,
//body.dark .chart-container,
//body.dark .alerts {
//  background: #1f1f1f;
//  color: #e0e0e0;
//  box-shadow: 0 4px 6px rgba(255,255,255,0.1);
//}
//
//body.dark .alert {
//  background: #2b2b2b;
//  border-left: 5px solid #ff4d4d;
//}
//
//body.dark #toggleDarkMode {
//  background: #333;
//  color: #fff;
//}
//body.dark #toggleDarkMode:hover {
//  background: #444;
//}
//
//3️⃣ script.js
//
//Adicione o controle do botão:
//
//// Dark Mode
//const toggleBtn = document.getElementById("toggleDarkMode");
//toggleBtn.addEventListener("click", () => {
//  document.body.classList.toggle("dark");
//
//  // Atualiza ícone do botão
//  if (document.body.classList.contains("dark")) {
//    toggleBtn.textContent = "☀️";
//  } else {
//    toggleBtn.textContent = "🌙";
//  }
//});
//
//🎨 Como vai funcionar
//
//O sistema inicia em modo claro ☀️.
//
//Ao clicar no botão 🌙 → ativa o modo escuro.
//
//O botão muda automaticamente para ☀️ quando o modo escuro estiver ativo.
//
//👉 Quer que eu adicione também a memória da preferência do usuário (ou seja, salvar no localStorage se ele deixou em claro ou escuro e carregar assim na próxima visita)?
