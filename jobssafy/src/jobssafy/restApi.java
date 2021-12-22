package jobssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class restApi {
	public static void main(String[] args) throws IOException {
		//HttpURLConnection을 사용하여 JSON POST 요청 작성
		//1.URL 객체 만들기
		URL url = new URL("http://13.125.222.176/quiz/jordan");
		//2. 연결 열기
		//HttpURLConnection=> url객체에서 openConnection 메서드를 호출하여 HttpURLConnection 객체를 가져올 수 있다.
		//추상클래스이므로 HttpURLConnection을 직접 인스턴스화 할 수 없다.
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		//3. 요청방법 설정
		con.setRequestMethod("POST");
		//4. 요청 콘텐츠 유형 헤더 매개 변수 설정
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		//5. 응답 형식 유형 설정
		con.setRequestProperty("Accept", "application/json");
		//6. 콘텐츠를 보내는데 연결이 사용되는지 확인
		con.setDoOutput(true);
		//7. 본문 생성
		String jsonInputString ="{\"nickname\": \"서울 4반 김보민\" , \"yourAnswer\" : \"kubernetes\"}";
		try(OutputStream os = con.getOutputStream()){
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input,0,input.length);
		}
		//8. 입력 스트림에서 응답 읽기
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(con.getInputStream(), "utf-8"))){
			System.out.println(br.readLine());
		}
	}
}
