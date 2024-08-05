package servlet.subject.s01;

import java.io.Serializable;

public class ProductVO implements Serializable {

	private int seq;
	private String product_name;

	public ProductVO() {
		super();
	}

	public ProductVO(int seq, String product_name) {
		this.seq = seq;
		this.product_name = product_name;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Override
	public String toString() {
		return "ProductVO [seq=" + seq + ", product_name=" + product_name + "]";
	}

}
