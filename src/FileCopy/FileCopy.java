package FileCopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		byte[] buffer = new byte[512];// һ��ȡ�����ֽڴ�С����������
		int numberRead = 0;
		FileInputStream input = null;// ������
		FileOutputStream output = null;// �����
		try {
			input = new FileInputStream("E:/Study/Java/Demo/1.txt");// �����︴��
			output = new FileOutputStream("E:/Study/Java/Demo/IO/2.txt");// ���Ƶ���,����ļ������ڻ��Զ�����
			while ((numberRead = input.read(buffer)) != -1) {
				// numberRead��Ŀ�����ڷ�ֹ���һ�ζ�ȡ���ֽ�С��buffer����
				output.write(buffer, 0, numberRead); // ������Զ������0
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
