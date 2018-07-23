package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class logflieread {
	public static void main(String[] args) {
		// 1. BufferedReader 객체 만들기
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\\\Users\\\\503-20\\\\Desktop\\\\access_log.txt"));

			// 4.HashMap을 활용해서 첫 번째 데이터의 횟수를 저장하고 출력
			// Map은 동일한 키를 갖고 데이터를 저장하면 수정이 발생하고, 없는 키의 값을 읽으려 하면 null을 리턴한다.
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<String, Integer> traffic = new HashMap<>();

			while (true) {
				// 2. 줄 단위로 데이터 읽기 , BufferedReader 객체를 생성하는 부분 뒤에 작성.
				// BufferedReader클래스의 readLine이라는 메소드가 줄 단 위로 읽어서 String으로 리턴해주는 메소드.
				// 이 메소드는 읽은 데이터가 없으면 null을 리턴함.
				String line = br.readLine();
				if (line == null)
					break;
				// 3. 줄 단위로 읽은 데이터를 공백으로 분할해서 첫 번째에 있는 데이터만 출력
				// 문자열을 분할할 때는 split이나 substring이라는 메소드를 이용한다.
				// split은 문자열이나 패턴을 가지고 분할하고 substring은 위치를 가지고 분할한다.
				String[] ar = line.split(" ");
				// ip로 저장된 데이터를 가져온다.
				Integer count = map.get(ar[0]);
				// 저장된 데이터가 없으면 1을 저장한다.
				if (count == null) {
					map.put(ar[0], 1);
				}
				// 저장된 데이터가 있으면 1을 더해서 저장
				else {
					map.put(ar[0], count + 1);
				}
				// 5. ip별 트래픽의 합계를 저장해서 출력
				// 트래픽 한 줄을 기준으로 공백으로 분할하면 10번째에 존재한다.
				// -와 "-"라는 이상한 데이터가 포함되어 있으므로 전처리를 잘 해야 함.

				Integer traf = traffic.get(ar[0]);
				if (traf == null) {
					if (!ar[9].equals("\"-\"") && !ar[9].equals("-")) {
						traffic.put(ar[0], Integer.parseInt(ar[9]));
					}
				} else {
					if (!ar[9].equals("\"-\"") && !ar[9].equals("-")) {
						traffic.put(ar[0], traf + Integer.parseInt(ar[9]));
					}
				}
				// 맵의 모든 데이터를 출력
				Set<String> keySet = map.keySet();
				for (String key : keySet) {
					System.out.println(key + ": " + map.get(key));
				}
				System.out.println("=============================");
				keySet = traffic.keySet();
				for (String key : keySet) {
					System.out.println(key + ": " + traffic.get(key));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
