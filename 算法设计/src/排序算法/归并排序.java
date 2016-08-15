package 排序算法;
/*
 *2016年8月15日	下午6:45:13
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//归并排序是稳定的排序算法，时间复杂度为O（nlog2n），归并排序分为分解和合并2个步骤。
public class 归并排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=0;
		num=scanner.nextInt();
		int[] arr=new int[num];
		for(int i=0;i<num;i++){
			arr[i]=scanner.nextInt();
		}
		//merge(arr, 0,num/2, num-1);
		mergeSort(arr, 0, num-1);
		for(int i=0;i<num;i++){
			System.out.print(arr[i]+" ");
		}

	}
	
	//归并排序
	/**
	 * @param arr 序列
	 * @param s  序列开始位置
	 * @param e  序列结束位置
	 */
	public static void mergeSort(int[] arr,int s,int e){
		//序列最少有2个元素
		if(s+1<=e){
			int mid=(s+e)/2;
			//分解为左序列排序和右序列排序
			mergeSort(arr, s, mid);
			mergeSort(arr, mid+1, e);
			//合并序列
			merge(arr, s, mid, e);
		}
		
	}
	
	//合并子序列
	/**
	 * @param arr 序列
	 * @param low 序列开始位置
	 * @param mid 序列中间位置
	 * @param high 序列结束位置
	 */
	public static void merge(int[] arr,int low,int mid,int high){
		Queue<Integer> queue=new ArrayBlockingQueue<Integer>(high-low+1);
		if(low<high){
			int i=low;
			int j=mid+1;
			while(i<=mid&&j<=high){
				if(arr[i]<arr[j]){
					queue.add(arr[i]);
					i++;
				}
				else{
					queue.add(arr[j]);
					j++;
				}
			}
			//如果左边序列有剩余
			while(i<=mid){
				queue.add(arr[i]);
				i++;
			}
			//如果右边序列有剩余
			while(j<=high){
				queue.add(arr[j]);
				j++;
			}
			//将队列中的元素返回到数组中****
			int k=low;
			while(queue.size()!=0){
				arr[k++]=queue.peek();
				queue.poll();
			}
		}
	}
	
}
