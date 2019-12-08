function searchIcon() {
  element = document.getElementById("search-icon");
  element.classList.toggle("search-active");
  console.log("foi");
}

function change(n) {
  const painel = document.getElementById("painel");
  const graficos = document.getElementById("graficos");
  const consultas = document.getElementById("consultas");

  painel.classList.remove("view");
  graficos.classList.remove("view");
  consultas.classList.remove("view");
  painel.classList.add("hidden");
  graficos.classList.add("hidden");
  consultas.classList.add("hidden");

  switch (n) {
    case 0:
      painel.classList.add("view");
      break;
    case 1:
      graficos.classList.add("view");
      break;
    case 2:
      consultas.classList.add("view");
      break;
    default:
      break;
  }
}
