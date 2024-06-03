package kosa.oop2;

public class MyService {

	private Dao dao; // 연관관계

	public MyService() {
	}

	public MyService(Dao dao) {
		super();
		this.dao = dao;
	}

	public void insertService() {
		dao.insert();
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

}
