package 查找算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 *2016年8月10日	下午8:18:40
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 二分查找 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int[] arr={0,1,3,4,5,9};
		
		System.out.println(binarySearch(arr, 6, 9));
	}
	
	public static int binarySearch(int[] arr,int len,int ele){
		int location=0;
		int low=0,high=len-1;
		while(low<=high){
			int between=(low+high)/2;
			if(arr[between]==ele){
				 location=between;
				 break;
			}
			else if(arr[between]<ele){
				low=between+1;
			}
			else{
				high=between-1;
			}
		}
		return location;
	}

}
