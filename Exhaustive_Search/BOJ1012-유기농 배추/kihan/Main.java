import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int n=0,k=0;
	static int max = Integer.MIN_VALUE;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		n = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("n");
		list.add("t");
		list.add("i");
		list.add("c");
		List<String> strArr = new ArrayList<>();
		boolean[] visited = new boolean[26];
		visited['a'-'a']=true;
		visited['n'-'a']=true;
		visited['t'-'a']=true;
		visited['i'-'a']=true;
		visited['c'-'a']=true;
		
		if(k<5) {
			System.out.println(0);
		}else if(k == 26) {
            System.out.println(n);
        }else {
			for(int i=0;i<n;i++) {
				String str = sc.nextLine();
				for(int j=0;j<list.size();j++) {
					str = str.replaceAll(list.get(j), "");
				}
				strArr.add(str);
			}
			dfs(strArr,visited,0,0);
			System.out.println(max);
			
		}
		
	}

	private static void dfs(List<String> strArr, boolean[] visited, int alpha, int len) {
		if(len == k - 5) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                boolean read = true;
                for(int j = 0; j < strArr.get(i).length(); j++) {
                    if(!visited[strArr.get(i).charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count);
            return;
        }
        
        for(int i = alpha; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(strArr,visited,i, len + 1);
                visited[i] = false;
            }
        }
	}

}