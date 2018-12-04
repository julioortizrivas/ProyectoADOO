
package controladores;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Evento {
    private String clave;
    private String nombre;
    private InfoEvento info;
    //private String clave;
    private ArrayList<UsuarioRegistrado> asistentes;
    public Evento(String c,String n)
    {
        clave=c;
        nombre=n;
        info=new InfoEvento(c);
        String query2="SELECT idUsuario_reg FROM USUARIO_REG_has_EVENTO WHERE idEvento LIKE '"+clave+"';";
        Conector conexion=new Conector("eventos","root","localhost:3306","");
        ResultSet res1;
        try
        {
            asistentes=new ArrayList<UsuarioRegistrado>();
            conexion.conectar();
            res1=conexion.recuperarDatos(query2);
            asistentes=new ArrayList<UsuarioRegistrado>();
            while(res1.next())
            {
                asistentes.add(new UsuarioRegistrado(res1.getString(1)));
                
            }
            System.out.println("Asistentes:"+asistentes.size());
        }
        catch(Exception ex)
        {
            clave="ERROR";
            clave="ERROR";
            info=null;
        }
    }
    public boolean autenticarCreador(String clvC)
    {
        Conector conexion=new Conector("eventos","root","localhost:3306","");
        
        String query="SELECT idEvento FROM EVENTO WHERE idEvento LIKE '"+clave+"' AND idGestor_reg LIKE '"+clvC+"';";
        
        String mensaje="";
        try
        {
            conexion.conectar();
            ResultSet res;
            res=conexion.recuperarDatos(query);
            if(res.next())
            {
                    System.out.println("Hecho:"+query);
                    return true;
            }
            else
                return false;
        }
        catch(Exception ex)
        {
            System.out.println("ERROR CON EVENTO:"+ex.toString()+"//"+query);
            return false;
        }
        
    }
    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public InfoEvento getInfo() {
        return info;
    }

    public ArrayList<UsuarioRegistrado> getAsistentes() {
        return asistentes;
    }
    
}
