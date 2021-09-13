package solution.programmers;

class Solution_77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int num = 1;
        int arr[][] = new int[rows][columns];
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		arr[i][j] = num++;
        	}
        }
        
        for(int i=0; i<queries.length; i++) {
        	int min = Integer.MAX_VALUE;
        	int x1 = queries[i][0]-1;
        	int y1 = queries[i][1]-1;
        	int x2 = queries[i][2]-1;
        	int y2 = queries[i][3]-1;
        	int temp = arr[x1][y1];
        	
        	for(int y=y1; y<y2; y++) {
        		int temp2 = arr[x1][y+1];
        		arr[x1][y+1] = temp;
        		min = Math.min(temp, min);
        		temp = temp2;
        	}
        	
        	for(int x=x1; x<x2; x++) {
        		int temp2 = arr[x+1][y2]; 
        		arr[x+1][y2] = temp;
        		min = Math.min(temp, min);
        		temp = temp2;
        		
        	}
        	
        	for(int y=y2; y>y1; y--) {
        		int temp2 = arr[x2][y-1]; 
        		arr[x2][y-1] = temp;
        		min = Math.min(temp, min);
        		temp = temp2;
        	}
        	
        	for(int x=x2; x>x1; x--) {
        		int temp2 = arr[x-1][y1]; 
        		arr[x-1][y1] = temp;
        		min = Math.min(temp, min);
        		temp = temp2;
        	}
        	answer[i] = min;
        }
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}
public class level2_77485 {
	public static void main(String[] args) {
		Solution_77485 sol = new Solution_77485();
		System.out.println(sol.solution(6, 6, new int[][] {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}}));
		System.out.println(sol.solution(3, 3, new int[][] {{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}}));
		System.out.println(sol.solution(100, 97, new int[][] {{1,1,100,97}}));
	}
}
