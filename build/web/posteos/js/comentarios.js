

class Comentario {

    static inicializar() {
        let elemInsertar = document.querySelector('#btnComentar');
        elemInsertar.setAttribute('onclick', "Comentario.insertar();");
    }
    
    static insertar() {
        
        // objeto para enviar los parametros del formulario
        let comentario = {};
        comentario.autor = document.querySelector("#nick").value;
        comentario.mensaje = document.querySelector("#agregarComentario").value;
        var autor = document.getElementById("nick");
        var mensaje = document.getElementById("agregarComentario");
        comentario.orden = document.getElementsByClassName("cuerpo").length +1;
        comentario.posteo = 82;
        // formato del mensaje en JSON
        
        
        if(comentario.autor != "" && comentario.mensaje != ""){
        let comentarioStringJSON = JSON.stringify(comentario);
        // Reemplazo de Ajax a Fetch
        fetch("../ComentarioServer",
                {method: 'POST', body: comentarioStringJSON})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    mensaje.value = "";
                    console.log(comentario.autor);
                    console.log(comentario.mensaje);
                    console.log(comentario.orden);
                    console.log(comentario.posteo);
                    document.querySelector('#panelComentarios').innerHTML = datotexto;
                    
                    Comentario.consultar();                    
                });
            } else {
                alert("Faltan campos");
            }
    }
    
    static actualizar(paramId) {
        // objeto para enviar los parametros del formulario
        let comentario = {};
        comentario.id = paramId;
        comentario.mensaje = document.getElementById("edit_mensaje_"+paramId).value;
               
               console.log(comentario.id);
               console.log(comentario.mensaje);
        if(comentario.mensaje != ""){
        let comentarioStringJSON = JSON.stringify(comentario);
        // Reemplazo de Ajax a Fetch
        fetch("../ComentarioServer",
                {method: 'PUT', body: comentarioStringJSON})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    document.querySelector('#panelComentarios').innerHTML = datotexto;
            Comentario.consultar();
                });
    }
    }
    
    static eliminar(paramId) {
        // objeto para enviar los parametros del formulario
        let comentario = {};
        comentario.id = paramId;
        // formato del mensaje en JSON
        let comentarioStringJSON = JSON.stringify(comentario);
        // Reemplazo de Ajax a Fetch
        fetch("../ComentarioServer?&q=" + comentarioStringJSON,
                {method: 'DELETE'})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    document.querySelector('#panelComentarios').innerHTML = datotexto;
                    Comentario.consultar();
                    
                });
    }
    
    static consultar() {
        // Reemplazo de Ajax a Fetch
        fetch("../ComentarioServer",
                {method: 'GET'})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    let comentarios = JSON.parse(datotexto);
                    let templateComentarios = document.querySelector("#templateComentario").innerHTML;
                    document.querySelector('#panelComentarios').innerHTML = eval(templateComentarios);
                });
    }
}
///////////////////////////////////////// main() // Ejecucion Inicial Default
Comentario.inicializar();
/////////////////////////////////////////
