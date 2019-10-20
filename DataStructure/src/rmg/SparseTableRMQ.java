package rmg;

import java.util.Scanner;

public class SparseTableRMQ {

	
	private static int max = 505;
	private static int table[][][] = new int[max][max][20];
	private static int a[] = new int[max];
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++){
			int n = sc.nextInt();
			int q = sc.nextInt();
			
			for(int i = 1; i <= n; i++){
				for(int j = 1; j <= n; j++){
					a[j] = sc.nextInt();
					
				}
				buildSparseTable(i, n);
			}
			System.out.printf("Case %d:\n", t);
			for(int i = 0; i < q; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				int s = sc.nextInt();
				
				int max = 0;
				
				for(int j = u; j <= u + s - 1; j++){
					max = Math.max(max, query(j, v, v + s - 1));
				}
				System.out.printf("%d\n", max);
			}
			
		}
		
		sc.close();
	}
	
	public static void buildSparseTable(int row, int n){
		for(int i = 1; i <= n; i++){
			table[row][i][0] = a[i];
		}
		
		for(int j = 1; (1<<j)<=n; j++){
			for(int i = 1; (i + (1<<j)-1)<= n; i++){
				table[row][i][j] = Math.max(table[row][i][j - 1], table[row][i +(1<<(j-1))][j-1] );
			}
		}
	}
	
	private static int query(int row, int l, int r){
		int log = (int) (Math.log((r - l) + 1) / Math.log(2));
		return Math.max(table[row][l][log], table[row][r - (1 << log) + 1][log]);
	}

}
