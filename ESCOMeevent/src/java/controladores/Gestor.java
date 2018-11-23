
package controladores;

public class Gestor extends UsuarioRegistrado{
    
    public Gestor(String clv,String n,String aP,String aM)
    {
        super(clv,n,aP,aM);
    }
    public boolean crearEvento()
    {
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
