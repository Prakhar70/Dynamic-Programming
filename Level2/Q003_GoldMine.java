package Level2;
import java.util.LinkedList;
import java.util.Queue;

public class Q003_GoldMine {
	public static class Pair {
		int row;
		int col;
		String psf;

		Pair(int row, int col, String psf) {
			this.row = row;
			this.col = col;
			this.psf = psf;
		}
		@Override
		public String toString() {
			return this.row+" "+this.col;
		}
	}

	public static void printAllMaxGoldPath(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
		for (int j = m - 1; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				if (j == m - 1) {
					dp[i][j] = matrix[i][j];
				} else {
					int max = Integer.MIN_VALUE;
					for (int[] d : dir) {
						int r = i + d[0];
						int c = j + d[1];
						if (r >= 0 && r < n && c < m) {
							max = Math.max(dp[r][c], max);
						}
					}
					dp[i][j] = matrix[i][j] + max;
				}
			}
		}
		System.out.println(n);
		System.out.println(m);
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		Queue<Pair> que = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			max=Math.max(max,dp[i][0]);
		}
		for(int i =0; i<n; i++) {
			if(dp[i][0]==max) {
				que.add(new Pair(i, 0, "("+i+",0)->"));
			}
		}

		while (!que.isEmpty()) {

			Pair rNode = que.remove();
			int i = rNode.row;
			int j = rNode.col;
			String psf = rNode.psf;
			if (j == m - 1) {
				System.out.println(rNode.psf);
			} else {
				int maxi = Integer.MIN_VALUE;
				for (int[] d : dir) {
					int r = i + d[0];
					int c = j + d[1];
					if (r >= 0 && r < n && c < m) {
						maxi = Math.max(maxi, dp[r][c]);
					}
				}
				for (int[] d : dir) {
					int r = i + d[0];
					int c = j + d[1];
					if (r >= 0 && r < n && c < m) {
						if(dp[r][c]==maxi) {
							que.add(new Pair(r, c, psf+"("+r+","+c+")"+"->"));
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = { { 3, 2, 3, 1 }, { 2, 4, 6, 0 }, { 5, 0, 1, 3 }, { 9, 1, 5, 1 } };
		printAllMaxGoldPath(matrix);
	}
}