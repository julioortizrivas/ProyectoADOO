
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class formNuevoLugar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>");
            out.println("    <meta charset='utf-8'>");
            out.println("    <link type='text/css' rel='stylesheet' href='css/font.css' />");
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
            out.println("    </style>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <nav class='indigo darken-4 nav-extended'>");
            out.println("      <div class='nav-wrapper'>");
            out.println("        <a href='#' class='brand-logo center titulo' ><img src='img/logo.png' />ESCOMeevent</a>");
            out.println("        <!--Zona del boton de menu hasta la etiqueta </ul>-->");
            out.println("        <ul id='nav-mobile' class='left '>");
            out.println("          <li>");
            out.println("            <a href='#' data-activates='menu' class='menu' id='iconomenu'><i class='material-icons'>menu</i>");
            out.println("            </a>");
            out.println("          </li>");
            out.println("        </ul>  ");
            out.println("      </div>");
            out.println("      <div class='nav-content'>");
            out.println("        <!--Zona para permitir la navegacion al usuario entre las pestanias-->");
            out.println("        <div class='col s12'>");
            out.println("          <a href='index.html' class='breadcrumb'>Home</a>");
            out.println("          <a href='#!' class='breadcrumb'>Nuevo Lugar</a>");
            out.println("        </div>");
            out.println("      </div>");
            out.println("     ");
            out.println("    </nav>");
            out.println("    <div class='container white'>");
            out.println("      <ul id='menu' class='sidenav'>");
            out.println("        <li>");
            out.println("          <div class='user-view'>");
            out.println("            <div class='background'>");
            out.println("              <img src='img/f1.png'>");
            out.println("            </div>");
            out.println("            <a><img class='circle' src='img/imgPerfil.jpg'></a>");
            out.println("            <a><span class='white-text name'>Bienvenido(a):</span></a>");
            out.println("          </div>");
            out.println("        </li>");
            out.println("        <li><a href='#'>Inicio</a></li>");
            out.println("        <li><a href='#'>Eventos</a></li>");
            out.println("        <li><a href='#'>Usuarios</a></li>");
            out.println("        <li><a href='#'>Acerca de</a></li>");
            out.println("      </ul>");
            out.println("    </div>");
            out.println("   <div class='row'>");
            out.println("    <div class='col s12 offset-m3 m6'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("        <div class='card-content black-text '>");
            out.println("          <span class='card-title pink-text darken-3-text'>Nuevo Lugar</span>");
            out.println("          <p>En esta sección puedes agregar lugares que se encuentren habilitados dentro de la ESCOM para celebrar eventos. </p>");
            out.println("          <form>");
            out.println("             <div class='row'>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='clvLugar' type='text'  name='clvLugar' class='validate' value='----' required>");
            out.println("                <label class='active' for='clvLugar'>Clave del Lugar</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='nombre' type='text'  name='nombre' class='validate' onchange='generarClv()' required>");
            out.println("                <label class='active' for='nombre'>Nombre del Lugar</label>");
            out.println("              </div>      ");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='ubi' type='text'  name='ubi' class='validate'  required>");
            out.println("                <label class='active' for='ubi'>Ubicación dentro de ESCOM</label>");
            out.println("              </div>     ");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='capacidad' type='number'  name='capacidad' class='validate' min='10' max='200' required>");
            out.println("                <label class='active' for='capacidad'>Capacidad</label>");
            out.println("              </div>");
            out.println("              ");
            out.println("               <div class='input-field col s12'>");
            out.println("                <textarea id='desc' type='text'  name='desc' class='materialize-textarea' ></textarea> ");
            out.println("                <label class='active' for='desc'>Descripción</label>");
            out.println("              </div>");
            out.println("              <button class='btn waves-effect waves-light' type='submit' name='action'>Registrar");
            out.println("                 <i class='material-icons right'>send</i>");
            out.println("              </button>");
            out.println("             </div>");
            out.println("            </div>");
            out.println("          </form>      ");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("    <script type='text/javascript' src='js/jquery-1.12.1.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/materialize.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/maps.js'></script>");
            out.println("    <script type='text/javascript'>");
            out.println("      $(function(){");
            out.println("        $('#iconomenu').sideNav(");
            out.println("        {");
            out.println("          edge:'left',");
            out.println("          draggable:true,");
            out.println("          closeOnClick:true");
            out.println("        });");
            out.println("      })");
            out.println("      $(document).ready(function(){");
            out.println("        $('select').formSelect();");
            out.println("      });");
            out.println("      function generarClv()");
            out.println("      {");
            out.println("        var hoy = new Date();");
            out.println("        var mm = hoy.getMonth()+1;");
            out.println("        var yyyy = hoy.getFullYear();");
            out.println("        var clave= document.getElementById('nombre').value .replace(/ /g,'').substring(0,9);");
            out.println("    document.getElementById('clvLugar').value=clave;");
            out.println("      }");
            out.println("    </script>");
            out.println("  </body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
