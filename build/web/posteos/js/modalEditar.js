function mostrarEdit(id){
    var editarModal = document.getElementById("editarModal"+id);

    editarModal.style.display = "block";


var spanEditar = document.getElementsByClassName("closeEditar"+id)[0];


//document.getElementById("editarTema"+id).onclick = Bar;
spanEditar.onclick = function() {
    editarModal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == editarModal) {
        editarModal.style.display = "none";
    }
};
}


