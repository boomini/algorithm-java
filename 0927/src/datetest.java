import java.time.DayOfWeek;
import java.time.LocalDate;

public class datetest {
	public static void main(String[] args) {
		LocalDate day = LocalDate.of(2021, 10, 05);
		DayOfWeek we = day.getDayOfWeek();
		int num = we.getValue();
		System.out.println(num);
	}
}
