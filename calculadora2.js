//Numeros
var boton1 = document.getElementById("1");
var boton2 = document.getElementById("2");
var boton3 = document.getElementById("3");
var boton4 = document.getElementById("4");
var boton5 = document.getElementById("5");
var boton6 = document.getElementById("6");
var boton7 = document.getElementById("7");
var boton8 = document.getElementById("8");
var boton9 = document.getElementById("9");
var boton0 = document.getElementById("0");

//Pantalla
var display = document.getElementById("display");

//Botones
var botonMas = document.getElementById("mas");
var botonMenos = document.getElementById("menos");
var botonMulti = document.getElementById("multi");
var botonDiv = document.getElementById("div");
var botonIgual = document.getElementById("igual");

//Numeros
boton1.addEventListener("click", function () {
    display.value = display.value + "1 ";
});
boton2.addEventListener("click", function () {
    display.value = display.value + "2 ";
});
boton3.addEventListener("click", function () {
    display.value = display.value + "3 ";
});
boton4.addEventListener("click", function () {
    display.value = display.value + "4 ";
});
boton5.addEventListener("click", function () {
    display.value = display.value + "5 ";
});
boton6.addEventListener("click", function () {
    display.value = display.value + "6 ";
});
boton7.addEventListener("click", function () {
    display.value = display.value + "7 ";
});
boton8.addEventListener("click", function () {
    display.value = display.value + "8 ";
});
boton9.addEventListener("click", function () {
    display.value = display.value + "9 ";
});
boton0.addEventListener("click", function () {
    display.value = display.value + "0 ";
});

//Operaciones
botonMas.addEventListener("click", function () {
    display.value = display.value + "+ ";
});
botonMenos.addEventListener("click", function () {
    display.value = display.value + "- ";
});
botonMulti.addEventListener("click", function () {
    display.value = display.value + "* ";
});
botonDiv.addEventListener("click", function () {
    display.value = display.value + "/ ";
});
botonIgual.addEventListener("click", function () {
    display.value = display.value + "= ";
});