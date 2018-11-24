
package controladores;

public class Evento {
    private String clave;
    private String nombre;
    private InfoEvento info;
    //private String clave;
    
    public Evento(String c,String n)
    {
        clave=c;
        nombre=n;
        info=new InfoEvento(c);
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public InfoEvento getInfo() {
        return info;
    }
    
}
