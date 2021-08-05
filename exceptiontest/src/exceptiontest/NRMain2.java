package exceptiontest;

import java.io.FileNotFoundException;

public class NRMain2 {
	public static void main(String[] args) {
		NonRuntimeExceptionTest nret = new NonRuntimeExceptionTest();
		System.out.println("fileRead1 호출!!!");
		nret.fileRead("a.txt");
		System.out.println("fileRead1 호출!!!");
		try {
			nret.fileRead2("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println("a.txt대신 b.txt로 사용!!!");
			//e.printStackTrace();
		}
	}
}
