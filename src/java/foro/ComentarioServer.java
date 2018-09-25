package foro;

import com.google.gson.Gson;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "ComentarioServer", urlPatterns = {"/ComentarioServer"})
public class ComentarioServer extends HttpServlet {

    final static Gson CONVERTIR = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ArrayList<Comentario> listado = ComentarioDAO.getInstance().obtener();
            String resultado = CONVERTIR.toJson(listado);
            out.println(resultado);

        } catch (ClassNotFoundException ex) {
            out.println("Verificar: " + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String texto = request.getReader().readLine();

            Comentario comentarioParametro = CONVERTIR.fromJson(texto, Comentario.class);
            comentarioParametro.validar();

            ComentarioDAO.insertar(comentarioParametro);
            //out.println("TEST");
        } catch (ClassNotFoundException ex) {
            out.println("Verificar: " + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Comentario comentarioParametro = CONVERTIR.fromJson(request.getReader(), Comentario.class);
            ComentarioDAO.actualizar(comentarioParametro);
    //        out.println(CONVERTIR.toJson("MODIFICADO"));
        } catch (ClassNotFoundException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Comentario comentarioParametro = CONVERTIR.fromJson(request.getParameter("q"), Comentario.class);
            ComentarioDAO.borrar(comentarioParametro);
       //     out.println(CONVERTIR.toJson("ELIMINADO"));

        } catch (ClassNotFoundException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }
}
