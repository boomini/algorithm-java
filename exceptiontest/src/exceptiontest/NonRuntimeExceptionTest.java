package exceptiontest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NonRuntimeExceptionTest {
	public void fileRead(String fileName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			int s= fis.read();
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName+"파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void fileRead2(String fileName) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
	}
}
