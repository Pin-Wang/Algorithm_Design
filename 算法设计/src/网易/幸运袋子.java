package 网易;
/*
 *2016年8月9日	下午4:27:05
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class 幸运袋子 {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	HashSet<ArrayList<Integer>> set= new HashSet<ArrayList<Integer>>();   //存放所用的子集合
	ArrayList<Integer> arrayList= new ArrayList<Integer>();   //存放临时的子集合
	while(sc.hasNext()){
		
		int n= sc.nextInt();   //数组的长度
		int[] arr= new int[n];  //数组
		int add=0;
		int muti=1;
		//获取数组的元素
		for(int i=0;i<n;i++){
			arr[i]= sc.nextInt();  
			add+=arr[i];
			muti*=arr[i];
		}
		
		//对数组进行排序
		//Arrays.sort(arr);
		
		//得到满足条件的所以子数组
		int[] result= new int[2];
		for(int i=2;i<n;i++){
			int start=0;
			int end=n-1;
			
			result[0]=0;
			result[1]=1;
			getLuckNumber(arr,start,end,i,arrayList,set,result);
		}
		
		/*for(ArrayList<Integer> a: set){
			System.out.println(a);
		}*/
		if(add>muti){
			System.out.println(set.size()+1);
		}
		
		else {
			System.out.println(set.size());
		}
		
		
	}
	
	
}

private static void getLuckNumber(int[] arr, int start, int end, int len, ArrayList<Integer> arrayList,
		HashSet<ArrayList<Integer>> set,int[] result) {
	
		if (len == 0) {

			if (result[0] > result[1]) {
				ArrayList<Integer> tem = new ArrayList<Integer>();
				tem.addAll(arrayList);
				set.add(tem);
			}
			return;
		}
		if (start <= end) {
			arrayList.add(arr[start]); // 选择第一个元素
			result[0] += arr[start];
			result[1] *= arr[start];
			getLuckNumber(arr, start + 1, end, len - 1, arrayList, set, result);
			arrayList.remove(arrayList.size() - 1);
			result[0] -= arr[start];
			result[1] = result[1] / arr[start];
			getLuckNumber(arr, start + 1, end, len, arrayList, set, result);
		}

}


}
