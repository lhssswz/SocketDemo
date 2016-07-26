package main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try{
			// ����һ��ServerSocket����8080�˿�
			ServerSocket server = new ServerSocket(8080);
			
			// �ȴ�����
			Socket socket = server.accept();
			
			// ���յ������ʹ��socket����ͨ�ţ�����BufferReader���ڶ�ȡ����
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = is.readLine();
			System.out.println("received from client: " + line);
			
			// ����PrintWriter���ڷ�������
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("received data: " + line);
			pw.flush();
			
			// �ر���Դ
			pw.close();
			is.close();
			socket.close();
			server.close();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
