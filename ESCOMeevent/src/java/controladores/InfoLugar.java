
package controladores;

import java.sql.ResultSet;

public class InfoLugar {
    
    private String ubicacion;
    private String descripcion;
    private int cupo;
    public InfoLugar(String claveLugar)
    {
            String query="SELECT Ubicación,Descrip, Cupo FROM LUGAR WHERE idLugar LIKE '"+claveLugar+"';";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            ResultSet res1;
            try
            {
               conexion.conectar();
               res1=conexion.recuperarDatos(query);
               res1.next();
               ubicacion=res1.getString(1);
               descripcion=res1.getString(2);
               cupo=Integer.parseInt(res1.getString(3));
            }
            catch(Exception ex)
            {
                System.out.println("ERROR:"+ex.toString());
            }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCupo() {
        return cupo;
    }
    
    
    
}
