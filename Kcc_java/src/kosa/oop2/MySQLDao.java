package kosa.oop2;

public class MySQLDao extends Dao {

	public MySQLDao() {
	}

	@Override
	public void insert() {
		System.out.println("MySQLDao insert 호출");
	}

}
