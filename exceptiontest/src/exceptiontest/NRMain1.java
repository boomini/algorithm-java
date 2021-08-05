package exceptiontest;

import java.io.FileNotFoundException;

public class NRMain1 {

	public static void main(String[] args) {
		NonRuntimeExceptionTest nret = new NonRuntimeExceptionTest();
		System.out.println("fileRead1 호출!!!");
		nret.fileRead("a.txt");
		System.out.println("fileRead1 호출!!!");
		try {
			nret.fileRead2("a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("a.txt 없어요!!");
		}
	}
}
