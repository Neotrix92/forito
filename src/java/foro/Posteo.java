/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foro;


public class Posteo {
    
    private String id;
    private String autor;
    private String titulo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        if (!"".equals(titulo)) {
            this.titulo = titulo;
        } else {
            throw new Exception("El titulo esta vacío");
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
        return "Autor: " + autor + ", Titulo: " + titulo;
    }
    
    
    // HAY QUE REVISAR QUE CONCHA HACE ESTO, SINO SE BORRA
    public void validar() throws Exception{
        this.setAutor( this.getAutor() );
        this.setTitulo( this.getTitulo() );
    }
}
