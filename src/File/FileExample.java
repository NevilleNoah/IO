package File;

import java.io.File;

public class FileExample {
	public static void main(String args[]) {
		File file = new File("E:/myFile/file.txt");// �����ļ�����ָ��·��
		try {
			file.createNewFile();// ��ָ��·���������ļ�
			System.out.println("�÷����Ĵ�С�ǣ�" + file.getTotalSpace() / (1024 * 1024 * 1024) + "G");// ��ȡ�ļ�����λ�õĴ洢�ռ�Ĵ�С
			file.mkdirs();// ������·���µ������ļ��У�����myFile�����ڣ���ᴴ��myFile
			System.out.println("���ļ����ļ����ǣ�" + file.getName());
			System.out.println("���ļ��ĸ�Ŀ¼�ǣ�" + file.getParent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}