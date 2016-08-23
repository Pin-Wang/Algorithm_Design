package 矩阵问题;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *2016年8月23日	上午11:00:38
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 迷宫问题 {

	// 存储路径
	private static List<String> paths = new ArrayList<String>();
	static String[] result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int row = 0, col = 0;
			row = scanner.nextInt();
			col = scanner.nextInt();
			// 二维矩阵迷宫
			int[][] marz = new int[row][col];
			boolean[][] visited = new boolean[row][col];
			// 初始化访问矩阵和处理输入
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					marz[i][j] = scanner.nextInt();
					visited[i][j] = false;
				}
			}
			String path = "(0,0)";
			visited[0][0] = true;
			findPath(marz, 0, 0, visited, path);

			int minP = 10000;
			for (String p : paths) {
				// System.out.println(p);
				String[] arr = p.split("->");
				if (arr.length < minP) {
					minP = arr.length;
					result = arr;
				}
			}
			if (result != null) {
				for (String pot : result) {
					System.out.println(pot);
				}
			} else {
				System.out.println(-1);
			}
			//清空paths
			paths.clear();
		}
		// 寻找路径

	}

	/**
	 * @param marze
	 *            用到的二维矩阵
	 * @param r
	 *            到达的点的横坐标
	 * @param c
	 *            到达点的竖坐标
	 * @param visited
	 *            已经访问过的点的位置为true（防止重复走）
	 * @param path
	 *            已经走过的路径
	 */
	public static void findPath(int[][] marze, int r, int c, boolean[][] visited, String path) {
		// 一直向四个方向走，知道到达终点
		// 计算矩阵的行数和列数
		int rows = marze.length;
		int cols = marze[0].length;
		// 如果到达了重点
		if (r == rows - 1 && c == cols - 1) {
			paths.add(path);
			return;
		}

		// 如果可以向右走(这个点在矩阵中并且未曾访问过)
		if (c + 1 <= cols - 1 && !visited[r][c + 1] && marze[r][c + 1] == 0) {
			// 加上下一点的路径
			findPath(marze, r, c + 1, copyAndSet(visited, r, c + 1), path + "->(" + r + "," + (c + 1) + ")");
		}
		// 如果可以向下走(这个点在矩阵中并且未曾访问过)
		if (r + 1 <= rows - 1 && !visited[r + 1][c] && marze[r + 1][c] == 0) {
			// 加上下一点的路径
			findPath(marze, r + 1, c, copyAndSet(visited, r + 1, c), path + "->(" + (r + 1) + "," + c + ")");
		}
		// 如果可以向左走(这个点在矩阵中并且未曾访问过)
		if (c - 1 >= 0 && !visited[r][c - 1] && marze[r][c - 1] == 0) {
			// 加上下一点的路径
			findPath(marze, r, c - 1, copyAndSet(visited, r, c - 1), path + "->(" + r + "," + (c - 1) + ")");
		}

		// 如果可以向上走(这个点在矩阵中并且未曾访问过)
		if (r - 1 >= 0 && !visited[r - 1][c] && marze[r - 1][c] == 0) {
			// 加上下一点的路径
			findPath(marze, r - 1, c, copyAndSet(visited, r - 1, c), path + "->(" + (r - 1) + "," + c + ")");
		}

	}

	// 复制并且设置访问矩阵
	public static boolean[][] copyAndSet(boolean[][] visited, int r, int c) {
		boolean[][] result = new boolean[visited.length][visited[0].length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				result[i][j] = visited[i][j];
			}
		}
		// 将指定点设置为已经访问过
		result[r][c] = true;
		return result;
	}

}
