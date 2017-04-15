package DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
	public static void main(String[] args) {
		Member[] members = { new Member("aa", 18), new Member("bb", 20), new Member("cc", 23) };
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("E:/javaTest/javaTest.txt"));
			for (Member member : members) {
				// д��UTF�ַ���
				dataOutputStream.writeUTF(member.getName());
				// д��int����
				dataOutputStream.writeInt(member.getAge());
			}
			// �������ݴ�����Ŀ�ĵ�
			dataOutputStream.flush();
			// �ر����������
			dataOutputStream.close();

			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(args[0]));
			// ��ȡ����ԭ����
			for (int i = 0; i < members.length; i++) {
				// ��ȡUTF�ַ���
				String name = dataInputStream.readUTF();
				// ��ȡint����
				int age = dataInputStream.readInt();
				members[i] = new Member(name, age);
			}
			// �ر���
			dataInputStream.close();

			// ��ʾ��ԭ������
			for (Member member : members) {
				System.out.printf("%s\t%d%n", member.getName(), member.getAge());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Member {
	private String name;
	private int age;

	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
}
