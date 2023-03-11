package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g2_21609 {
	private static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	private static int arr[][];
	static class BlockGroup implements Comparable<BlockGroup>{
		int minI;
		int minJ;
		int size;
		int zeroSize;
		ArrayList<int[]> arr;

		BlockGroup(int i, int j) {
			arr = new ArrayList<>();

			int firstBlock[] = new int[2];
			firstBlock[0] = i;
			firstBlock[1] = j;

			arr.add(firstBlock);
		}

		@Override
		public int compareTo(BlockGroup o) {
			if (this.size == o.size) {
				if (this.zeroSize == o.zeroSize) {
					if (this.minI == o.minI) {
						return o.minJ - this.minJ;
					}

					return o.minI - this.minI;
				}

				return o.zeroSize - this.zeroSize;
			}
			return o.size - this.size;
		}
	}
	public static void main(String[] args) throws IOException {
		//1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		//격자 한 변의 크기 N, 색상의 개수 M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int score = 0;

		//블럭이 가지고 있는 정보 => 색.
		// 무지개 블록 0, 검은색 블록 -1, 일반블록 => 자연수
		while (true) {
			//2. 블럭 그룹 찾아내기.
			ArrayList<BlockGroup> blockGroups = new ArrayList<>();
			boolean[][] visited = new boolean[N][N];

			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (!visited[i][j] && arr[i][j] > 0) {
						BlockGroup curBlockGroup = makeBlockGroup(i,j,N);

						if (curBlockGroup.size >= 2) {
							for(int k=0; k<curBlockGroup.arr.size(); k++) {
								visited[curBlockGroup.arr.get(k)[0]][curBlockGroup.arr.get(k)[1]] = true;
							}

							blockGroups.add(curBlockGroup);
						}
					}
				}
			}

			if (blockGroups.size() == 0) break;
			//1. 크기가 가장 큰 블록
			Collections.sort(blockGroups);
			//2. 1에서 찾은 그룹의 블록 제거
			score += removeBlockGroup(blockGroups);
			//3. 중력 작용

			gravity(N);
			//4. 90도 반시계방향으로 회전
			arr = rotate(N);
			//5. 격자에 중력 작용
			gravity(N);
		}
		System.out.println(score);
	}

	private static int[][] rotate(int N) {
		int[][] newArr = new int[N][N];
		int c = N -1;

		for (int i = 0; i< N; i++) {
			for (int j = 0; j< N; j++) {
				int pointX = c - j;
				int pointY = i;
				newArr[pointX][pointY] = arr[i][j];
			}
		}
		return newArr;
	}

	private static void gravity(int N) {
		for (int i = N -1; i>=0; i--) {
			for (int j = 0; j< N; j++) {
				if (arr[i][j] == -2) {
					int k = i;

					while(true) {
						k--;

						if (k<0 || arr[k][j] == -1) break;
						if (arr[k][j] == -2) {
							// checked[k][j] = true;
							continue;
						}

						arr[i][j] = arr[k][j];
						arr[k][j] = -2;
						break;
					}
				}
			}
		}
	}

	private static int removeBlockGroup(ArrayList<BlockGroup> blockGroups) {
		BlockGroup removeBlockGroup = blockGroups.get(0);

		//제거된 블록 -2로 표시
		removeBlockGroup.arr.forEach(removeBlock -> {
			int pointX = removeBlock[0];
			int pointY = removeBlock[1];

			arr[pointX][pointY] = -2;
		});

		int size = removeBlockGroup.size;
		return size * size;
	}

	private static BlockGroup makeBlockGroup(int i, int j,int N) {
		BlockGroup blockGroup = new BlockGroup(i,j);
		blockGroup.minI = i;
		blockGroup.minJ = j;

		int curBlock = arr[i][j];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});

		boolean visited[][] = new boolean[N][N];
		visited[i][j] = true;

		blockGroup.size++;

		while(!q.isEmpty()) {
			int cur[] = q.poll();

			for (int d=0; d<4; d++) {
				int ni = cur[0] + dir[d][0];
				int nj = cur[1] + dir[d][1];

				if (ni <0 || nj<0 || ni >=N || nj>=N || visited[ni][nj] || arr[ni][nj]== -1 || arr[ni][nj] == -2 || (arr[ni][nj] != 0 && arr[ni][nj] != curBlock)) continue;
				if (arr[ni][nj]==0) blockGroup.zeroSize++;

				int[] newBlock = new int[] {ni, nj};
				q.add(newBlock);
				blockGroup.size++;
				blockGroup.arr.add(newBlock);
				visited[ni][nj] = true;
			}
		}

		return blockGroup;

	}
}
