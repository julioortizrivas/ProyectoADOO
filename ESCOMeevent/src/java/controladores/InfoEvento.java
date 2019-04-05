
package controladores;

import java.sql.ResultSet;
import java.util.ArrayList;

public class InfoEvento {
    private String tipo;
    private String duracion;
    private int cupo;
    private String fecha;
    private String hora;
    private String desc;
    private String organizador;
    private String lugar;
    
    public InfoEvento(String clv)
    {
        String query="SELECT Fecha,Hora,Duracion,"+
                "(SELECT Nombre FROM evento_tipo WHERE idTipo=EVENTO.idTipo) AS TIPO,"+
                "(SELECT Nombre FROM evento_organizadores WHERE idOrganizador=EVENTO.idOrganizador) AS ORGANIZADOR,"+
                "(SELECT Nombre FROM LUGAR WHERE idLugar=EVENTO.idLugar) AS LUGAR,"+
                "Descrip FROM EVENTO WHERE idEvento LIKE '"+clv+"';";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            String query2="SELECT Cupo FROM vista_lugareseventos WHERE idEvento LIKE '"+clv+"';";
            ResultSet res1,res2;
            try
            {
               conexion.conectar();
               res1=conexion.recuperarDatos(query);
               res2=conexion.recuperarDatos(query2);
               res1.next();
               res2.next();
               tipo=res1.getString(4);
               duracion=res1.getString(3);
               cupo=Integer.parseInt(res2.getString(1));
               fecha=res1.getString(1);
               hora=res1.getString(2);
               desc=res1.getString(7);
               organizador=res1.getString(5);
               lugar=res1.getString(6);
            }
            catch(Exception ex)
            {
                System.out.println("ERROR:"+ex.toString());
            }
    }

    public String getTipo() {
        return tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getCupo() {
        return cupo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getDesc() {
        return desc;
    }

    public String getOrganizador() {
        return organizador;
    }

    public String getLugar() {
        return lugar;
    }
    
    
}
