package kosa.subject.randomSeat;

public class Seat {

	private int SeatNo;
	private Student student;

	public Seat() {
	}

	public Seat(int seatNo, Student student) {
		this.SeatNo = seatNo;
		this.student = student;
	}

	public int getSeatNo() {
		return SeatNo;
	}

	public void setSeatNo(int seatNo) {
		SeatNo = seatNo;
	}

	public void printSeatInfo() {
		System.out.println("printSeatInfo");
	}

}
