package File;

import java.io.File;

public class FileExample {
	public static void main(String args[]) {
		File file = new File("E:/myFile/file.txt");// 创建文件对象并指定路径
		try {
			file.createNewFile();// 在指定路径创建空文件
			System.out.println("该分区的大小是：" + file.getTotalSpace() / (1024 * 1024 * 1024) + "G");// 获取文件所在位置的存储空间的大小
			file.mkdirs();// 创建该路径下的所有文件夹，假设myFile不存在，则会创建myFile
			System.out.println("该文件的文件名是：" + file.getName());
			System.out.println("该文件的父目录是：" + file.getParent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}