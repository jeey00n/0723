package io;

import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) {
		// ����, ��Ʈ��ũ, �����ͺ��̽����� Ŭ�������� ����ó���� �����Ѵ�.
		PrintWriter pw = null;
		try {
			//���� ���丮�� ���� ����
			pw = new PrintWriter("./file.txt");
			//���Ͽ� ���ڿ� ���
			pw.println("�ȳ��ϼ��� �ݰ����ϴ�.");
			//������ ������ ���� ���
			pw.flush();
			
			 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
