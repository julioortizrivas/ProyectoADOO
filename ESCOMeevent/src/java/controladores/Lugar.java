
package controladores;

import java.sql.ResultSet;

public class Lugar {
    private String clave;
    private String nombre;
    private InfoLugar info;
    public Lugar(String clvLu)
    {
        String query="SELECT idLugar,Nombre FROM LUGAR WHERE idLugar LIKE '"+clvLu+"';";
        Conector conexion=new Conector("eventos","root","localhost:3306","");
        ResultSet res1;
        try
        {
            conexion.conectar();
            res1=conexion.recuperarDatos(query);
            res1.next();
            clave=res1.getString(1);
            nombre=res1.getString(2);
            info=new InfoLugar(clvLu);
        }
        catch(Exception ex)
        {
            clave="ERROR";
            clave="ERROR";
            info=null;
        }
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public InfoLugar getInfo() {
        return info;
    }
    
    
}
