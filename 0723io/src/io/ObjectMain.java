package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectMain {

	public static void main(String[] args) {
		// 객체단위로 데이터를 기록할 수 있는 클래스의 변수 선언
		ObjectInputStream ois = null;
		try {
			//파일에 객체 단위로 기록할 수 있는 클래스의 객체 만들기
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));
			
			//read로 읽어올 때는 Object타입으로 리턴하기 때문에 출력 이외의 용도로 사용할 때는 
			//항상 강제 형변환을 해서, 원래의 자료형으로 되돌려서 사용해야 한다.
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
