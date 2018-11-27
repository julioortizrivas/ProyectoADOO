package controladores;

import java.sql.*;
import java.util.*;
import java.lang.reflect.Field;

public class Conector {
    private String url;
    private String base_datos;
    private String usuario;
    private String driver;
    private String pass;
    private Connection conexion;
    
    public  Conector(String bd, String usu, String url, String pass)
    {
        this.url=url;
        base_datos=bd;
	this.pass=pass;
	usuario=usu;
	driver = "com.mysql.jdbc.Driver";
	this.url="jdbc:mysql://"+url+"/";
    }

    public void conectar() 
    throws SQLException
    {
        try
	{
            Class.forName(driver);
            conexion=DriverManager.getConnection(url+base_datos,usuario,pass);
            System.out.println("Se ha conectado a "+base_datos+" exitosamente");
	}
	catch(Exception ex)
	{	
            System.out.println("ERROR EN LA CONEXION"+ex);
            conexion.close();
	}
        
    }

    public void desconectar()
    {
        try
	{
            conexion.close();
            System.out.println("Se ha desconectado de "+base_datos+" exitosamente");
	}
	catch(Exception ex)
	{	
            System.out.println("ERROR EN LA DESCONEXION");
	}
    }

    public String modificarDatos(String sql)
    {
	try
	{
            Statement statement=conexion.createStatement();
            //String sql="DELETE FROM Perros;";
            statement.executeUpdate(sql);
            return "Petición realizada con éxito.";
	}
	catch(SQLException ex)
	{
            System.out.println("ERROR EN LA CONEXION"+ex+"  holi ");
            return ex.getMessage();
	}
    }
    public ResultSet recuperarDatos(String query)
    {
        ResultSet resp = null;
        try
	{
            Statement statement=conexion.createStatement();
            resp=statement.executeQuery(query);
            /*System.out.println("******************************************Resultados de resultset");
            while(resp.next())
            {
                System.out.println(resp.getString(2));
            }*/			
	}
	catch(Exception e)
	{
            System.out.println("ERROR EN LA TABLA:"+e);
	}
        return resp;
    }
}
