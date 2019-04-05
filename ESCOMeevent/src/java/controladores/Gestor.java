
package controladores;

public class Gestor extends UsuarioRegistrado{
    
    public Gestor(String clv,String n,String aP,String aM)
    {
        super(clv,n,aP,aM);
    }
    public String crearEvento(String id,String n,String f,String h,String des,String du,String c,String lu,String ti,String org)
    {
        Conector conexion=new Conector("eventos","root","localhost:3306","");
        String query="INSERT INTO EVENTO(idEvento,Nombre,Fecha,Hora,Descrip,Duracion,Cupo,idLugar,idGestor_reg,Fecha_reg,Hora_reg,idTipo,idOrganizador)"+
                    "VALUES('"+id+"','"+n+"','"+f+"','"+h+"','"+des+"','"+du+"',"+c+",'"+lu+"','"+clave+"',date(now()),time(now()),'"+ti+"','"+org+"');";
        String mensaje="";
        try
        {
            conexion.conectar();
            System.out.println(id+","+n+","+f+","+h+","+des+","+du+","+c+","+lu+","+ti+","+org);
            
            if((mensaje=conexion.modificarDatos(query)).equals("Petición realizada con éxito."))
            {
                    System.out.println("Hecho:"+query);
                
                
            }
        }
        catch(Exception ex)
        {
            System.out.println("ERROR CON EVENTO:"+ex.toString()+"//"+query);
        }
        return mensaje;
    }
    public String darDeBajaEvento(String clvE)
    {
        Conector conexion=new Conector("eventos","root","localhost:3306","");
        
        String query="DELETE FROM EVENTO "
                + "WHERE idEvento LIKE '"+clvE+"';";
        String mensaje="";
        try
        {
            conexion.conectar();
            
            if((mensaje=conexion.modificarDatos(query)).equals("Petición realizada con éxito."))
            {
                    System.out.println("Hecho:"+query);
            }
        }
        catch(Exception ex)
        {
            System.out.println("ERROR CON EVENTO:"+ex.toString()+"//"+query);
            mensaje=ex.getMessage();
        }
        return mensaje;
    }
    public String modificarEvento(String id,String n,String f,String h,String des,String du,String c,String lu,String ti,String org)
    {
        Conector conexion=new Conector("eventos","root","localhost:3306","");
        
        String query="UPDATE EVENTO "
                + "SET Nombre='"+n+"', "
                + "Fecha='"+f+"', "
                + "Hora='"+h+"', "
                + "Descrip='"+des+"', "
                + "Duracion='"+du+"', "
                + "Cupo="+c+", "
                + "idLugar='"+lu+"', "
                + "idTipo='"+ti+"', "
                + "idOrganizador='"+org+"' "
                + "WHERE idEvento LIKE '"+id+"';";
                    
        String mensaje="";
        try
        {
            conexion.conectar();
            System.out.println(query);
            
            if((mensaje=conexion.modificarDatos(query)).equals("Petición realizada con éxito."))
            {
                    System.out.println("Hecho:"+query);
            }
        }
        catch(Exception ex)
        {
            System.out.println("ERROR CON EVENTO:"+ex.toString()+"//"+query);
            mensaje=ex.getMessage();
        }
        return mensaje;
    }
    
}
