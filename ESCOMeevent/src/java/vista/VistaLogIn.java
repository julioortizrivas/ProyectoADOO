package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VistaLogIn extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            out.println("    </style>");
            out.println("    <!--Se usa para indicar que esta pagina sera responsive-->");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
            out.println("  </head>");
            out.println("");
            out.println("  <body>");
            out.println("    <!--Seccion de la barra de navegacion.-->");
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
            out.println("");
            out.println("      <div class='nav-content'>");
            out.println("        <!--Zona para permitir la navegacion al usuario entre las pestanias-->");
            out.println("        <div class='col s12'>");
            out.println("          <a href='index.html' class='breadcrumb'>Home</a>");
            out.println("          <a href='#!' class='breadcrumb'>Inicio de Sesión</a>");
            out.println("        </div>");
            out.println("      </div>");
            out.println("     ");
            out.println("    </nav>");
            out.println("");
            out.println("");
            out.println("    <!--");
            out.println("      El div container junto con la lista no ordenada menu son los encargados de generar el menu lateral izquierdo donde se muestra la informacion del usuario y los eventos disponibles.");
            out.println("      Div user-view: En esa seccion se muestra el nombre del usuario, asi como su foto de perfil. Dentro de este div se encuentra otro que tendra la imagen de fondo para esa area.");
            out.println("      La clase 'circle' genera el efecto de la imagen contenida dentro de un circulo.");
            out.println("      Los li del final de esta seccion de codigo nos sirve para colocar las opciones que tendra el usuario en este menu.");
            out.println("    -->");
            out.println("    <div class='container white'>");
            out.println("      <ul id='menu' class='sidenav'>");
            out.println("        <li>");
            out.println("          <div class='user-view'>");
            out.println("            <div class='background'>");
            out.println("              <img src='img/f1.png'>");
            out.println("            </div>");
            out.println("            <a><img class='circle' src='img/imgPerfil.jpg'></a>");
            out.println("            <a><span class='white-text name'>Bienvenido(a):</span></a>");
            out.println("            <!--<a><span class='white-text name'><h3></h3></span></a>-->");
            out.println("          </div>");
            out.println("        </li>");
            out.println("        <li><a href='#'>Inicio</a></li>");
            out.println("        <li><a href='#'>Eventos</a></li>");
            out.println("        <li><a href='#'>Acerca de</a></li>");
            out.println("      </ul>");
            out.println("    </div>");
            out.println("    <!--");
            out.println("        Colocar a partir de estas lineas el contenido de la pagina");
            out.println("    -->");
            out.println("   <div class='row'>");
            out.println("    <div class='col s12 offset-m3 m6'>");
            out.println("      <div class='card blue lighten-5'>");
            out.println("        <div class='card-content black-text '>");
            out.println("          <span class='card-title pink-text darken-3-text'>LOG IN</span>");
            out.println("          <p>Por favor introduce un usuario que ya haya sido registrado en el sistema.</p>");
            out.println("          <form method='post' action='InicioDeSesion'>");
            out.println("             <div class='row'>");
            out.println("              <div class='input-field col s6'>");
            out.println("                <input  id='usuario' type='text'  name='usuario' class='validate' >");
            out.println("                <label class='active' for='usuario'>Usuario</label>");
            out.println("                </div>");
            out.println("                 <div class='input-field col s6'>");
            out.println("                  <input  id='pass' type='password'  name='pass' class='validate' >");
            out.println("                  <label class='active' for='pass'>Contrasenia</label>");
            out.println("                </div>");
            out.println("                <button class='btn waves-effect waves-light' type='submit' name='action'>Acceder");
            out.println("                  <i class='material-icons right'>send</i>");
            out.println("                </button>");
            out.println("        ");
            out.println("              </div>");
            out.println("            </div>");
            out.println("");
            out.println("         ");
            out.println("");
            out.println("          </form>      ");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("");
            out.println("    <!--");
            out.println("    Las siguientes lineas hacen refenencia a los archivos externos de JavaScript que se requieren para el funcionamiento de la aplicacion.");
            out.println("    1.-Libreria de JQuery.");
            out.println("    2.-Libreria que se requiere para el correcto funcionamiento de MateriaDesign.");
            out.println("    3.-Referencia a archivp JavaScript donde se encuentran las funciones necesarias para traajar con los mapas y la geolocalizacion.");
            out.println("    -->");
            out.println("    <script type='text/javascript' src='js/jquery-1.12.1.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/materialize.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/maps.js'></script>");
            out.println("    <!--");
            out.println("      Seccion para codigo incrustado de JavaScript colocar abajo de este comentario.");
            out.println("    -->");
            out.println("    <script type='text/javascript'>");
            out.println("      $(function(){");
            out.println("        $('#iconomenu').sideNav(");
            out.println("        {");
            out.println("          edge:'left',");
            out.println("          draggable:true,");
            out.println("          closeOnClick:true");
            out.println("        });");
            out.println("      })");
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
