var agregarModal = document.getElementById('agregarModal');

class Posteo {

    static inicializar() {
        let elemInsertar = document.querySelector('#btnInsertar');
        elemInsertar.setAttribute('onclick', "Posteo.insertar();");
    }
    
    static insertar() {
        
        // objeto para enviar los parametros del formulario
        let posteo = {};
        posteo.autor = document.querySelector("#posteo_autor").value;
        posteo.titulo = document.querySelector("#posteo_titulo").value;
        var autor = document.getElementById("posteo_autor");
        var titulo = document.getElementById("posteo_titulo");
        // formato del mensaje en JSON
        
        
        if(posteo.autor != "" && posteo.titulo != ""){
        let posteoStringJSON = JSON.stringify(posteo);
        // Reemplazo de Ajax a Fetch
        fetch("../PosteoServer",
                {method: 'POST', body: posteoStringJSON})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    autor.value = "";
                    titulo.value = "";
                    document.querySelector('#panelResultados').innerHTML = datotexto;
                    Posteo.consultar();
                    agregarModal.style.display = "none";
                    
                    
                });
            } else {
                alert("Faltan campos");
            }
    }
    
    static actualizar(paramId) {
        // objeto para enviar los parametros del formulario
        let posteo = {};
        posteo.id = paramId;
    //    posteo.autor = "autor Test";
    //    posteo.titulo = "titulo Test";
        posteo.autor = document.getElementById("edit_autor_"+paramId).value;
        posteo.titulo = document.getElementById("edit_titulo_"+paramId).value;
               
               console.log(posteo.autor);
               console.log(posteo.titulo);
        if(posteo.autor != "" && posteo.titulo != ""){
        let posteoStringJSON = JSON.stringify(posteo);
        // Reemplazo de Ajax a Fetch
        fetch("../PosteoServer",
                {method: 'PUT', body: posteoStringJSON})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    document.querySelector('#panelResultados').innerHTML = datotexto;
            Posteo.consultar();
                });
    }
    }
    
    static eliminar(paramId) {
        // objeto para enviar los parametros del formulario
        let posteo = {};
        posteo.id = paramId;
        posteo.autor = document.querySelector("#posteo_autor_" + paramId).value;
        posteo.titulo = document.querySelector("#posteo_titulo_" + paramId).value;
        // formato del mensaje en JSON
        let posteoStringJSON = JSON.stringify(posteo);
        // Reemplazo de Ajax a Fetch
        fetch("../PosteoServer?&q=" + posteoStringJSON,
                {method: 'DELETE'})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    document.querySelector('#panelResultados').innerHTML = datotexto;
                    Posteo.consultar();
                    agregarModal.style.display = "none";
                    
                });
    }
    
    static consultar() {
        // Reemplazo de Ajax a Fetch
        fetch("../PosteoServer",
                {method: 'GET'})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    let posteos = JSON.parse(datotexto);
                    let templatePosteos = document.querySelector("#templatePosteos").innerHTML;
                    document.querySelector('#panelResultados').innerHTML = eval(templatePosteos);
                });
    }
}
///////////////////////////////////////// main() // Ejecucion Inicial Default
Posteo.inicializar();
/////////////////////////////////////////
