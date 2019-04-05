
package controladores;

import java.sql.ResultSet;

public class Organizador {
    private String clave;
    private String nombre;
    private String contacto;
    public Organizador(String clave)
    {
        String query="SELECT evento_organizadores.idOrganizador,Nombre,Contacto  FROM\n" +
                    "evento_organizadores INNER JOIN organizador_contacto\n" +
                    "ON evento_organizadores.idOrganizador=organizador_contacto.idOrganizador "+
                                    "WHERE evento_organizadores.idOrganizador LIKE '"+clave+"';";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            ResultSet res1;
            try
            {
               conexion.conectar();
               res1=conexion.recuperarDatos(query);
               if(res1.next())
               {
                   this.clave=res1.getString(1);
                   nombre=res1.getString(2);
                   contacto=res1.getString(3);
               }
               
               
            }
            catch(Exception ex)
            {
                System.out.println("ERROR:"+ex.toString());
            }
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }
    
    
    
}
