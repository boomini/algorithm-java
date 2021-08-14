package solution.test.nexttoss;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        long VAT = 0;//부가가치세
        double FreeAmount = 0; //과세금액
        long servicePrice = orderAmount - serviceFee; //공급대가
        if(servicePrice - taxFreeAmount==1) {
        	return 0;
        }
        long a = (servicePrice - taxFreeAmount)*10;
        
        FreeAmount = (servicePrice - taxFreeAmount)*(10/9);
        if(FreeAmount%10!=0) VAT = (long) (FreeAmount/10) + 1;
        else VAT =  (long) (FreeAmount/10);
        return VAT;
    }
}

public  class challenges {
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		System.out.println(sol.solution(321654987,12345,67));
	}
}




