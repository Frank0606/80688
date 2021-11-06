var btnRegistrar = document.getElementById("registrar")
btnRegistrar.addEventListener("click", function () {
    axios.post("http://localhost:4567/usuario", {
        email : document.getElementById("email").value,
        password : document.getElementById("password").value
    })
    .then(function (response) {
        alert("Usuario creado " + response.data.status + ", con id: " + response.data.id);
        id = response.data.id;
        estado=response.data.status;
    })
    .catch(function (error) {
        console.log(error);
    })
})

var btnUsuarios = document.getElementById("usuarios")
btnUsuarios.addEventListener("click", function () {
    axios.get("http://localhost:4567/usuarios")
    .then(function (response) {
        console.log(response.data);
    })
    .catch(function (error) {
        console.log(error);
    })
})

var btnActualizar = document.getElementById("actualizar")
btnActualizar.addEventListener("click", function() {
    axios.post("http://localhost:4567/actualizar", {
        id : document.getElementById("idUsuario").value,
        email : document.getElementById("emailUsuario").value,
        password : document.getElementById("passwordUsuario").value
    })
    .then(function(response) {
        alert(response.data.status + " con id: " + response.data.id);
    })
    .catch(function(error) {
        console.log(error);
    })
})

var btnEliminar = document.getElementById("eliminar")
btnEliminar.addEventListener("click", function() {
    axios.post("http://localhost:4567/eliminar", {
        id : document.getElementById("idEliminar").value
    })
    .then(function(response) {
        alert(response.data.status + " con id: " + response.data.id);
    })
    .catch(function(error) {
        console.log(error);
    })
})