
package controladores;

public class Administrador extends UsuarioRegistrado{
    public Administrador(String clv,String n,String aP,String aM)
    {
        super(clv,n,aP,aM);
    }
    public boolean crearLugar()
    {
        return true;
    }
    public boolean modificarLugar(String clvL)
    {
        return true;
    }
    public boolean eliminarLugar(String clvL)
    {
        return true;
    }
    public boolean eliminarUsuario(String clvU)
    {
        return true;
    }
    public boolean darPermiso(String clvU,int tipoPermiso)
    {
        return true;
    }
    public boolean quitarPermiso(String clvU)
    {
        return true;
    }
}
