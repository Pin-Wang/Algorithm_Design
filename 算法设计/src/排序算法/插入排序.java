package 排序算法;

import java.util.Scanner;

/*
 *2016年8月13日	上午11:18:35
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 插入排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=0;
		num=scanner.nextInt();
		int[] arr=new int[num];
		for(int i=0;i<num;i++){
			arr[i]=scanner.nextInt();
		}
		insertSort(arr, num);
		//fastSort(arr, 0, num-1);
		for(int i=0;i<num;i++){
			System.out.print(arr[i]+" ");
		}

	}
	
	//直接插入排序（稳定的排序算法），最好情况下时间复杂度可以达到是O（n），最坏和平均情况下是O（n*n）
	public static void insertSort(int[] arr,int n){
		for(int i=1;i<n;i++){
			//将当前元素逐个与前面的序列比较
			//暂存当前元素
			int current=arr[i];
			int j=i-1;
			for(;j>=0;j--){
				//比当前元素大的往后移
				if(arr[j]>current){
					arr[j+1]=arr[j];
				}
				else{
					break;
				}
			}
			//将当前元素放到最终的位子
			arr[j+1]=current;
		}
	} 
	
	//希尔排序（加强版的不稳定的插入排序），最好，平均，最坏情况下时间复杂度是O(n),O(n^1.5),O(n*n)
	public void inse
}
