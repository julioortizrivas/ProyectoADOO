
package controladores;

import java.sql.ResultSet;

public class Evento {
    private String clave;
    private String nombre;
    private InfoEvento info;
    //private String clave;
    
    public Evento(String c,String n)
    {
        clave=c;
        nombre=n;
        info=new InfoEvento(c);
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
    
}
