package kosa.net2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive extends Thread {

	private Socket socket;

	public ClientReceive() {
	}

	public ClientReceive(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String str = br.readLine();
				if (str == null) { // 수신 종료
					break;
				}
				System.out.println("클라이언트 수신: " + str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
