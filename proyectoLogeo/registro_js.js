
var btnRegistro = document.getElementById("btnRegistro");
btnRegistro.addEventListener("click", function() {

    let usuario = document.getElementById("user").value;
    let contraseña = document.getElementById("password").value;
    var params = new URLSearchParams();

    axios.post("http://localhost:4567/registrarUsuarios", {
        usuario : usuario,
        contraseña : contraseña,
    })
        .then(function(response) {

            console.log(response);
            alert("Usuario Registrado");

        })

        .catch(function(error) {
            console.log(error);
            alert("Error al registrar");
        })

});