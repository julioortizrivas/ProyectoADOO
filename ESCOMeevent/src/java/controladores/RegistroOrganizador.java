package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class RegistroOrganizador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroOrganizador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
        String usuario=(String)request.getParameter("clvOrg");
        String nombre=(String)request.getParameter("nombre");
        String contacto=(String)request.getParameter("contac");
                
        System.out.println("usuario"+usuario);
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="INSERT INTO EVENTO_ORGANIZADORES VALUES('"+usuario+"','"+nombre+"');";
            if(conexion.modificarDatos(query))
            {
                    String query2="INSERT INTO ORGANIZADOR_CONTACTO VALUES('"+usuario+"','"+contacto+"');";
                    conexion.modificarDatos(query2);
               
                try (PrintWriter out = response.getWriter()) 
                {
                    out.println("<script>alert('Te has registrado exitosamente.')</Script>");
                    
                }
                    response.sendRedirect("VistaInicioAdmin");
                
                
            }
            else
            {
                try (PrintWriter out = response.getWriter()) 
                {
                    out.println("<script>");
                    out.println("alert('El usuario ya existe');");
                    out.println("window.history.back();");
                    out.println("</Script>");
                }
                
            }
             
            
        }
        catch(Exception ex)
        {
            
        }
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
