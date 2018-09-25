/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foro;


public class Comentario {
    
    private String id;
    private String orden;
    private String autor;
    private String mensaje;
    private String posteo;
    private String foto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
    
    
    public String getPosteo() {
        return posteo;
    }

    public void setPosteo(String posteo) {
        this.posteo = posteo;
    }

    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) throws Exception {
        if (!"".equals(mensaje)) {
            this.mensaje = mensaje;
        } else {
            throw new Exception("El mensaje esta vacío");
        }

    }
    
        public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception {
        if (!"".equals(autor)) {
            this.autor = autor;
        } else {
            throw new Exception("El nombre esta vacío");
        }
    }

    @Override
    public String toString() {
        return "Autor: " + autor + ", Mensaje: " + mensaje;
    }
    
    
    // HAY QUE REVISAR QUE CONCHA HACE ESTO, SINO SE BORRA
    public void validar() throws Exception{
        this.setAutor( this.getAutor() );
        this.setMensaje( this.getMensaje() );
    }
}
