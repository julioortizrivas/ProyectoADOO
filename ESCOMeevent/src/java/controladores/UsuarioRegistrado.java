package controladores;

public class UsuarioRegistrado {
    protected String clave;
    protected String nombre;
    protected String apPaterno;
    protected String apMaterno;
   
    

	public UsuarioRegistrado(String clv,String n,String aP,String aM)
	{
            clave=clv;
            nombre=n;
            apPaterno=aP;
            apMaterno=aM;
	}

	public boolean inscribirEvento(String claveE)
	{
		return true;
	}
	public boolean darBajaEvento(String claveE)
	{
		return true;
	}
	public boolean modificarDatos()
	{
		return true;
	}
         public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }
}
