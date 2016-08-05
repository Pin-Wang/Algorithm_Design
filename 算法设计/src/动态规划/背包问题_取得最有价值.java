package 动态规划;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 *2016年8月5日	上午11:53:05
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 背包问题_取得最有价值 {
	
	//物品重量的list
	private static List<Integer> w=new ArrayList<Integer>();
	//物品价值的list
	private static List<Integer> v=new ArrayList<Integer>();
	//背包恩能提供装下的总重量
	private static Integer weight;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		int count=0;
		while(scanner.hasNextLine()){
			count++;
			//读取重量
			if(count==1){
				String[] arr=scanner.nextLine().split(" ");
				for (int i = 0; i < arr.length; i++) {
					w.add(Integer.valueOf(arr[i]));
				}
			}
			//读取价值
			else if(count==2){
				String[] arr=scanner.nextLine().split(" ");
				for (int i = 0; i < arr.length; i++) {
					v.add(Integer.valueOf(arr[i]));
				}
			}
			//输入背包总重量
			else{
				String[] arr=scanner.nextLine().split(" ");
				for (int i = 0; i < arr.length; i++) {
					weight=Integer.valueOf(arr[i]);
				}
				
				//计算
				System.out.println(getM(w.size()-1, weight));
				
				//清除原始数据
				w.clear();
				v.clear();
				weight=0;
				count=0;
			}
			
		}
	}
	
	//将前i个物品放进重量为j的背包中的最大价值
	/**
	 * @param i	前i个 物品
	 * @param j 能装下j重量的背包
	 * @return
	 */
	public static Integer getM(int i,Integer j){
		//第一个物品，并且能够装到背包中
		if(i==0&&w.get(0)<=j){
			return v.get(0);
		}
		//第一个物品，但是不能够装到背包中
		else if(i==0||j<=0){
			return 0;
		}
		//不是第一个物品动态方程为以下
		else{
			return Math.max(getM(i-1, j-w.get(i))+v.get(i), getM(i-1, j));
		}
	}

}
