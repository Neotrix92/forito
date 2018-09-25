// Get the modal
var agregarModal = document.getElementById('agregarModal');

// Get the button that opens the modal
var btnAgregarTema = document.getElementById("agregarTema");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal 
btnAgregarTema.onclick = function(){
    agregarModal.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    agregarModal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == agregarModal) {
        agregarModal.style.display = "none";
    }
};


