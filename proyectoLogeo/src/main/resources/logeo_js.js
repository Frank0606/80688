
var btnLogeo = document.getElementById("btnLogeo");
btnLogeo.addEventListener("click", function() {

    var usuario = document.getElementById("user").value;
    var contraseña = document.getElementById("password").value;
    let params = new URLSearchParams();

    params.append("Usuario", usuario);
    params.append("Contraseña", contraseña);

    axios.post("/logearUsuario", params)
        
        .then(function(response) {

            if(parseInt(response.data) == 0) {

                alert("No se encuentra usuario");

            } else {

                alert(response.data);
                location.href = "usuariosRegistrados.html";

            }
        })

        .catch(function(error) {
            console.log(error);
            alert("Usuario no registrado");
        })

});