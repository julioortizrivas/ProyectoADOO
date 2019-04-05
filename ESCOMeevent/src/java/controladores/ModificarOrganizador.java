
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModificarOrganizador extends HttpServlet {

   private Administrador ad;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String clave=(String)request.getParameter("clvOrg");
            String nombre=(String)request.getParameter("nombre");
            String contacto=(String)request.getParameter("contac");
            String mensaje=ad.modificarOrganizador(clave,nombre,contacto);
            response.sendRedirect("VistaMensaje?mensaje="+mensaje);
        }
        
        
    }

    
    
}
