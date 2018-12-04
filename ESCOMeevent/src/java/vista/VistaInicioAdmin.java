
package vista;

import controladores.Administrador;
import controladores.Gestor;
import controladores.UsuarioRegistrado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VistaInicioAdmin", urlPatterns = {"/VistaInicioAdmin"})
public class VistaInicioAdmin extends HttpServlet {

   private Administrador ad;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!--");
            out.println("  Plantilla que se usa para las ventanas que requieren del uso de la barra de busqueda.");
            out.println("-->");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <meta charset='utf-8'>");
            out.println("      ");
            out.println("    <!--Importa las fuentes que se usan para los icono de Google-->");
            out.println("    <link type='text/css' rel='stylesheet' href='css/font.css' />");
            out.println("    <!--");
            out.println("      Importa los estilos de Materialize obtenidos de https://materializecss.com/");
            out.println("    -->");
            out.println("    <link type='text/css' rel='stylesheet' href='css/materialize.css'  media='screen,projection'/>");
            out.println("    <style>");
            out.println("      .cuerpo");
            out.println("      {");
            out.println("        min-height: 75vh;");
            out.println("      }");
            out.println("      nav .input-field");
            out.println("      {");
            out.println("        padding-bottom: 0;");
            out.println("      }");
            out.println("      nav .input-field #search");
            out.println("      {");
            out.println("          border:none;");
            out.println("          padding-bottom: 10px;");
            out.println("          color:white;");
            out.println("          text-align: center;");
            out.println("      }");
            out.println("      nav .input-field #search:focus");
            out.println("      {");
            out.println("          color:black;");
            out.println("      }");
            out.println("	  .waves-effect");
            out.println("	  {");
            out.println("		margin-bottom:10px;");
            out.println("		align-items:center;");
            out.println("	  }");
            out.println("	  .botones");
            out.println("	  {");
            out.println("		align-items:center;");
            out.println("		justify-content:left;");
            out.println("	  }");
            out.println("    </style>");
            out.println("    <!--Se usa para indicar que esta pagina sera responsive-->");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <!--Seccion de la barra de navegacion.-->");
            out.println("    <nav class='indigo darken-4 nav-extended'>");
            out.println("      <div class='nav-wrapper'>");
            out.println("        <a href='#' class='brand-logo center titulo' ><img src='img/logo.png' />ESCOMeevent</a>");
            out.println("      </div> ");
            out.println("    </nav>");
            out.println("	<div class='row'>");
            out.println("    <div class='col s10 m10 offset-m1 offset-s1'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("        <div class='card-content black-text'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Bienvenido "+ad.getNombre()+" "+ad.getApPaterno()+"(Administrador):</span>");
            out.println("          <p>Selecciona la operación que quieres realizar</p>");
            
            
            
            out.println("	<div class='botones'>");
                      
            out.println("           <div class='botonesAdmin'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Operaciones con Lugares</span>");
            out.println("		  <button class='btn-large waves-effect waves-light' type='submit' name='action' onClick='window.location=\"formNuevoLugar\"'>Nuevo Lugar");
            out.println("                   <i class='material-icons left'>add_circle</i>");
            out.println("                 </button>");
            out.println("		  <button class='btn-large waves-effect waves-light' type='submit' name='action' onClick='window.location=\"formListaLugares\"'>Mostrar Lugares");
            out.println("                   <i class='material-icons left'>location_on</i>");
            out.println("                 </button>");
            out.println("           </div>");
            
            
            
            out.println("           <div class='botonesAdmin'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Operaciones con Organizadores</span>");
            
            out.println("		   <button class='btn-large waves-effect waves-light' type='button' name='action' onClick='window.location=\"VistaRegistroOrganizador\"'>Nuevo Organizador");
            out.println("                  <i class='material-icons left'>add_circle</i>");
            out.println("                   </button>");
            out.println("		   <button class='btn-large waves-effect waves-light' type='button' name='action' onClick='window.location=\"formListaOrganizadores\"'>Mostrar Organizadores");
            out.println("                  <i class='material-icons left'>assignment_ind</i>");
            out.println("                   </button>");
            
      
            out.println("           </div>");
            
            out.println("           <div class='botonesAdmin'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Operaciones con Usuarios</span>");
            out.println("		  <button class='btn-large waves-effect waves-light' type='submit' name='action'>Nuevo Administrador/Gestor");
            out.println("                  <i class='material-icons left'>add_circle</i>");
            out.println("                 </button>");
            out.println("		 <button class='btn-large waves-effect waves-light' type='submit' name='action'>Mostrar Usuarios");
            out.println("                  <i class='material-icons left'>assignment_ind</i>");
            out.println("                </button>");
            
            out.println("           </div>");
            
            
            
            out.println("           <div class='botonesAdmin'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Más opciones con tu cuenta</span>");
            
            out.println("	  <button class='btn-large waves-effect waves-light' type='submit' name='action'>Mi Perfil");
            out.println("                   <i class='material-icons left'>account_circle</i>");
            out.println("           </button>");
            out.println("           <button class='btn-large waves-effect waves-light' type='submit' name='action' onClick='window.location=\"VistaProximosEventos\"'>Todos los Eventos");
            out.println("                  <i class='material-icons left'>event</i>");
            out.println("           </button>");
            out.println("		   <button class='btn-large waves-effect waves-light' type='submit' name='action' onClick='window.location=\"VistaMisEventos\"'>Mis Eventos");
            out.println("                  <i class='material-icons left'>event_available</i>");
            out.println("           </button>");
            out.println("           <button class='btn-large waves-effect waves-light red darken-4' type='submit' name='action' onClick='window.location=\"CerrarSesion\"'>Cerrar Sesión");
            out.println("                  <i class='material-icons left'>close</i>");
            out.println("           </button>");
            
            out.println("           </div>");
            
            
            
            
            out.println("           </div>");         
            
            
            out.println("		   </div>");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("  </div>");
            out.println("    <!--");
            out.println("      Seccion para codigo incrustado de JavaScript colocar abajo de este comentario.");
            out.println("    -->");
            out.println("	<script type='text/javascript' src='js/jquery-1.12.1.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/materialize.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/maps.js'></script>");
            out.println("  </body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
            processRequest(request, response);
        }
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
