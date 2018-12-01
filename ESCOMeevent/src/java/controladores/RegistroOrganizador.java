package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
public class RegistroOrganizador extends HttpServlet {

    private String mensaje;
    private Administrador ad;
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
        String clveOrg=(String)request.getParameter("clvOrg");
        String nombre=(String)request.getParameter("nombre");
        String contacto=(String)request.getParameter("contac");
                
       HttpSession sesion=request.getSession();
        UsuarioRegistrado us=(UsuarioRegistrado)sesion.getAttribute("usuario");
        if(us==null)
        {
            System.out.println("No hay sesion iniciada");
            response.sendRedirect("VistaLogIn");
        }
        else if( us instanceof Gestor)
        {
            response.sendRedirect("VistaInicioGestor");
        }
        else if(!(us instanceof Administrador))
        {
            System.out.println("El tipo de usuario no es administrador");
            response.sendRedirect("VistaInicioUsuario");
        }
        else
        {
            ad=(Administrador)us;
            mensaje=ad.crearOrganizador(clveOrg, nombre, contacto);
            response.sendRedirect("VistaMensaje?mensaje="+mensaje);
        }
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
