package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class logflieread {
	public static void main(String[] args) {
		// 1. BufferedReader ��ü �����
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\\\Users\\\\503-20\\\\Desktop\\\\access_log.txt"));

			// 4.HashMap�� Ȱ���ؼ� ù ��° �������� Ƚ���� �����ϰ� ���
			// Map�� ������ Ű�� ���� �����͸� �����ϸ� ������ �߻��ϰ�, ���� Ű�� ���� ������ �ϸ� null�� �����Ѵ�.
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<String, Integer> traffic = new HashMap<>();

			while (true) {
				// 2. �� ������ ������ �б� , BufferedReader ��ü�� �����ϴ� �κ� �ڿ� �ۼ�.
				// BufferedReaderŬ������ readLine�̶�� �޼ҵ尡 �� �� ���� �о String���� �������ִ� �޼ҵ�.
				// �� �޼ҵ�� ���� �����Ͱ� ������ null�� ������.
				String line = br.readLine();
				if (line == null)
					break;
				// 3. �� ������ ���� �����͸� �������� �����ؼ� ù ��°�� �ִ� �����͸� ���
				// ���ڿ��� ������ ���� split�̳� substring�̶�� �޼ҵ带 �̿��Ѵ�.
				// split�� ���ڿ��̳� ������ ������ �����ϰ� substring�� ��ġ�� ������ �����Ѵ�.
				String[] ar = line.split(" ");
				// ip�� ����� �����͸� �����´�.
				Integer count = map.get(ar[0]);
				// ����� �����Ͱ� ������ 1�� �����Ѵ�.
				if (count == null) {
					map.put(ar[0], 1);
				}
				// ����� �����Ͱ� ������ 1�� ���ؼ� ����
				else {
					map.put(ar[0], count + 1);
				}
				// 5. ip�� Ʈ������ �հ踦 �����ؼ� ���
				// Ʈ���� �� ���� �������� �������� �����ϸ� 10��°�� �����Ѵ�.
				// -�� "-"��� �̻��� �����Ͱ� ���ԵǾ� �����Ƿ� ��ó���� �� �ؾ� ��.

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
				// ���� ��� �����͸� ���
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
