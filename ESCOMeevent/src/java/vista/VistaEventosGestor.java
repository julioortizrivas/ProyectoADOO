
package vista;

import controladores.Administrador;
import controladores.Conector;
import controladores.Evento;
import controladores.Gestor;
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

public class VistaEventosGestor extends HttpServlet {
    private ArrayList<Evento> eventos;
    private Gestor ges;
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
            out.println("            <a><span class='white-text name'>Bienvenido(a):"+ges.getNombre()+"</span></a>");
            out.println("          </div>");
            out.println("        </li>");
            out.println("        <li><a href='RedireccionarInicio'>Inicio</a></li>");
            out.println("        <li><a href='VistaProximosEventos'>Próximos Eventos</a></li>");
            out.println("        <li><a href='CerrarSesion'>Cerrar Sesión</a></li>");
            out.println("        <li><a href='#'>Acerca de</a></li>");
            out.println("      </ul>");
            out.println("    </div>");
            out.println("	<div class='row'>");
            out.println("    <div class='col s10 m10 offset-m1 offset-s1'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("");
            out.println("        <div class='card-content black-text'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Lista de eventos registrados por Gestor:</span>");
            out.println("          <p>Aquí puedes verificar, modificar y cancelar los eventos que hayas registrado</p>");
            out.println("		 <div class='row'>");
            out.println("<!--***********************************************************************-->");
            
                for (int i = 0; i < eventos.size(); i++) 
                {
                    out.println("		 <div class='card ev col s6'>");
                    out.println("			 <div class='card-content row'>");
                    out.println("				<div class='col s4'>");
                    out.println("				  <img src='img/imgEventos.jpg' class='circle responsive-img' >");
                    out.println("				</div>");
                    out.println("				<div class='col s8'>");
                    out.println("				  <h5 class='header'>"+eventos.get(i).getNombre()+"</h5>");
                    out.println("				  <h6 class='header'></h6>");
                    out.println("				  <blockquote>"+eventos.get(i).getInfo().getFecha()+","+eventos.get(i).getInfo().getHora());
                    out.println("                                               <input type='hidden' id='infoPortf"+eventos.get(i).getClave()+"' value='conseguirinfoPortf('"+eventos.get(i).getClave()+"')'></input>");
                    out.println("                                               <br/><form method='post'><button type='submit' name='portafolio'>Portafolio</button></form></blockquote>");
                    out.println("				</div>");
                    out.println("			</div>");
                    out.println("			 <a class='btn-floating btn-large halfway-fab waves-effect waves-light  modal-trigger orange accent-3' data-target='mInfo"+eventos.get(i).getClave()+"'>");
                    out.println("			   <i class='material-icons '>add</i>");
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
                    out.println("			<li>Fecha:  "+eventos.get(i).getInfo().getFecha()+"</li>");
                    out.println("			<li>Hora:  "+eventos.get(i).getInfo().getHora()+"</li>");
                    out.println("			<li>Lugares Disponibles:  "+eventos.get(i).getInfo().getCupo()+"</li>");
                    out.println("			<li>Descripción del evento:  "+eventos.get(i).getInfo().getDesc()+"</li>");
                    out.println("		</ul>");
                    
                    out.println("			 <div class='row'>");
                     out.println("			 <p>Asistentes al evento:</p>");
                    out.println("				 <ul class='collection'>");
                    for (int j = 0; j < eventos.get(i).getAsistentes().size(); j++) {
                            out.println("				 	<!--***********************************************************************-->");
                            out.println("				    <li class='collection-item avatar'>");
                            out.println("				      <i class='material-icons circle blue darken-2'>person</i>");
                            out.println("				      <span class='title'>"+eventos.get(i).getAsistentes().get(j).getNombre()+" "+eventos.get(i).getAsistentes().get(j).getApPaterno()+"("+eventos.get(i).getAsistentes().get(j).getClave()+")</span>");
  			      
                               
                            out.println("				    </li>");
                            out.println("				    <!--***********************************************************************-->");
                    }


                    out.println("				</ul>");
                    out.println("			</div>");
                    
                    
                    out.println("      </div>");
                    
                    
                    out.println("      </div>");
                    out.println("      <div class='modal-footer black' >");
                    out.println("        <a href='formModificarEvento?cev="+eventos.get(i).getClave()+"&nev="+eventos.get(i).getNombre()+"' class='modal-close waves-effect waves-green btn-flat  orange accent-3 white-text'>");
                    out.println("          <i class='large material-icons'>build</i>Modificar");
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
            
            String query="SELECT idEvento,Nombre FROM EVENTO WHERE\n" +
                        "(Fecha>CURDATE() OR\n" +
                        "(Fecha=CURDATE() AND Hora>time(now()))) AND\n" +
                        "idGestor_reg LIKE '"+ges.getClave()+"';";
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
