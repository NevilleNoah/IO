package FileLength;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileLength {
	public static void main(String args[]) {
		int count = 0;// 用于统计文件的字节长度
		InputStream streamReader = null;// 字节流
		try {
			streamReader = new FileInputStream(new File("E:/myFile/test.jpg"));// FileInputStreamReader选取目标文件
			while (streamReader.read() != -1) {
				count++;
			}
			System.out.println("文件长度是：" + count + "字节");
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				streamReader.close();// FileInoutStreamReader有缓冲区，使用完毕后必须关闭
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
