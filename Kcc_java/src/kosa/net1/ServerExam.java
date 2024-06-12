package kosa.net1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(9000);
			System.out.println("서버 실행중........");

			socket = serverSocket.accept(); // clientSocket

			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			byte[] arr = new byte[100];
			in.read(arr); // 클라이언트로부터 전달받은 데이터

			System.out.println("클라이언트에서 보낸 메시지: " + new String(arr));

			String message = "Hello Client!!!";
			out.write(message.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				serverSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
