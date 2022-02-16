import java.util.*;



public class Main {
	static boolean [][] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T=0,N=0,M=0,K=0,X=0,Y=0;
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			N=sc.nextInt();
			M=sc.nextInt();
			K=sc.nextInt();
			int count = 0;
			a = new boolean [N][M];
			for(int j=0;j<K;j++) {
				X=sc.nextInt();
				Y=sc.nextInt();
				a[X][Y]=true;
			}
			for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[i][j]) {
                        DFS(i, j, N, M);
                        count++;
                    }
                }
			}
			System.out.println(count);
		}
		
		
		
	}
	 public static void DFS(int X, int Y, int N, int M) {
		 int[] dx = { -1, 0, 1, 0 };
		 int[] dy = { 0, 1, 0, -1 };
	     for (int i = 0; i < 4; i++) {
	    	int nextX = X + dx[i];
	      	int nextY = Y + dy[i];
	     	if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
	         	continue;
	      	}
	       	if (!a[nextX][nextY]) {
	       	continue;
	       	}
	      	a[nextX][nextY] = false;
	    	DFS(nextX, nextY, N, M);
	    }
	 }
}
