
var btnNoSubmit = document.getElementById("noSubmit");
btnNoSubmit.addEventListener("click", function() {
    
    //Recupero del formulario los valores de usuario y password, creo un query
    let usuario = document.getElementById("nombre").value;
    let password = document.getElementById("password").value;
    let params = new URLSearchParams();

    //Construyo una URL de parametro, osea un query string
    params.append("nombre", usuario);
    params.append("password", password);

    //Invocacion de la libreria axions
    axios.post("http://localhost:4567/saludar", params)
        .then(function(response) {
            console.log(response);
            console.log("Verdad " + response.data.nombre);
            alert(response.data);
        })
        .catch(function(error) {
            console.log("error " + error);
        })

});

var btnNoSubmitGet = document.getElementById("noSubmitGet");
btnNoSubmitGet.addEventListener("click", function () {

    let usuario = document.getElementById("nombre").value;
    let password = document.getElementById("password").value;
    let params = new URLSearchParams();

    params.append("nombre", usuario);
    params.append("password", password);

    axios.get("http://localhost:4567/saludar?" + params)
        .then(function (response) {
            console.log(response);
            console.log('verdad ' + response.data);
            alert(response.data);
        })
        .catch(function (error) {
            console.log('error ' + error);
        })

});

var btnNoSubmitPostJson = document.getElementById("noSubmitPostJson");
btnNoSubmitPostJson.addEventListener("click", function () {

    let usuario = document.getElementById("nombre").value;
    let password = document.getElementById("password").value;
    let params = new URLSearchParams();

    params.append("nombre", usuario);
    params.append("password", password);

    axios.post("http://localhost:4567/saludarJson", {
        firstName : usuario,
        password : password
    })
        .then(function (response) {
            console.log(response);
            console.log('verdad ' + response.data.usuario);
            alert(response.data.usuario);
        })
        .catch(function (error) {
            console.log('error ' + error);
        })

});
