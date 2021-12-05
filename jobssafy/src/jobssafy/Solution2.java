package jobssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }

    static int N; // 전기장판 크기
    static char[][] pad; // 전기장판

    static int[][] time; // 따듯해진 시간
    static boolean[][] visited; // 방문 여부

    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        pad = new char[N][N];
        time = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] buffer = in.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                pad[i][j] = buffer[j];
            }
        }

        int answer = bfs();
        System.out.println(answer);
        in.close();
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<Node>();
        // 처음 동그라미
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (pad[i][j] == 'o') {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                int cr = curr.r;
                int cc = curr.c;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = curr.r + dr[dir];
                    int nc = curr.c + dc[dir];
                    if (!outOfRange(nr, nc)) {
                        if (!visited[nr][nc]) { // 방문하지 않았다면
                            if (pad[nr][nc] == '.') {
                                queue.offer(new Node(nr, nc));
                                time[nr][nc] = time[cr][cc] + 1;
                                visited[nr][nc] = true;
                            } else if (pad[nr][nc] == 'x') {
                                queue.offer(new Node(nr, nc));
                                time[nr][nc] = time[cr][cc] + 11;
                                visited[nr][nc] = true;
                            }
                        } else { // 방문 했다면                            
                            if (pad[nr][nc] == '.' && time[nr][nc] > time[cr][cc] + 1) {
                                queue.offer(new Node(nr, nc));
                                time[nr][nc] = time[cr][cc] + 1;
                            } else if (pad[nr][nc] == 'x' && time[nr][nc] > time[cr][cc] + 11) {
                                queue.offer(new Node(nr, nc));
                                time[nr][nc] = time[cr][cc] + 11;
                            }
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, time[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(time[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }

    private static boolean outOfRange(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return true;
        return false;
    }
}
