import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = sc.nextInt();
		boolean[] visited = new boolean[20*100000+1];
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(arr,0,0,visited,N);
		for(int i=1;i<visited.length;i++) {
			if(!visited[i]) {
				System.out.println(i);
				break;
			}
		}
		
	}
	
	static void dfs(int[] arr,int idx,int sum,boolean[] visited,int N){
        if(idx == N){
            visited[sum] = true;
        }
        else{
            dfs(arr,idx+1,sum+arr[idx],visited,N);
            dfs(arr,idx+1,sum,visited,N);
        }
    }
	
}