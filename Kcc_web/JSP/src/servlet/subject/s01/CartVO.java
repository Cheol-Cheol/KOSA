package servlet.subject.s01;

public class CartVO {

	private int seq;
	private int member_id;
	private int product_id;

	public CartVO() {
		super();
	}

	public CartVO(int member_id, int product_id) {
		this.member_id = member_id;
		this.product_id = product_id;
	}

	public CartVO(int seq, int member_id, int product_id) {
		this.seq = seq;
		this.member_id = member_id;
		this.product_id = product_id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "CartVO [seq=" + seq + ", member_id=" + member_id + ", product_id=" + product_id + "]";
	}

}
