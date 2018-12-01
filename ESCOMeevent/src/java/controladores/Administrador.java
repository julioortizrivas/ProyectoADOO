
package controladores;

public class Administrador extends UsuarioRegistrado{
    public Administrador(String clv,String n,String aP,String aM)
    {
        super(clv,n,aP,aM);
    }
    
    public String crearLugar(String idLugar,String nomLugar,String ubiLugar,String descLugar,String cupo)
    {
        String mensaje="";
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="INSERT INTO LUGAR VALUES('"+idLugar+"','"+nomLugar+"','"+ubiLugar+"','"+descLugar+"',"+cupo+",date(now()),time(now()));";
            conexion.modificarDatos(query);
           mensaje="Se ha registrado al lugar con éxito";
        }
        catch(Exception ex)
        {
            mensaje="Error al ingresar el lugar "+nomLugar;
        }
        return mensaje;
    }
    public String modificarLugar(String idLugar,String nomLugar,String ubiLugar,String descLugar,String cupo)
    {
        String mensaje="";
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="UPDATE LUGAR "
                    + "SET Nombre='"+nomLugar+"',"
                    + "Ubicación='"+ubiLugar+"',"
                    + "Descrip='"+descLugar+"',"
                    + "Cupo="+cupo+" "+
                    "WHERE idLugar LIKE '"+idLugar+"';";
            conexion.modificarDatos(query);
           mensaje="Se ha modificado el lugar con éxito";
        }
        catch(Exception ex)
        {
            mensaje="Error al modificar el lugar "+nomLugar;
        }
        return mensaje;
    }
    public String eliminarLugar(String idLugar)
    {
        String mensaje="";
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="DELETE FROM LUGAR "
                    + "WHERE idLugar LIKE '"+idLugar+"';";
            conexion.modificarDatos(query);
           mensaje="Se ha modificado el lugar con éxito";
        }
        catch(Exception ex)
        {
            mensaje="Error al eliminar el lugar "+idLugar+"<br />"+ex.getMessage();
        }
        return mensaje;
    }
    
    
     public String crearOrganizador(String clveOrg,String nomOrg,String contactOrg)
    {
        String mensaje="";
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="INSERT INTO EVENTO_ORGANIZADORES VALUES('"+clveOrg+"','"+nomOrg+"');";
            String query2="INSERT INTO ORGANIZADOR_CONTACTO VALUES('"+clveOrg+"','"+contactOrg+"');";
            conexion.modificarDatos(query);
            conexion.modificarDatos(query2);
            mensaje="Se ha registrado al organizador con éxito";
        }
        catch(Exception ex)
        {
            mensaje="Error al ingresar al organizador";
        }
        return mensaje;
    }
    public String modificarOrganizador(String clveOrg,String nomOrg,String contactOrg)
    {
        String mensaje="";
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="UPDATE EVENTO_ORGANIZADORES "+
                    "SET Nombre='"+nomOrg+"' WHERE idOrganizador LIKE '"+clveOrg+"';";
            String query2="UPDATE ORGANIZADOR_CONTACTO "+
                    "SET Contacto='"+contactOrg+"' WHERE idOrganizador LIKE '"+clveOrg+"';";
            conexion.modificarDatos(query);
            conexion.modificarDatos(query2);
            mensaje="Se ha modificado al organizador con éxito";
        }
        catch(Exception ex)
        {
            mensaje="Error al modificar al organizador "+nomOrg;
        }
        return mensaje;
    }
    public String eliminarOrganizador(String clveOrg)
    {
        String mensaje="";
        try
        {
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            conexion.conectar();   
            String query="DELETE FROM EVENTO_ORGANIZADORES "+
                    " WHERE idOrganizador LIKE '"+clveOrg+"';";
            String query2="DELETE FROM ORGANIZADOR_CONTACTO "+
                    "WHERE idOrganizador LIKE '"+clveOrg+"';";
            conexion.modificarDatos(query2);
            conexion.modificarDatos(query);
            mensaje="Se ha modificado al organizador con éxito";
        }
        catch(Exception ex)
        {
            mensaje="Error al eliminar al organizador "+clveOrg;
        }
        return mensaje;
    }
    
    
    
    public String eliminarUsuario(String clvU)
    {
        return "";
    }
    public String darPermiso(String clvU,int tipoPermiso)
    {
        return "";
    }
    public String quitarPermiso(String clvU)
    {
        return "";
    }
}
