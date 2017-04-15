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
				// 写入UTF字符串
				dataOutputStream.writeUTF(member.getName());
				// 写入int数据
				dataOutputStream.writeInt(member.getAge());
			}
			// 所有数据传输至目的地
			dataOutputStream.flush();
			// 关闭数据输出流
			dataOutputStream.close();

			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(args[0]));
			// 读取并还原对象
			for (int i = 0; i < members.length; i++) {
				// 读取UTF字符串
				String name = dataInputStream.readUTF();
				// 读取int数据
				int age = dataInputStream.readInt();
				members[i] = new Member(name, age);
			}
			// 关闭流
			dataInputStream.close();

			// 显示还原的数据
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
