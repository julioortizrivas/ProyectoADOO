package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
public class RegistroEvento extends HttpServlet {
    private Gestor ges;
    private String mensaje="";
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id=(String)request.getParameter("clvEvento");
        String n=(String)request.getParameter("nombre");
        String f=(String)request.getParameter("fecha");
        String h=(String)request.getParameter("hora");
        String du=(String)request.getParameter("duracion");
        String c=(String)request.getParameter("capacidad");
        String lu=(String)request.getParameter("lu");
        String org=(String)request.getParameter("org");
        String ev=(String)request.getParameter("ev");
        String des=(String)request.getParameter("desc");
        
        HttpSession sesion=request.getSession();
        UsuarioRegistrado us=(UsuarioRegistrado)sesion.getAttribute("usuario");
        if(us==null)
        {
            System.out.println("No hay sesion iniciada");
            response.sendRedirect("VistaLogIn");
        }
        else if((us instanceof Administrador)) 
        {
            response.sendRedirect("VistaInicioAdmin");
        }
        else if(!(us instanceof Gestor))
        {
            System.out.println("El tipo de usuario no es gestor");
            response.sendRedirect("VistaInicioUsuario");
        }
        else
        {
            ges=(Gestor)us;
            
            mensaje=ges.crearEvento(id, n, f, h, des, du, c, lu, ev, org);
            response.sendRedirect("VistaMensaje?mensaje="+mensaje);
        }
        
                  
    }

}
