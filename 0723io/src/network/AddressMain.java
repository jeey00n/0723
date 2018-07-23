package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressMain {

	public static void main(String[] args) {
		try {
			//주소 정보 1개 가져오기
			InetAddress addr = InetAddress.getByName("www.naver.com");
			System.out.println(addr);
			System.out.println("=============================");
			InetAddress []ar = InetAddress.getAllByName("www.naver.com");
			for(InetAddress imsi : ar) {
				System.out.println(imsi);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
