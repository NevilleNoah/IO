package FileCopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		byte[] buffer = new byte[512];// 一次取出的字节大小，即缓冲区
		int numberRead = 0;
		FileInputStream input = null;// 输入流
		FileOutputStream output = null;// 输出流
		try {
			input = new FileInputStream("E:/Study/Java/Demo/1.txt");// 从哪里复制
			output = new FileOutputStream("E:/Study/Java/Demo/IO/2.txt");// 复制到哪,如果文件不存在会自动创建
			while ((numberRead = input.read(buffer)) != -1) {
				// numberRead的目的在于防止最后一次读取的字节小于buffer长度
				output.write(buffer, 0, numberRead); // 否则会自动被填充0
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
