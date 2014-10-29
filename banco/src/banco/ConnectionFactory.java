package banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String USERNAME = "SYSDBA";
	private static final String PASSWORD = "masterkey";
	private static final String DATABASE_URL = "jdbc:firebirdsql:localhost/3050:d:/agenda.fbd";

	public static Connection criarConexao() throws Exception{
		Class.forName("org.firebirdsql.jdbc.FBDriver"); 
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception{

		Connection con = criarConexao();

		if(con != null){
			System.out.println("Conexão obtida com sucesso!" + con);
			con.close();
		}

	}
}