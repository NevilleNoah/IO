package PushBackInputStreamDemo;

/*
 * PushBackInputStream�ṩ���Խ����ݲ��뵽������ǰ�˵�����(��ȻҲ��������������)��
 * ʵ���Ƕ�ȡ����һ���ַ�����˵�����
 * �ܹ����������ֽ��������ƻػ������Ĵ�С��صģ������ַ��϶����ܴ��ڻ�����
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushBackInputStreamDemo {
	public static void main(String[] args) throws IOException {
		String str = "hello,rollenholt";
		PushbackInputStream push = null;// ��������������
		ByteArrayInputStream bat = null;// �����ֽ�����������
		bat = new ByteArrayInputStream(str.getBytes());
		push = new PushbackInputStream(bat);// �������������󣬽������ֽ�����������
		int temp = 0;
		while ((temp = push.read()) != -1) {
			// push.read()���ֽڶ�ȡ�����temp��,��ȡ����򷵻�-1
			if (temp == ',') {// �ж϶�ȡ�����Ƿ�Ϊ����
				push.unread(temp);// �ص�temp��λ��
				System.out.print("(����" + (char) temp + ")");// ������˵��ַ�
			} else {
				System.out.print((char) temp);// ��������ַ�
			}
		}
	}
}
