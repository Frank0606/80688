
var btnRegistro = document.getElementById("btnRegistro");
btnRegistro.addEventListener("click", function() {

    var usuario = document.getElementById("user").value;
    var contraseña = document.getElementById("password").value;

    axios.post("http://localhost:4567/registrarUsuarios", {
        usuario : usuario,
        contraseña : contraseña
    })
        .then(function(response) {

            console.log(response.data);
            alert("Usuario Registrado");

        })

        .catch(function(error) {
            console.log(error);
            alert("Error al registrar");
        })

});