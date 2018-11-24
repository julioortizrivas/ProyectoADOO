import java.sql.*;
import java.util.*;
import java.lang.reflect.Field;


public class Conector
{
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
	{
		try
		{
			Class.forName(driver);
			conexion=DriverManager.getConnection(url+base_datos,usuario,pass);
			System.out.println("Se ha conectado a "+base_datos+" exitosamente");
			//conexion.close();
		}
		catch(Exception ex)
		{	
			System.out.println("ERROR EN LA CONEXION",JOptionPane.ERROR_MESSAGE);
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

	public void modificarDatos(String sql)
	{
		try
		{
			Statement statement=conexion.createStatement();
			//String sql="DELETE FROM Perros;";
			statement.executeUpdate(sql);
		
		}
		catch(Exception ex)
		{
			System.out.println("ERROR EN LA CONEXION"+ex);
		}
	}
	public void recuperarDatos(String query)
	{
		try
		{
			Statement statement=conexion.createStatement();
			ResultSet resp=statement.executeQuery(query);
			while(resp.next())
			{
				System.out.println(resp.getString(2));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("ERROR EN LA TABLA");
		}
	}

	public static void main(String[] s)
	{

		System.out.println("Holi");
		Conector conexion=new Conector("eventos","root","localhost:3306","");
		conexion.conectar();
		//String query="INSERT INTO usuario_reg VALUES('2014040063','Alvarez','Hernandez','Lalo', '1998-04-27','noseametiche@nolose.com','5544332211','holi','2018-10-16','09:34:00');";
		//String query="DELETE FROM usuario_reg WHERE idUSUARIO_REG='2014040063';";
		String query="SELECT * FROM usuario_reg WHERE idUSUARIO_REG='2014040063';";
		conexion.recuperarDatos(query);
		//conexion.modificarDatos(query);
		conexion.desconectar();
	}
}