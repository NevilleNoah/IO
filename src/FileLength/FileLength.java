package FileLength;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileLength {
	public static void main(String args[]) {
		int count = 0;// ����ͳ���ļ����ֽڳ���
		InputStream streamReader = null;// �ֽ���
		try {
			streamReader = new FileInputStream(new File("E:/myFile/test.jpg"));// FileInputStreamReaderѡȡĿ���ļ�
			while (streamReader.read() != -1) {
				count++;
			}
			System.out.println("�ļ������ǣ�" + count + "�ֽ�");
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				streamReader.close();// FileInoutStreamReader�л�������ʹ����Ϻ����ر�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
