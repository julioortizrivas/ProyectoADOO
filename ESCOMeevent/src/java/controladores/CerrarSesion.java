
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CerrarSesion extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion =request.getSession();
        if(sesion!=null)
        {
            sesion.invalidate();
            response.sendRedirect("RedireccionarInicio");
        }
        
    }

    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
