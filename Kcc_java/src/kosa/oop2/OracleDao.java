package kosa.oop2;

public class OracleDao extends Dao {

	public OracleDao() {
	}
	
	@Override
	public void insert() {
		System.out.println("OracleDao insert 호출");
	}

}
