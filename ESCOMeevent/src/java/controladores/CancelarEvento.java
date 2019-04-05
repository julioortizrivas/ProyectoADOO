
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CancelarEvento extends HttpServlet {
    private Gestor ges;
    private String mensaje="";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idev=(String)request.getParameter("idE");
        String nev=(String)request.getParameter("nomE");
        
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
            Evento evento=new Evento(idev,nev);
            if(evento.autenticarCreador(ges.getClave()))
            {
                mensaje=ges.darDeBajaEvento(idev);
                response.sendRedirect("VistaMensaje?mensaje="+mensaje);
            }
            else
            {
                response.sendRedirect("VistaMensaje?mensaje=Este evento no esta asociado a tu usuario.");
            }
            
        }
    }

    
}
