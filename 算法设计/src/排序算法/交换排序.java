package 排序算法;

import java.util.Scanner;

/*
 *2016年8月12日	下午7:20:45
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 交换排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=0;
		num=scanner.nextInt();
		int[] arr=new int[num];
		for(int i=0;i<num;i++){
			arr[i]=scanner.nextInt();
		}
		//bubbleSort(arr, num);
		fastSort(arr, 0, num-1);
		for(int i=0;i<num;i++){
			System.out.print(arr[i]+" ");
		}

	}
	/*
	 * 冒泡排序是稳定的交换排序，时间复杂度最好情况下是O(n)。最坏和平均情况下是O（n*n）
	 */
	//bubbleSort
	public static void bubbleSort(int[] arr,int n){
		for (int i = 0; i < n-1; i++) {
			//标志位
			boolean tag=true;
			for (int j = 0; j <=n-i-2; j++) {
				if(arr[j]>arr[j+1]){
					//比后面元素大，交换
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					//将标志位置为false
					tag=false;
				}
			}
			//检查标志位是否为true，若是true，则表是已经是有序序列，不再循环
			if(tag){
				return;
			}
		}
		
	}
	
	/*
	 * 快速排序（不稳定的加强版的交换排序），时间复杂度平均情况和最好情况是O（nlogn），最坏情况下是O（n*n）
	 */
	/**
	 * @param arr
	 * @param n数组长度
	 * @param s开始位置
	 * @param e结束位置
	 */
	public static void fastSort(int[] arr,int s,int e){
		if(s<e){
			int low=s,high=e;
			//第一个元素为当前元素，一次循环完成，当前元素插入到自己最终得到位置
			int tmp=arr[s];
			while(low<high){
				//寻找右边比当前元素小的元素（一定要从右边开始）
				while(arr[high]>=tmp&&high>low){
					high--;
				}
				//寻找左边比当前元素大的元素
				while(arr[low]<=tmp&&low<high){
					low++;
				}
				//交换2元素
				int t=arr[high];
				arr[high]=arr[low];
				arr[low]=t;
			}
			//将当前元素和寻找到最后位置的元素交换
			arr[s]=arr[low];
			arr[low]=tmp;
			//递归排序剩下的左边子序列和右边的子序列
			fastSort(arr,s, low-1);
			fastSort(arr, high+1, e);
		}
	}
}
