/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foro;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ComentarioDAO {
    
    private ComentarioDAO() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static ComentarioDAO INSTANCE = null;

    public static ComentarioDAO getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new ComentarioDAO();
        }
        return INSTANCE;
    }
    private final static String SQL_COMENTARIOS_SELECT = "SELECT comentarios.com_id, comentarios.com_mensaje, comentarios.com_orden, comentarios.com_posteo, usuarios.us_nick, usuarios.us_foto FROM comentarios INNER JOIN usuarios ON comentarios.com_autor=usuarios.us_id ORDER BY comentarios.com_orden ASC;";

    public ArrayList<Comentario> obtener() throws ClassNotFoundException,
            IOException, SQLException {
        ArrayList<Comentario> lista = new ArrayList();
        Connection c = null;
        PreparedStatement ptsmt = null;
        ResultSet rs = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_COMENTARIOS_SELECT);
            rs = ptsmt.executeQuery();
            Comentario a = null;
            while (rs.next()) {
                try {
                    a = new Comentario();
                    a.setId(rs.getString("com_id"));
                    a.setOrden(rs.getString("com_orden"));
                    a.setAutor(rs.getString("us_nick"));
                    a.setMensaje(rs.getString("com_mensaje"));
                    a.setPosteo(rs.getString("com_posteo"));
                    a.setFoto(rs.getString("us_foto"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                lista.add(a);
            }
        } finally {
            try {
                rs.close();
            } finally {
                try {
                    ptsmt.close();
                } finally {
                    c.close();
                }
            }
        }
        return lista;
    }
    private final static String SQL_COMENTARIOS_INSERT = "INSERT INTO comentarios (com_autor, com_mensaje, com_orden, com_posteo)values(?,?,?,?);";

    public static void insertar(Comentario a)
            throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_COMENTARIOS_INSERT);
            ptsmt.setString(1, a.getAutor());
            ptsmt.setString(2, a.getMensaje());
            ptsmt.setString(3, a.getOrden());
            ptsmt.setString(4, a.getPosteo());
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_COMENTARIOS_UPDATE = "UPDATE comentarios "
            + " set com_mensaje = ? "
            + " WHERE com_id = ?;";

    public static void actualizar(Comentario a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_COMENTARIOS_UPDATE);
            ptsmt.setString(1, a.getMensaje());
            ptsmt.setInt(2, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_COMENTARIOS_DELETE = "DELETE FROM comentarios "
            + " WHERE com_id = ?;";

    public static void borrar(Comentario a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_COMENTARIOS_DELETE);
            ptsmt.setInt(1, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
//////////////////////////////////////
        public static void main(String[] args) {
        System.out.println("[ .. ]TestPosteoDAO");
        try {
            ArrayList<Comentario> comentarios = ComentarioDAO.getInstance().obtener();
            for (Comentario a : comentarios) {
                System.out.println(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Comentario a = new Comentario();
            a.setAutor("Autor Ejemplo");
            a.setMensaje("Mensaje Ejemplo");
            ComentarioDAO.insertar(a);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("[ OK ]TestComentarioDAO");
    }
}
