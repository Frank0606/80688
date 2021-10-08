
var btnLogeo = document.getElementById("btnLogeo");
btnLogeo.addEventListener("click", function() {

    let usuario = document.getElementById("user").value;
    let contraseña = document.getElementById("password").value;
    let params = new URLSearchParams();

    params.append("Usuario", usuario);
    params.append("Contraseña", contraseña);

    axios.post("http://localhost:4567/logearUsuario", params)
        
        .then(function(response) {

            console.log(response.toString());

            if(parseInt(response) == 0) {

                console.log(response);
                alert("No se encuentra usuario");

            } else {


            }
        })

        .catch(function(error) {
            console.log(error);
            alert("Usuario no registrado");
        })

});