package jobssafy;
import java.io.IOException;
import java.util.*;

interface Opponent{
    int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]);
}


public class Main {

// DO NOT INCLUDE ANY FILES	
// 아래 hunt메소드를 작성해서 제출하세요.
    static Opponent Me=new Opponent(){
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
        	System.out.println(opp+" "+turn+" "+opp_prev+" "+opp_last_pattern[0][0]);
            int result = DEER;
            System.out.println("현재 턴: "+turn+"상대가 이전에 사냥한 동물"+opp_prev);
            boolean exist_deer=false;
            if(opp_last_pattern[0][0] != -1) {
            	int i=0;
            	if(turn==0) {
            		//전라운드가 있고 첫번째 turn일때
            		int first = opp_last_pattern[0][0];
            		if(first==DEER) {
            			return DEER;
            		}else {
            			return SNAKE;
            		}
            	}else {
            		result=opp_prev;

            	}

            	
            	for(; i<10; i++) {
            		System.out.println(opp_last_pattern[0][i]);
            		if(opp_last_pattern[0][i] ==DEER) {
            			exist_deer = true;
            			break;
            		}
            	}
            	System.out.println("\n");
            }
            else if(opp_last_pattern[0][0]==-1) {
            	//첫라운드 첫턴은 무조건 뱀
        		return SNAKE;
        	}
            if(exist_deer==false) {
            	//만약 사슴이 존재할 확률이 없다면 뱀출력
            	result=SNAKE;
            }
        	return result;
        }
    };
    
    static Opponent Opponent1=new Opponent(){
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            return 0;
        }
    };

    static Opponent Opponent2=new Opponent(){
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            if (turn == 0) return 1;
            return opp_prev;
        }
    };

    static Opponent Opponent3=new Opponent(){
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            if (turn == 0) return 2;
            return opp_prev;
        }
    };

    private static int DEER = 0;
    private static int RABBIT = 1;
    private static int SNAKE = 2;

    private static Opponent[] f = new Opponent[100];
    private static String[] names = new String[100];
    private static int f_inx = 0;
    static void Register(String name, Opponent func)
    {
        names[f_inx] = name;
        f[f_inx++] = func;
    };

    public static void main(String[] args) throws IOException {

        Random random = new Random();

        int[] total_score = new int[150];
        int[][][] last_pattern = new int[150][150][10]; // [팀][대전][패턴]
        int[] pattern_count = new int[150];

        Register("Me", Me);
        
        Register("Opp1", Opponent1);
        Register("Opp2", Opponent2);
        Register("Opp3", Opponent3);

        for (int i = 0; i<140; i++)
            for (int j = 0; j<140; j++)
                for (int k = 0; k<10; k++)
                    last_pattern[i][j][k] = -1;

        for (int i = 1; i<f_inx; i++) {
            for (int j = 0; j < f_inx; j++) {

                int team_a = j % f_inx; // 여기부터 i, j를 team_a, team_b로 바꿔줘야됨
				// 0 / 3, 1 / 3, 2 /3,
                int team_b = (j + i) % f_inx;
				// 1 / 3, 2 / 3, 0 / 3
                System.out.println(String.format("[%s] vs [%s]", names[team_a], names[team_b]));

                int a_game_score = 0;
                int b_game_score = 0;

                int prev_a = -1;
                int prev_b = -1;

                int team_a_cont = 0;
                int team_b_cont = 0;

                int[] a_pattern = new int[10];
                int[] b_pattern = new int[10];

                for(int k=0; k<10; k++)
                {
                    System.out.println("<turn " + k + ">");

                    int a = f[team_a].hunt(team_b, k, prev_b, last_pattern[team_b]);
                    int b = f[team_b].hunt(team_a, k, prev_a, last_pattern[team_a]);

                    a_pattern[k] = a;
                    b_pattern[k] = b;

                    if (a == prev_a) team_a_cont += a + 1; else team_a_cont = 0;
                    if (b == prev_b) team_b_cont += b + 1; else team_b_cont = 0;

                    if (a != 0 && a != 1 && a != 2) team_a_cont = 100;
                    if (b != 0 && b != 1 && b != 2) team_b_cont = 100;

                    prev_a = a;
                    prev_b = b;

                    int a_score=0;
                    int b_score=0;

                    if (a == DEER && b == DEER) {a_score = 50; b_score = 50;}
                    else if (a == DEER && b == RABBIT) {a_score = 0; b_score = 20;}
                    else if (a == DEER && b == SNAKE) {a_score = 0; b_score = 10;}
                    else if (a == RABBIT && b == DEER) {a_score = 20; b_score = 0;}
                    else if (a == RABBIT && b == RABBIT) {a_score = 20; b_score = 20;}
                    else if (a == RABBIT && b == SNAKE) {a_score = 0; b_score = 30;}
                    else if (a == SNAKE && b == DEER) {a_score = 10; b_score = 0;}
                    else if (a == SNAKE && b == RABBIT) {a_score = 30; b_score = 0;}
                    else if (a == SNAKE && b == SNAKE) {a_score = 10; b_score = 10;}

                    a_score -= team_a_cont;
                    b_score -= team_b_cont;
                    a_score += random.nextInt(3);
                    b_score += random.nextInt(3);

                    a_game_score += a_score;
                    b_game_score += b_score;

                    System.out.println(String.format("[%4s] : %s, [%4s] : %s", names[team_a], (a!=0) ? (a==2 ? "SNAKE" : "RABBIT") : "DEER",
                            names[team_b], (b!=0) ? (b == 2 ? "SNAKE" : "RABBIT") : "DEER"));
                    System.out.println(String.format("[%4s] score:  This turn:%5d, Game score:%5d, Total score:%5d",
                            names[team_a], a_score, a_game_score, total_score[team_a] + a_game_score));
                    System.out.println(String.format("[%4s] score:  This turn:%5d, Game score:%5d, Total score:%5d",
                            names[team_b], b_score, b_game_score, total_score[team_b] + b_game_score));

                }

                for (int z = 0; z < 10; z++) last_pattern[team_a][pattern_count[team_a]][z] = a_pattern[z];
                for (int z = 0; z < 10; z++) last_pattern[team_b][pattern_count[team_b]][z] = b_pattern[z];
                pattern_count[team_a] ++;
                pattern_count[team_b] ++;
                System.out.println("<game result>");
                if (a_game_score == b_game_score) System.out.println("Draw\n");
                else System.out.println(String.format("Win: [%4s]!\n", a_game_score > b_game_score ? names[team_a] : names[team_b]));
                total_score[team_a] += a_game_score;
                total_score[team_b] += b_game_score;

            }
        }

        System.out.println("<Final score>");
        int max_inx = 0;
        int max_score = 0;
        for (int i = 0; i<f_inx; i++)
        {
            System.out.println(String.format("[%4s] Total Score: %d", names[i], total_score[i]));
            if (max_score < total_score[i]) {
                max_inx = i;
                max_score = total_score[i];
            }
        }

        System.out.printf(String.format("<Winner: [%4s]!!!!>", names[max_inx]));
    }
}
