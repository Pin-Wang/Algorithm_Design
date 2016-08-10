package 网易;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
 *2016年8月6日	下午7:44:55
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 数字游戏 {
	static HashSet<Integer> set=new HashSet<Integer>();
	static List<Integer> list=new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNextInt()){
			//处理输入
			Integer n=scanner.nextInt();
			//存储数字
			list=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				list.add(scanner.nextInt());
			}
			//计算
			get();
     		set.remove(0);
			for(Integer v:set){
				System.out.println(v);
			}
			System.out.println("-----");
			//计算,从1开始
			for (Integer i= 1;; i++) {
				boolean flag=false;
				for(Integer v:set){
					if(v.equals(i)){
						flag=true;
						break;
					}
					else if(v>i){
						break;
					}
				}
				if(!flag){
					System.out.println(i);
					break;
				}
			}
			//清理数据
			set.clear();
			list.clear();
		}

	}
	
	//得出前i个数字可能的和
	public static void get(){
		set.add(0);
		for (int j = 0; j < list.size(); j++) {
			//取出之前得到的每一个结果
			HashSet<Integer> set_tmp=new HashSet<Integer>();
			for(Integer sum:set){
				//之前每一个结果加上当前元素
				sum+=list.get(j);
				set_tmp.add(sum);
			}
			set.addAll(set_tmp);
		}
	}
}
