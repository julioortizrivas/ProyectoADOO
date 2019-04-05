package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class RegistroUsuario extends HttpServlet {
    private String mensaje;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+ mensaje + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
        String usuario=(String)request.getParameter("usuario");
        String nombre=(String)request.getParameter("nombre");
        String apPat=(String)request.getParameter("appat");
        String apMat=(String)request.getParameter("apmat");
        String cont1=(String)request.getParameter("pass");
        String correo=(String)request.getParameter("correo");
        String telefono=(String)request.getParameter("telefono");
        String semestre="";
                
        System.out.println("usuario"+usuario);
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="INSERT INTO usuario_reg VALUES('"+usuario+"','"+apPat+"','"+apMat+"','"+nombre+"','"+correo+"','"+telefono+"',AES_ENCRYPT('"+cont1+"', date(now())), date(now()), time(now()));";
            if((mensaje=conexion.modificarDatos(query)).equals("Petición realizada con éxito."))
            {
                if(request.getParameter("alumno")!=null)
                {
                    semestre=(String)request.getParameter("semestre");
                    String query2="INSERT INTO usuario_reg_alum VALUES('"+usuario+"','"+semestre+"');";
                    conexion.modificarDatos(query2);
                }
                try (PrintWriter out = response.getWriter()) 
                {
                    out.println("<script>alert('Te has registrado exitosamente.')</Script>");
                    
                }
                    response.sendRedirect("VistaLogIn");
                
                
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
