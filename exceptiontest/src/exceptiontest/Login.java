package exceptiontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("아이디: ");
		String id = in.readLine();
		System.out.println("비밀번호 : ");
		String pass = in.readLine();
		
		
		try {
			String name = login(id,pass);
			System.out.println(name+ "님 안녕하세요");
		} catch (PasswordNotMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (idNotMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String login(String id, String pass) throws PasswordNotMatchException, idNotMatchException {
		if(id.equals("ssafy")) {
			if(pass.equals("1234")) {
				return "홍길동";
			}else {
				throw new PasswordNotMatchException("비밀번호가 틀렸습니다.");
			}
		}else {
			throw new idNotMatchException("아이디가 틀렸습니다.");
			
		}
	}
}
