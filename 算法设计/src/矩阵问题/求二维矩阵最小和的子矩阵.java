package 矩阵问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** * @author  作者 :Pin-Wang
 * @E-mail:1228935432@qq.com
 * @date 创建时间：2016年8月4日 下午6:05:03 
 * @version 1.0 
 * @parameter  
 * @since 
 * @return  
 */

public class 求二维矩阵最小和的子矩阵 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		
		List<ArrayList<Integer>> matrix=new ArrayList<ArrayList<Integer>>();
		while(scanner.hasNextLine()){
			String[] array=scanner.nextLine().split(" ");
			ArrayList<Integer> line=new ArrayList<Integer>();
			int count=0;
			for (int i = 0; i < array.length; i++) {
				line.add( Integer.valueOf(array[i]));
			}
			matrix.add(line);
		}
		System.out.println(getSubMatrix(matrix, matrix.get(0).size(), matrix.size()));
	}
	
	/**
	 * @param matrix二维矩阵
	 * @param m行数
	 * @param n列数
	 * @return
	 */
	public static Integer getSubMatrix(List<ArrayList<Integer>> matrix,int m,int n){
		Integer result=-10000;
		//遍历以i行开始的所有行的列数和
		for (int i = 0; i <m; i++) {
			//辅助数组
			List<Integer> arr=new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				arr.add(0);
			}
			for (int j = i; j < m; j++) {
				//每一行的列数相加
				for (int j2 = 0; j2 < n; j2++) {
					arr.set(j2, arr.get(j2)+matrix.get(j).get(j2));
				}
				//得到每一次相加后最大和的子序列
				if(max(arr).get(2)>result){
					result=max(arr).get(2);
				}
			}
			
		}
		return result;
	}
	
	//求一维矩阵最大和的子序列
	public static List<Integer> max(List<Integer> list){ 
		List<Integer> result=new ArrayList<Integer>();
		Integer sum=0;
		//最大值
		Integer max=0;
		//最后求得的序列索引
		int s=0,e=0;
		result.add(0);
		result.add(0);
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
			if(sum>max){
				max=sum;
				e=i;
				result.set(0, s);
				result.set(1, e);
			}
			else if(sum<0){
				sum=0;
				s=i+1;
			}
			
		}
		result.add(max);
		return result;
	}

}
