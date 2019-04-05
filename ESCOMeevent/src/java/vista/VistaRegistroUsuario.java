
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VistaRegistroUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            out.println("<!--");
            out.println("NOTAS: Faltan campos de telefono(es opcional)");
            out.println("    El semestre solo se pide si es alumno.");
            out.println("    No se debe colocar la escuela");
            out.println("CORRECCIONES EN LA BD: Eliminar el campo de Fecha de nacimiento, agregar el cifrado de la contrasenia");
            out.println("-->");
            out.println("<!--");
            out.println("  Plantilla que se usa para las ventanas que requieren del uso de la barra de busqueda.");
            out.println("-->");
            out.println("<!DOCTYPE html>");
            out.println("            <html>");
            out.println("                <head>");
            out.println("                  <meta charset='utf-8'>");
            out.println("                  <!--Importa las fuentes que se usan para los icono de Google-->");
            out.println("                  <link type='text/css' rel='stylesheet' href='css/font.css' />");
            out.println("                  <!--");
            out.println("                    Importa los estilos de Materialize obtenidos de https://materializecss.com/");
            out.println("                  -->");
            out.println("                  <link type='text/css' rel='stylesheet' href='css/materialize.css'  media='screen,projection'/>");
            out.println("                  <style>");
            out.println("                    .cuerpo");
            out.println("                    {");
            out.println("                      min-height: 75vh;");
            out.println("                    }");
            out.println("                    nav .input-field");
            out.println("                    {");
            out.println("                      padding-bottom: 0;");
            out.println("                    }");
            out.println("                    nav .input-field #search");
            out.println("                    {");
            out.println("                        border:none;");
            out.println("                        padding-bottom: 10px;");
            out.println("                        color:white;");
            out.println("                        text-align: center;");
            out.println("                    }");
            out.println("                    nav .input-field #search:focus");
            out.println("                    {");
            out.println("                        color:black;");
            out.println("                    }");
            out.println("               element.style");
            out.println("               {");
            out.println("                 transform: translateX(100%);");
            out.println("               }");
            out.println("                  </style>");
            out.println("                  <!--Se usa para indicar que esta pagina sera responsive-->");
            out.println("                  <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
            out.println("                </head>");
            out.println("                <body>");
            out.println("                  <!--Seccion de la barra de navegacion.-->");
            out.println("                  <nav class='indigo darken-4 nav-extended'>");
            out.println("                    <div class='nav-wrapper'>");
            out.println("                      <a href='#' class='brand-logo center titulo' ><img src='img/logo.png' />ESCOMeevent</a>");
            out.println("                      <!--Zona del boton de menu hasta la etiqueta </ul>-->");
            out.println("                      <ul id='nav-mobile' class='left '>");
            out.println("                        <li>");
            out.println("                          <a href='#' data-activates='menu' class='menu' id='iconomenu'><i class='material-icons'>menu</i>");
            out.println("                          </a>");
            out.println("                        </li>");
            out.println("                      </ul>  ");
            out.println("                    </div>");
            out.println("                    <div class='nav-content'>");
            out.println("                      <!--Zona para permitir la navegacion al usuario entre las pestanias-->");
            out.println("                      <div class='col s12'>");
            out.println("                        <a href='index.html' class='breadcrumb'>Home</a>");
            out.println("                        <a href='#!' class='breadcrumb'>Registro</a>");
            out.println("                      </div>");
            out.println("                    </div>");
            out.println("                  </nav>");
            out.println("                  <!--");
            out.println("                    El div container junto con la lista no ordenada menu son los encargados de generar el menu lateral izquierdo donde se muestra la informacion del usuario y los eventos disponibles.");
            out.println("                    Div user-view: En esa seccion se muestra el nombre del usuario, asi como su foto de perfil. Dentro de este div se encuentra otro que tendra la imagen de fondo para esa area.");
            out.println("                    La clase 'circle' genera el efecto de la imagen contenida dentro de un circulo.");
            out.println("                    Los li del final de esta seccion de codigo nos sirve para colocar las opciones que tendra el usuario en este menu.");
            out.println("                  -->");
            out.println("                  <div class='container white'>");
            out.println("                    <ul id='menu' class='sidenav'>");
            out.println("                      <li>");
            out.println("                        <div class='user-view'>");
            out.println("                          <div class='background'>");
            out.println("                            <img src='img/f1.png'>");
            out.println("                          </div>");
            out.println("                          <a><img class='circle' src='img/imgPerfil.jpg'></a>");
            out.println("                          <a><span class='white-text name'>Bienvenido(a):</span></a>");
            out.println("                          <!--<a><span class='white-text name'><h3></h3></span></a>-->");
            out.println("                        </div>");
            out.println("                      </li>");
            out.println("                      <li><a href='#'>Inicio</a></li>");
            out.println("                      <li><a href='#'>Eventos</a></li>");
            out.println("                      <li><a href='#'>Acerca de</a></li>");
            out.println("                    </ul>");
            out.println("                  </div>");
            out.println("                  <!--");
            out.println("                      Colocar a partir de estas lineas el contenido de la pagina");
            out.println("                  -->");
            out.println("                 <div class='row grey lighten-5'>");
            out.println("                  <div class='col s12 offset-m3 m6'>");
            out.println("                    <div class='card grey lighten-3'>");
            out.println("                      <div class='card-content black-text '>");
            out.println("                        <span class='card-title pink-text darken-3-text'>Registro</span>");
            out.println("                        <p>Texto</p>");
            out.println("                        <form method='post' action='RegistroUsuario'>");
            out.println("                           <div class='row'>");
            out.println("                            <div class='input-field col s6'>");
            out.println("                              <input  id='usuario' type='text'  name='usuario' class='validate' required>");
            out.println("                              <label class='active' for='usuario'>Usuario</label>");
            out.println("                            </div>");
            out.println("                            <div class='input-field col s6'>");
            out.println("                              <input  id='nombre' type='text'  name='nombre' class='validate' required>");
            out.println("                              <label class='active' for='nombre'>Nombre</label>");
            out.println("                            </div>");
            out.println("                            <div class='input-field col s6'>");
            out.println("                              <input  id='appat' type='text'  name='appat' class='validate' required>");
            out.println("                              <label class='active' for='appat'>Apellido Paterno</label>");
            out.println("                            </div>");
            out.println("                            <div class='input-field col s6'>");
            out.println("                              <input  id='apmat' type='text'  name='apmat' class='validate' required>");
            out.println("                              <label class='active' for='apmat'>Apellido Materno</label>");
            out.println("                            </div>");
            out.println("                            <div class='input-field col s6'>");
            out.println("                              <input  id='pass' type='password'  name='pass' class='validate' required>");
            out.println("                              <label class='active' for='pass'>Contraseña</label>");
            out.println("                            </div>");
            out.println("                            <div class='input-field col s6'>");
            out.println("                              <input  id='reppass' type='password'  name='reppass' class='validate' onchange='verificarPsd()' required />");
            out.println("                              <label class='active' for='reppass'>Repetir Contraseña</label>");
            out.println("                            </div>");
            out.println("                            <div class='input-field col s12'>");
            out.println("                              <input  id='correo' type='email'  name='correo' class='validate' required>");
            out.println("                              <label class='active' for='correo'>Correo electrónico</label>");
            out.println("                            </div>");
            out.println("                            <div class='input-field col s12'>");
            out.println("                              <input  id='telefono' type='text'  name='telefono' class='validate' >");
            out.println("                              <label class='active' for='telefono'>Teléfono</label>");
            out.println("                            </div>");
          /*  out.println("                            <div class='input-field col s12'>");
            out.println("                              <p><label>");
            out.println("                                 <input type='checkbox' name='alumno' id='alumno' value='alumno' onchange='actualizar()'/>");
            out.println("                                 <span>Soy alumno de la escuela.</span>");
            out.println("                              </label></p>");
            out.println("                            </div>");
            out.println("                           <div class='input-field col s12' id='semestre' name='semestre'>");
            out.println("                            </div>");*/
            out.println("                              <button class='btn waves-effect waves-light' type='submit' name='action'>Registrar");
            out.println("                                <i class='material-icons right'>send</i>");
            out.println("                              </button>");
            out.println("                            </div>");
            out.println("                          </div>");
            out.println("                        </form>      ");
            out.println("                    </div>");
            out.println("                  </div>");
            out.println("                </div>");
            out.println("                  <!--");
            out.println("                  Las siguientes lineas hacen refenencia a los archivos externos de JavaScript que se requieren para el funcionamiento de la aplicacion.");
            out.println("                  1.-Libreria de JQuery.");
            out.println("                  2.-Libreria que se requiere para el correcto funcionamiento de MateriaDesign.");
            out.println("                  3.-Referencia a archivp JavaScript donde se encuentran las funciones necesarias para traajar con los mapas y la geolocalizacion.");
            out.println("                  -->");
            out.println("                  <script type='text/javascript' src='js/jquery-1.12.1.min.js'></script>");
            out.println("                  <script type='text/javascript' src='js/materialize.min.js'></script>");
            out.println("                  <script type='text/javascript' src='js/maps.js'></script>");
            out.println("                  <!--");
            out.println("                    Seccion para codigo incrustado de JavaScript colocar abajo de este comentario.");
            out.println("                  -->");
            out.println("                  <script type='text/javascript'>");
            out.println("                    $(function(){");
            out.println("                      $('#iconomenu').sideNav(");
            out.println("                      {");
            out.println("                        edge:'left',");
            out.println("                        draggable:true,");
            out.println("                        closeOnClick:true");
            out.println("                      });");
            out.println("                    })");
             out.println("                    function verificarPsd()");
            out.println("                    {");
            out.println("                      var c1=document.getElementById('pass').value;");
            out.println("                      var c2=document.getElementById('reppass').value;");
            out.println("                      if(c1!=c2)");
            out.println("                      {");
            out.println("                        alert('Las contraseñas no coinciden');");
            out.println("                        document.getElementById('reppass').value='';");
            out.println("                      }");
            out.println("                    }");
            out.println("                    function actualizar()");
            out.println("                    {");
            out.println("                    var cad=\"<select class='browser-default' name='semestre'>\"+");
            out.println("                               \"<option value='' disabled selected>Escoge tu Semestre</option>\"+");
            out.println("                                \"<option value='1'>Primer</option>\"+");
            out.println("                                \"<option value='2'>Segundo</option>\"+");
            out.println("                                \"<option value='3'>Tercer</option>\"+");
            out.println("                                \"<option value='4'>Cuarto</option>\"+");
            out.println("                                \"<option value='5'>Quinto</option>\"+");
            out.println("                                \"<option value='6'>Sexto</option>\"+");
            out.println("                                \"<option value='7'>Séptimo</option>\"+");
            out.println("                                \"<option value='8'>Octavo</option>\"+");
            out.println("                                \"<option value='9'>Noveno</option>\"+");
            out.println("                                \"<option value='10'>Otro...</option>\"+");
            out.println("                              \"</select>\";");
            out.println("                      var nr=document.getElementById('alumno');");
            out.println("                      if(nr.checked==true)");
            out.println("                          document.getElementById('semestre').innerHTML=cad;");
            out.println("                      else");
            out.println("                        document.getElementById('semestre').innerHTML='';");
            out.println("                    }");
           
            out.println("                  </script>");
            out.println("                </body>");
            out.println("              </html>");
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
