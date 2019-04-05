package controladores;

import java.sql.ResultSet;

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
        public UsuarioRegistrado(String clv)
	{
            String query="SELECT idUSUARIO_REG,Nombre,ApPat,ApMat FROM USUARIO_REG WHERE idUSUARIO_REG LIKE '"+clv+"';";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            ResultSet res1;
            try
            {
                conexion.conectar();
                res1=conexion.recuperarDatos(query);
                if(res1.next())
                {
                    clave=res1.getString(1);
                    nombre=res1.getString(2);
                    apPaterno=res1.getString(3);
                    apMaterno=res1.getString(4);
                }
                
            }
            catch(Exception ex)
            {
                clave="ERROR";
                clave="ERROR";
            }
	}

	public String inscribirEvento(String claveE)
	{
            String mensaje="";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            String query="INSERT INTO usuario_reg_has_evento(idUsuario_reg, idEvento,Fecha,Hora) VALUES ('"+clave+"','"+claveE+"',date(now()),time(now()));";
            try
            {
                conexion.conectar();

                if((mensaje=conexion.modificarDatos(query)).equals("Petici&oacuten realizada con &eacutexito."))
                {
                    mensaje="Te has inscrito de forma correcta al evento.";
                        System.out.println("Hecho:"+query);


                }
            }
            catch(Exception ex)
            {
                System.out.println("ERROR CON EVENTO:"+ex.toString()+"//"+query);
            }
                
            return mensaje;
	}
	public String darBajaEvento(String claveE)
	{
            String mensaje="";
            Conector conexion=new Conector("eventos","root","localhost:3306","");
            String query="DELETE FROM usuario_reg_has_evento WHERE idUsuario_reg LIKE '"+clave+"' AND idEvento LIKE '"+claveE+"';";
            try
            {
                conexion.conectar();

                if((mensaje=conexion.modificarDatos(query)).equals("Petición realizada con éxito."))
                {
                    mensaje="Lamentamos que no vayas a asistir =( . Tu registro ha quedado cancelado";
                        System.out.println("Hecho:"+query);


                }
            }
            catch(Exception ex)
            {
                System.out.println("ERROR CON EVENTO:"+ex.toString()+"//"+query);
            }
                
            return mensaje;
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
