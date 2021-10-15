
var usuariosReg = document.getElementById("usuariosReg");

usuariosReg.addEventListener("click", {

    axios.post("http://localhost:4567/usuariosRegistrados", {
    

    })
    .then(function(response) {
    
        

    })

    .catch(function(error) {

        console.log(error);
    
    })

})


function usuarios(u) {

    let text = "";
    for(let i = 0 ; i<u.lenght; i++){

        let tareas = document.createElement("li");
        tareas.textContent = u[i];
        

    }

};