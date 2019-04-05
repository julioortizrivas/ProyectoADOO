package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VistaMensaje extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            String mensaje=request.getParameter("mensaje");
            String icono="whatshot";
            
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
            out.println("    </style>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("    <nav class='indigo darken-4 nav-extended'>");
            out.println("      <div class='nav-wrapper'>");
            out.println("        <a href='#' class='brand-logo center titulo' ><img src='img/logo.png' />ESCOMeevent</a>");
            out.println("      </div> ");
            out.println("    </nav>");
            out.println("	<div class='row'>");
            out.println("    <div class='col s10 m10 offset-m1 offset-s1'>");
            out.println("      <div class='card grey lighten-3'>");
            out.println("        <div class='card-content black-text'>");
            out.println("          <span class='card-title pink-text darken-3-text'>");
            out.println("          	<i class='material-icons left'>"+icono+"</i> ");
            out.println(mensaje);
            out.println("          </span>");
            out.println("		  <div class='botones'>");
            out.println("			  <button class='btn-large waves-effect waves-light' type='submit' name='action' onclick='history.back(1)'>Regresar");
            out.println("	                  <i class='material-icons left'>arrow_back</i>");
            out.println("	           </button>");
            out.println("			   <button class='btn-large waves-effect waves-light' type='submit' name='action' onclick='window.location=\"RedireccionarInicio\"'>");
            out.println("			   			Volver al Inicio");
            out.println("	                  <i class='material-icons left'>school</i>");
            out.println("	           </button>");
            out.println("		   </div>");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("  </div>");
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
        processRequest(request, response);
    }

   

}
