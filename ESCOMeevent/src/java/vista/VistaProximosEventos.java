
package vista;

import controladores.Administrador;
import controladores.Conector;
import controladores.Evento;
import controladores.UsuarioRegistrado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VistaProximosEventos extends HttpServlet {

    private ArrayList<Evento> eventos;
    private UsuarioRegistrado us;
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
            out.println("	  .modal .modal-footer .btn-flat");
            out.println("      {");
            out.println("        display: inline-flex;");
            out.println("        line-height: inherit;");
            out.println("        align-items: center;");
            out.println("      }");
            out.println("      .modal .modal-footer");
            out.println("      {");
            out.println("        height:auto; ");
            out.println("        text-align: center;");
            out.println("      }");
            out.println("      .modal");
            out.println("      {");
            out.println("        border-radius: 25px;");
            out.println("      }");
            out.println("      .modal-content");
            out.println("      {");
            out.println("        background-image: ");
            out.println("        url(img/f3.png); ");
            out.println("        background-repeat: repeat;");
            out.println("        margin-bottom: 0;");
            out.println("      }");
            out.println("    </style>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <nav class='indigo darken-4 nav-extended'>");
            out.println("      <div class='nav-wrapper'>");
            out.println("        <a href='#' class='brand-logo center titulo' ><img src='img/logo.png' />ESCOMeevent</a>");
            out.println("        <ul id='nav-mobile' class='left '>");
            out.println("          <li>");
            out.println("            <a href='#' data-activates='menu' class='menu' id='iconomenu'><i class='material-icons'>menu</i>");
            out.println("            </a>");
            out.println("          </li>");
            out.println("        </ul>");
            out.println("      </div> ");
            out.println("	  <div class='nav-content'>");
            out.println("        <div class='col s12'>");
            out.println("          <a href='index.html' class='breadcrumb'>Home</a>");
            out.println("          <a href='#!' class='breadcrumb'>Eventos Registrados</a>");
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
            out.println("            <a><span class='white-text name'>Bienvenido(a):"+ ((us!=null)?us.getNombre():"")+"</span></a>");
            out.println("          </div>");
            out.println("        </li>");
            out.println("        <li><a href='RedireccionarInicio'>Inicio</a></li>");
            out.println("        <li><a href='VistaProximosEventos'>Próximos Eventos</a></li>");
            out.println("        <li>"+ ((us!=null)?"<a href='CerrarSesion'>Cerrar Sesión</a>":"<a href=''>Usuarios</a>")+"</li>");
            out.println("        <li><a href='#'>Acerca de</a></li>");
            out.println("      </ul>");
            out.println("    </div>");  
            
            
            
            out.println("	<div class='row'>");
            out.println("    <div class='col s10 m10 offset-m1 offset-s1'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("");
            out.println("        <div class='card-content black-text'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Nuestros Próximos Eventos:</span>");
            out.println("          <p>Aquí puedes verificar todos los eventos que ESCOM tiene planeados para tí</p>");
            out.println("		 <div class='row'>");
            out.println("<!--***********************************************************************-->");
            for (int i = 0; i < eventos.size(); i++) {
                out.println("		 <div class='card ev col s6'>");
                out.println("			 <div class='card-content row'>");
                out.println("				<div class='col s4'>");
                out.println("				  <img src='img/imgEventos.jpg' class='circle responsive-img' >");
                out.println("				</div>");
                out.println("				<div class='col s8'>");
                out.println("				  <h5 class='header'>"+eventos.get(i).getNombre()+"</h5>");
                out.println("				  <h6 class='header'></h6>");
                out.println("				  <blockquote>"+eventos.get(i).getInfo().getFecha()+","+eventos.get(i).getInfo().getHora()+"</blockquote>");
                out.println("				</div>");
                out.println("			</div>");
                out.println("			 <a class='btn-floating btn-large halfway-fab waves-effect waves-light teal modal-trigger' data-target='mInfo"+eventos.get(i).getClave()+"'>");
                out.println("			   <i class='material-icons'>add</i>");
                out.println("			</a>");
                out.println("		</div>");
            
                out.println("	<!--***********************************************************************-->");
            
                out.println("    <div id='mInfo"+eventos.get(i).getClave()+"' class='modal grey darken-1' >");
                out.println("      <div class='modal-content row' >");
                out.println("        <div class='col s6 offset-s3' >");
                out.println("          <img class='circle responsive-img' src='img/imgEventos.jpg'>");
                out.println("        </div>");
                out.println("      <div class='col s12'>");
                out.println("        <h5>"+eventos.get(i).getNombre()+"</h5>");
                out.println("        <h6>Tipo de evento:"+eventos.get(i).getInfo().getTipo()+"</h6>");
                out.println("		<ul>");
                out.println("			<li>Fecha:"+eventos.get(i).getInfo().getFecha()+"</li>");
                out.println("			<li>Hora:"+eventos.get(i).getInfo().getHora()+"</li>");
                out.println("			<li>Lugares Disponibles:"+eventos.get(i).getInfo().getCupo()+"</li>");
                out.println("			<li>Descripción del evento:"+eventos.get(i).getInfo().getDesc()+"</li>");
                out.println("		</ul>");
                out.println("      </div>");
                out.println("      </div>");
                out.println("      <div class='modal-footer black' >");
                out.println("         <a method='post' href='InscribirAEvento?ev="+eventos.get(i).getClave()+"' class='modal-close waves-effect waves-green btn-flat light-green darken-2 white-text'>");
                out.println("          <i class='large material-icons'>check_circle</i>Asistiré al evento");
                out.println("        </a>");
                out.println("      </div>");
                out.println("    </div>");
            }
            out.println("		<!--***********************************************************************-->");
            out.println("    </div>");
            out.println("  </div>");
            out.println("  </div>");
            out.println("	<script type='text/javascript' src='js/jquery-1.12.1.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/materialize.min.js'></script>");
            out.println("    <script type='text/javascript' src='js/maps.js'></script>");
            out.println("	<script type='text/javascript'>");
            out.println("      $(function(){");
            out.println("        $('#iconomenu').sideNav(");
            out.println("        {");
            out.println("          edge:'left',");
            out.println("          draggable:true,");
            out.println("          closeOnClick:true");
            out.println("        });");
            out.println("      })");
            out.println("      $(document).ready(function(){");
            out.println("        $('.modal').modal();");
            out.println("      });");
            out.println("    </script>");
            out.println("  </body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String query="SELECT idEvento,Nombre FROM EVENTO WHERE (Fecha>CURDATE() OR (Fecha=CURDATE() AND Hora>time(now())));";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            ResultSet res1;
            try
            {
                conexion.conectar();
                res1=conexion.recuperarDatos(query);
                eventos=new ArrayList<Evento>();
                while(res1.next())
                {
                    eventos.add(new Evento(res1.getString(1),res1.getString(2)));
                    
                }
                for (int i = 0; i < eventos.size(); i++) {
                    System.out.println("Evento:"+eventos.get(i).getClave());
                }
            }
            catch(Exception ex)
            {
                
            }
            HttpSession sesion=request.getSession();
            us=(UsuarioRegistrado)sesion.getAttribute("usuario");
        processRequest(request, response);
    }


}
