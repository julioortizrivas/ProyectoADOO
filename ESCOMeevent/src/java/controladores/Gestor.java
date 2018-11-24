
package controladores;

public class Gestor extends UsuarioRegistrado{
    
    public Gestor(String clv,String n,String aP,String aM)
    {
        super(clv,n,aP,aM);
    }
    public boolean crearEvento(String id,String n,String f,String h,String des,String du,String c,String lu,String ti,String org)
    {
        Conector conexion=new Conector("eventos","root","localhost:3306","");
        String query="INSERT INTO EVENTO(idEvento,Nombre,Fecha,Hora,Descrip,Duarcion,Cupo,idLugar,idGestor_reg,Fecha_reg,Hora_reg,idTipo,idOrganizador)"+
                    "VALUES('"+id+"','"+n+"','"+f+"','"+h+"','"+des+"','"+du+"',"+c+",'"+lu+"','"+clave+"',date(now()),time(now()),'"+ti+"','"+org+"');";
        try
        {
            conexion.conectar();
            System.out.println(id+","+n+","+f+","+h+","+des+","+du+","+c+","+lu+","+ti+","+org);
            if(conexion.modificarDatos(query))
            {
                    System.out.println("Hecho:"+query);
                
                
            }
        }
        catch(Exception ex)
        {
            System.out.println("ERROR CON EVENTO:"+ex.toString()+"//"+query);
        }
        return true;
    }
    public boolean darDeBajaEvento(String clvE)
    {
        
        return true;
    }
    public boolean modificarEvento(String clvE)
    {
        
        return true;
    }
    
}
