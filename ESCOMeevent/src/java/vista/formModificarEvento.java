
package vista;

import controladores.Administrador;
import controladores.Conector;
import controladores.Evento;
import controladores.Gestor;
import controladores.UsuarioRegistrado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class formModificarEvento extends HttpServlet {

    private Gestor ges;
    private Evento ev;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            String q1,q2,q3;
            ResultSet res1,res2,res3;
            q1="SELECT idTipo,Nombre FROM EVENTO_TIPO;";
            q2="SELECT idOrganizador,Nombre FROM EVENTO_ORGANIZADORES;";
            q3="SELECT idLugar,Nombre FROM LUGAR;";
            try
            {
               conexion.conectar();
                res1=conexion.recuperarDatos(q1); 
                res2=conexion.recuperarDatos(q2); 
                res3=conexion.recuperarDatos(q3); 
           
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
            out.println("  <body onload='traePortafolios()'>");
            out.println("  <script src='js/script.js'>");
            out.println("  </script>");
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
            out.println("          <a href='#!' class='breadcrumb'>"+ev.getNombre()+"</a>");
            out.println("        </div>");
            out.println("      </div>");
            
            
            out.println("    </nav>");
            
            out.println("    <div class='container white'>");
            out.println("      <ul id='menu' class='sidenav'>");
            out.println("        <li>");
            out.println("          <div class='user-view'>");
            out.println("            <div class='background'>");
            out.println("              <img src='img/f1.png'>");
            out.println("            </div>");
            out.println("            <a><img class='circle' src='img/imgPerfil.jpg'></a>");
            out.println("            <a><span class='white-text name'>Bienvenido(a):"+ges.getNombre()+"</span></a>");
            out.println("          </div>");
            out.println("        </li>");
            out.println("        <li><a href='RedireccionarInicio'>Inicio</a></li>");
            out.println("        <li><a href='VistaProximosEventos'>Próximos Eventos</a></li>");
            out.println("        <li><a href='CerrarSesion'>Cerrar Sesión</a></li>");
            out.println("        <li><a href='#'>Acerca de</a></li>");
            out.println("      </ul>");
            out.println("    </div>");
            
            
            out.println("   <div class='row'>");
            out.println("    <div class='col s12 offset-m3 m6'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("");
            out.println("        <div class='card-content black-text '>");
            out.println("          <span class='card-title pink-text darken-3-text'>Evento "+ev.getNombre()+"</span>");
            out.println("          <p>Ingresa todos los datos del evento en el formulario. Recuerda que la información debe ser validada previamente. </p>");
            out.println("          <form method='post' action='ModificarEvento'>");
            out.println("             <div class='row'>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='clvEvento' type='text'  name='clvEvento' class='validate' value='"+ev.getClave()+"' readonly>");
            out.println("                <label class='active' for='usuario'>Clave de Evento</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='nombre' type='text'  name='nombre' class='validate' value='"+ev.getNombre()+"'>");
            out.println("                <label class='active' for='nombre'>Nombre del Evento</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s6'>");
            out.println("                <input  id='fecha' type='date'  name='fecha' class='validate' value='"+ev.getInfo().getFecha()+"'>");
            out.println("                <label class='active' for='fecha'>Fecha</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s6'>");
            out.println("                <input  id='hora' type='time'  name='hora' class='validate' value='"+ev.getInfo().getHora()+"' max='20:30:00' min='07:00:00' >");
            out.println("                <label class='active' for='hora'>Hora</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s6'>");
            out.println("                <input  id='duracion' type='time'  name='duracion' class='validate' value='"+ev.getInfo().getDuracion()+"' max='02:30:00' min='00:15:00' >");
            out.println("                <label class='active' for='duracion'>Duración:</label>");
            out.println("              </div>             ");
            out.println("              <div class='input-field col s6'>");
            out.println("                <select class='browser-default' name='lu' id='lu' >");
            out.println("                  <option value='' disabled selected>Escoge el lugar</option>");
            
            while(res3.next())
            {   
                String selec=(res3.getString(2).equals(ev.getInfo().getLugar()))?" selected ":"";
                out.println("                  <option value='"+res3.getString(1)+"' "+selec+">"+res3.getString(2)+"</option>");
            }  
            out.println("                </select>");
            out.println("              </div>");
            out.println("              <div class='input-field col s12'>");
            out.println("                <input  id='capacidad' type='number'  name='capacidad' class='validate' min='10' max='150' value='"+ev.getInfo().getCupo()+"'>");
            out.println("                <label class='active' for='capacidad'>Capacidad</label>");
            out.println("              </div>");
            out.println("              <div class='input-field col s6'>");
            out.println("                <select class='browser-default' name='org' id='org' >");
            out.println("                  <option value='' disabled selected>Escoge al organizador</option>");
            while(res2.next())
            {   
                String selec=(res2.getString(2).equals(ev.getInfo().getOrganizador()))?" selected ":"";
                out.println("                  <option value='"+res2.getString(1)+"' "+selec+">"+res2.getString(2)+"</option>");
            }  
            out.println("                </select>");
            out.println("              </div>");
            
            
            out.println("              <div class='input-field col s6'>");
            out.println("                <select class='browser-default' name='ev' id='ev' >");
            out.println("                  <option value='' disabled selected>Tipo de Evento</option>");
            while(res1.next())
            {   
                String selec=(res1.getString(2).equals(ev.getInfo().getTipo()))?" selected ":"";
                out.println("                  <option value='"+res1.getString(1)+"' "+selec+">"+res1.getString(2)+"</option>");
            }            
            out.println("                </select>");
            out.println("              </div>");
            
            
            out.println("               <div class='input-field col s12'>");
            out.println("                <textarea id='desc' type='text'  name='desc' class='materialize-textarea' value='"+ev.getInfo().getDesc()+"'></textarea> ");
            out.println("                <label class='active' for='desc'>Descripción</label>");
            out.println("              </div>");
            out.println("              <div class='file-field input-field col s12'>");
            out.println("                <div class='btn'>");
            out.println("                  <span>IMAGEN</span>");
            out.println("                  <input type='file'>");
            out.println("                </div>");
            out.println("                <div class='file-path-wrapper'>");
            out.println("                  <input class='file-path validate' type='text'>");
            out.println("                </div>");
            out.println("              </div>");
            
            out.println("                <label class='active' for='portf'>Aregar a portafolio</label>");
            out.println("                <select class='browser-default' name='portf' id='portf'>");
            out.println("                  <option value='Portafolio' disabled selected>Portafolio</option>");
            /*while(res1.next())
            {   
                String selec=(res1.getString(2).equals(ev.getInfo().getTipo()))?" selected ":"";
                out.println("                  <option value='"+res1.getString(1)+"' "+selec+">"+res1.getString(2)+"</option>");
            }            */
            out.println("                </select>");
            
            
             out.println("                <button class='btn waves-effect waves-light' type='button' name='action' onClick='window.location=\"CancelarEvento?idE="+ev.getClave()+"&NomE="+ev.getNombre()+"\"'>Cancelar evento");
            out.println("                  <i class='material-icons right'>error</i>");
            out.println("                </button>");
                        
            out.println("                <button class='btn waves-effect waves-light' id='asignarPort' type='button' name='action' onClick='asociarPortafolio(\""+ges.getClave()+"\")'>Asignar Portafolio");
            out.println("                </button>");
            out.println("                <button class='btn waves-effect waves-light' type='submit' name='action'>Modificar");
            out.println("                  <i class='material-icons right'>send</i>");
            out.println("                </button>");
            
            out.println("              </div>");
            out.println("              </div>");
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
            out.println("");
            out.println("      $(document).ready(function(){");
            out.println("        $('select').formSelect();");
            out.println("      });");
            out.println("      function generarClv()");
            out.println("      {");
            out.println("        var hoy = new Date();");
            out.println("        var mm = hoy.getMonth()+1;");
            out.println("        var yyyy = hoy.getFullYear();");
            out.println("        var clave= String(yyyy).substring(2,4)+mm.toString(16)+document.getElementById('nombre').value .replace(/ /g,'').substring(0,4);");
            out.println("    document.getElementById('clvEvento').value=clave;");
            out.println("      }");
            out.println("    </script>");
            out.println("  </body>");
            out.println("</html>");
             }
            catch(Exception ex)
            {
                System.out.println("ERROR CON LAS CONSULTAS:"+ex);
            }
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
            request.setCharacterEncoding("UTF-8");
            ges=(Gestor)us;
            String cveEv=request.getParameter("cev");
            String nomEv=request.getParameter("nev");
            ev=new Evento(cveEv, nomEv);
            if(ev.autenticarCreador(ges.getClave()))
            {
                 processRequest(request, response);
            }
            else
            {
                response.sendRedirect("VistaMensaje?mensaje=Este evento no te corresponde.");
            }
           
        }
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
