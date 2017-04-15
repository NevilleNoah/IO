package ObjectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStream {
	public static void main(String[] args) {
		ObjectOutputStream objectWriter = null;
		ObjectInputStream objectReader = null;

		try {
			objectWriter = new ObjectOutputStream(new FileOutputStream("E:/Study/Java/Demo/student.txt"));
			// д������ѧ������
			objectWriter.writeObject(new Student("aa", 18));
			objectWriter.writeObject(new Student("bb", 21));
			objectWriter.writeObject(new Student("cc", 22));
			// ��ȡ����ѧ������
			objectReader = new ObjectInputStream(new FileInputStream("E:/Study/Java/Demo/student.txt"));
			for (int i = 0; i < 3; i++) {
				System.out.println(objectReader.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				objectWriter.close();
				objectReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

// д�����д�������Ӧ�������ʵ��Serializable����ӿ�
class Student implements Serializable {
	private String name;
	private int ago;

	Student(String name, int ago) {
		this.name = name;
		this.ago = ago;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgo() {
		return ago;
	}

	public void setAgo(int ago) {
		this.ago = ago;
	}

}
