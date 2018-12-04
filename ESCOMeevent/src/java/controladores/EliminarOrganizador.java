
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EliminarOrganizador extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensje;
        String claveOrg=(String)request.getParameter("claveOrganizador");
        
        HttpSession sesion=request.getSession();
        UsuarioRegistrado us=(UsuarioRegistrado)sesion.getAttribute("usuario");
        if(us==null)
        {
            System.out.println("No hay sesion iniciada");
            response.sendRedirect("VistaLogIn");
        }
        else if((us instanceof Administrador)) 
        {
            
            Administrador ad=(Administrador)us;
            String mensaje=ad.eliminarOrganizador(claveOrg);
            response.sendRedirect("VistaMensaje?mensaje="+mensaje);
        }
        else if(us instanceof Gestor)
        {
            System.out.println("El tipo de usuario no es gestor");
            response.sendRedirect("VistaInicioGestor");
        }
        else
        {
           response.sendRedirect("VistaLogIn");
            
        }
    }
}
