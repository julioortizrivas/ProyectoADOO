package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;


public class InicioDeSesion extends HttpServlet {
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conector conexion=new Conector("eventos","root","localhost:3306","root");
        String usu=(String)request.getParameter("usuario");
        String clv=(String)request.getParameter("pass");
        String query="SELECT idUSUARIO_REG,ApPat,ApMat,Nombre FROM usuario_reg WHERE idUSUARIO_REG LIKE '"+usu+"' AND AES_DECRYPT(Contrasenia,FechaReg) LIKE '"+clv+"';";
        try{
            conexion.conectar();
            ResultSet res=conexion.recuperarDatos(query);
            if(res.next())
            {
                System.out.println(res.getString(1));
                String clave=res.getString(1);
                String apPat=res.getString(2);
                String apMat=res.getString(3);
                String nombre=res.getString(4);
                String tipoUsu="";
                HttpSession sesion=request.getSession();
                switch(revisarUsuario(clave))
                {
                    case 1:
                        //tipoUsu="Administrador";
                        Administrador ad=new Administrador(clave,nombre,apPat,apMat);
                        sesion.setAttribute("usuario", ad);
                        response.sendRedirect("VistaInicioAdmin");
                    break;
                    case 2:
                        //tipoUsu="Gestor";
                        Gestor ges=new Gestor(clave,nombre,apPat,apMat);
                         sesion.setAttribute("usuario", ges);
                         response.sendRedirect("VistaInicioGestor");
                    break;
                    case 3:
                        UsuarioRegistrado ur=new UsuarioRegistrado(clave,nombre,apPat,apMat);
                         sesion.setAttribute("usuario", ur);
                         response.sendRedirect("VistaInicioUsuario");
                        //tipoUsu="Usuario Normal";
                    break;
                    default:
                        response.sendRedirect("VistaMensaje?mensaje=Hubo un error desconocido al intentar iniciar sesión.");
                }
            }
            else
            {
                response.sendRedirect("VistaMensaje?mensaje=Revisa tus datos por favor.");
            }
        }
        catch(Exception ex)
        {
            response.sendRedirect("VistaMensaje?mensaje="+ex.toString());
        }
    }
    public int revisarUsuario(String cad)
    {
        /*
            -1: Surgio un error
            1: Es administrados
            2: Es gestor
            3: Es otro tipo de usuario
        */
        int tipo=-1;
         Conector conexion=new Conector("eventos","root","localhost:3306","");
        String q1,q2;
        q1="SELECT idADMIN FROM USUARIO_REG_ADMIN WHERE idADMIN LIKE '"+cad+"';";
        q2="SELECT idGESTOR FROM USUARIO_REG_GESTOR WHERE idGESTOR LIKE '"+cad+"'";
        try
        {
           conexion.conectar();
           if(conexion.recuperarDatos(q1).next())
           {
               tipo=1;
           }
           else if(conexion.recuperarDatos(q2).next())
           {
                tipo=2;
           }
           else
               tipo=3;
        ResultSet res=conexion.recuperarDatos(q1); 
        }
        catch(Exception ex)
        {
            System.out.println("ERROR AL VERIFICAR TIPO DE USUARIO:"+ex);
        }
        
        
        return tipo;
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
