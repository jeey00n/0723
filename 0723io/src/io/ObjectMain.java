package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectMain {

	public static void main(String[] args) {
		// ��ü������ �����͸� ����� �� �ִ� Ŭ������ ���� ����
		ObjectInputStream ois = null;
		try {
			//���Ͽ� ��ü ������ ����� �� �ִ� Ŭ������ ��ü �����
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));
			
			//read�� �о�� ���� ObjectŸ������ �����ϱ� ������ ��� �̿��� �뵵�� ����� ���� 
			//�׻� ���� ����ȯ�� �ؼ�, ������ �ڷ������� �ǵ����� ����ؾ� �Ѵ�.
			Member member = (Member)ois.readObject();
			System.out.println(member.getPw());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(ois!=null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
