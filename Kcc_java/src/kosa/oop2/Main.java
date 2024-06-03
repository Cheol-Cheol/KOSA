package kosa.oop2;

public class Main {

	public static void main(String[] args) {

		Dao oracleDao = new OracleDao();
		Dao mySQLDao = new MySQLDao();

		MyService service = new MyService(mySQLDao);

		service.insertService();

	}

}
