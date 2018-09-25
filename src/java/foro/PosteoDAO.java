/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foro;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PosteoDAO {
    
    private PosteoDAO() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static PosteoDAO INSTANCE = null;

    public static PosteoDAO getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new PosteoDAO();
        }
        return INSTANCE;
    }
    private final static String SQL_POSTEOS_SELECT = "SELECT * FROM posteos;";

    public ArrayList<Posteo> obtener() throws ClassNotFoundException,
            IOException, SQLException {
        ArrayList<Posteo> lista = new ArrayList();
        Connection c = null;
        PreparedStatement ptsmt = null;
        ResultSet rs = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_POSTEOS_SELECT);
            rs = ptsmt.executeQuery();
            Posteo a = null;
            while (rs.next()) {
                try {
                    a = new Posteo();
                    a.setId(rs.getString("pos_id"));
                    a.setAutor(rs.getString("pos_autor"));
                    a.setTitulo(rs.getString("pos_titulo"));
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
    private final static String SQL_POSTEOS_INSERT = "INSERT INTO posteos (pos_autor, pos_titulo)values(?,?);";

    public static void insertar(Posteo a)
            throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_POSTEOS_INSERT);
            ptsmt.setString(1, a.getAutor());
            ptsmt.setString(2, a.getTitulo());
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_POSTEOS_UPDATE = "UPDATE posteos "
            + " set pos_autor = ?, pos_titulo = ? "
            + " WHERE pos_id = ?;";

    public static void actualizar(Posteo a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_POSTEOS_UPDATE);
            ptsmt.setString(1, a.getAutor());
            ptsmt.setString(2, a.getTitulo());
            ptsmt.setInt(3, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_POSTEOS_DELETE = "DELETE FROM posteos "
            + " WHERE pos_id = ?;";

    public static void borrar(Posteo a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_POSTEOS_DELETE);
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
            ArrayList<Posteo> posteos = PosteoDAO.getInstance().obtener();
            for (Posteo a : posteos) {
                System.out.println(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Posteo a = new Posteo();
            a.setAutor("Autor Ejemplo");
            a.setTitulo("Titulo Ejemplo");
            PosteoDAO.insertar(a);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("[ OK ]TestPosteoDAO");
    }
}
