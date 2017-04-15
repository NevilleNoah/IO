package PushBackInputStreamDemo;

/*
 * PushBackInputStream提供可以将数据插入到输入流前端的能力(当然也可以做其他操作)。
 * 实质是读取到下一个字符后回退的做法
 * 能够插入的最大字节数是与推回缓冲区的大小相关的，插入字符肯定不能大于缓冲区
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushBackInputStreamDemo {
	public static void main(String[] args) throws IOException {
		String str = "hello,rollenholt";
		PushbackInputStream push = null;// 声明回退流对象
		ByteArrayInputStream bat = null;// 声明字节数组流对象
		bat = new ByteArrayInputStream(str.getBytes());
		push = new PushbackInputStream(bat);// 创建回退流对象，将拆解的字节数组流传入
		int temp = 0;
		while ((temp = push.read()) != -1) {
			// push.read()逐字节读取存放在temp中,读取完成则返回-1
			if (temp == ',') {// 判断读取符号是否为逗号
				push.unread(temp);// 回到temp的位置
				System.out.print("(回退" + (char) temp + ")");// 输入回退的字符
			} else {
				System.out.print((char) temp);// 否则输出字符
			}
		}
	}
}
