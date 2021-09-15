var btnAgregar = document.getElementById("agregar");
var textTarea = document.getElementById("tarea");
var listTareas = document.getElementById("tareas");

btnAgregar.addEventListener("click", agregar);

function agregar() {
    let tarea = document.createElement("li");
    tarea.textContent = textTarea.value;
    listTareas.appendChild(tarea);
}