function boton4() {
    window.alert("Mensaje4");
}

function boton1() {
    window.alert("Mensaje1");
}

//Defino una variable btnEnviar1 la cual apunta al elemento HTML con id btnEnviar1
var btnEnviar1 = document.getElementById("btnEnviar1");
//Se agrega listener para cachar el evento de clic en el boton
//la accion que ocurrira al dar clic esta determinada por una funcion anonima
btnEnviar1.addEventListener("click", function () {
                                        window.alert("Mensaje1")
                                    });

//Una funcion callbak se llama sin parentesis
//La funcion call back significa transferir el control a

var btnEnviar5 = document.getElementById("btnEnviar5");
btnEnviar5.addEventListener("click", callback);
function callback() {
    cambiarColor();
    cambiarEstado();
}

var emailHelp = document.getElementById("emailHelp");
function cambiarColor() {
    emailHelp.style.color = "red";
}

var exampleCheck1 = document.getElementById("exampleCheck1");
function cambiarEstado() {
    exampleCheck1.checked = true;
}