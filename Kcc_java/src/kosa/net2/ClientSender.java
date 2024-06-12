package kosa.net2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSender extends Thread {

	private Socket socket;

	public ClientSender() {
	}

	public ClientSender(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			while (true) {
				String str = br.readLine();
				if (str.equals("bye")) {
					break;
				}
				writer.println(str);
				writer.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
