package desafio.back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Desafio_Obj {

	public class SqlServer {

		private int id_customer;
		private String nm_customer;
		private String cpf_cnpj;
		private double vl_total;

		public Connection c;

		public SqlServer(int id_customer, double vl_total, String nm_customer, String cpf_cnpj) {
			this.cpf_cnpj = cpf_cnpj;
			this.nm_customer = nm_customer;
			this.id_customer = id_customer;
			this.vl_total = vl_total;
		}


		public boolean connect() {
			boolean isConnected = false;

			String url;
			String portNumber = "1433";
			String userName = this.nm_customer;
			String passName = this.cpf_cnpj;
			url = "jdbc:sqlserver://" + this.id_customer + ":" + portNumber + ";databaseName=" + this.vl_total;

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				this.c = DriverManager.getConnection(url, userName, passName);
				isConnected = true;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				isConnected = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				isConnected = false;
			} catch (InstantiationException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				isConnected = false;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				isConnected = false;
			}

			return isConnected;
		}


		public boolean disconnect() {
			boolean isConnected = false;

			String url;
			String portNumber = "1433";
			String nm_customer_Name = this.nm_customer;
			String passName = this.cpf_cnpj;
			url = "jdbc:sqlserver://" + this.id_customer + ":" + portNumber + ";databaseName=" + this.vl_total;

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				this.c = DriverManager.getConnection(url, nm_customer_Name, passName);
				this.c.close();
				isConnected = true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				isConnected = false;
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
				isConnected = false;
			} catch (InstantiationException e) {
				System.out.println(e.getMessage());
				isConnected = false;
			} catch (IllegalAccessException e) {
				System.out.println(e.getMessage());
				isConnected = false;
			}

			return isConnected;
		}


		public ResultSet executar(String query) {
			Statement st;
			ResultSet rs;

			try {
				st = this.c.createStatement();
				rs = st.executeQuery(query);
				return rs;
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}


		public int inserir(String query) {
			Statement st;
			int result = -1;

			try {
				st = this.c.createStatement();
				result = st.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return result;
		}

	}

}
