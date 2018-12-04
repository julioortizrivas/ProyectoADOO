
package vista;

import controladores.Administrador;
import controladores.Conector;
import controladores.Evento;
import controladores.Lugar;
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

public class formListaLugares extends HttpServlet {
    private ArrayList<Lugar> lugares;
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
            out.println("          <a href='#!' class='breadcrumb'>Lugares Registrados</a>");
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
            out.println("            <a><span class='white-text name'>Bienvenido(a):"+ ((us!=null && us instanceof Administrador)?us.getNombre():"")+"</span></a>");
            out.println("          </div>");
            out.println("        </li>");
            out.println("        <li><a href='RedireccionarInicio'>Inicio</a></li>");
            out.println("        <li><a href='VistaProximosEventos'>Próximos Eventos</a></li>");
            out.println("        <li>"+ ((us!=null && us instanceof Administrador)?"<a href='CerrarSesion'>Cerrar Sesión</a>":"<a href=''>Usuarios</a>")+"</li>");
            out.println("        <li><a href='#'>Acerca de</a></li>");
            out.println("      </ul>");
            out.println("    </div>");  
            
            
            out.println("	<div class='row'>");
            out.println("    <div class='col s10 m10 offset-m1 offset-s1'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("");
            out.println("        <div class='card-content black-text'>");
            out.println("          <span class='card-title pink-text darken-3-text'>Nuestros Lugares Registrados:</span>");
            out.println("          <p>Aquí puedes visualizar todos los lugares donde se pueden llevar a cabo eventos deontro de la ESCOM</p>");
            out.println("		 <div class='row'>");
            out.println("<!--***********************************************************************-->");
            
            out.println("				 <ul class='collection'>");
            for (int i = 0; i < lugares.size(); i++) {
                
                
                
                out.println("				 	<!--***********************************************************************-->");
                    out.println("				    <li class='collection-item avatar'>");
                    out.println("				      <i class='material-icons circle blue darken-2'>store</i>");
                    out.println("				      <span class='title'>"+lugares.get(i).getNombre()+
                            ((us!=null && us instanceof Administrador)?"("+lugares.get(i).getClave()+")":"")+"</span>");
                    out.println("				      <p>Descripción: <br>");
                    out.println(lugares.get(i).getInfo().getDescripcion());
                    out.println("				      <br>Cupo: <br>");
                    out.println(lugares.get(i).getInfo().getCupo());
                    out.println("				      <br>Ubicación: <br>");
                    out.println(lugares.get(i).getInfo().getUbicacion());
                    
                    out.println("				      </p>");
                    if(us!=null && us instanceof Administrador)
                        out.println("				      <a href='formModificarLugar?Lugar="+lugares.get(i).getClave()+"' class='secondary-content' onclick='\"\"'><i class='material-icons'>build</i></a>");
                    out.println("				    </li>");
                    out.println("				    <!--***********************************************************************-->");
               
            }
            out.println("				</ul>");
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
        
        String query="SELECT idLugar FROM LUGAR;";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            ResultSet res1;
            HttpSession sesion=request.getSession();
            us=(UsuarioRegistrado)sesion.getAttribute("usuario");
            try
            {
                
                conexion.conectar();
                res1=conexion.recuperarDatos(query);
                lugares=new ArrayList<Lugar>();
                while(res1.next())
                {
                    System.out.println("lugar:"+res1.getString(1));
                    lugares.add(new Lugar(res1.getString(1)));
                    
                }
                for (int i = 0; i < lugares.size(); i++) {
                    System.out.println("lugar:"+lugares.get(i).getClave());
                }
                
            }
            catch(Exception ex)
            {
                
            }
            processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
