package 排序算法;

import java.util.Scanner;

/*
 *2016年8月15日	下午3:01:59
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 选择排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=0;
		num=scanner.nextInt();
		int[] arr=new int[num+1];
		for(int i=1;i<=num;i++){
			arr[i]=scanner.nextInt();
		}
		//selectSort(arr,num);
		heapSort(arr, num);
		for(int i=num;i>0;i--){
			System.out.print(arr[i]+" ");
		}
	}
	
	//直接选择排序（不稳定的排序算法），时间复杂度均为O（n*n)
	public static void selectSort(int[] arr,int n){
		for(int i=0;i<n-1;i++){
			//每一趟的最小值
			int min=arr[i];
			//每一趟最小元素的索引
			int index=0;
			int j;
			for(j=i+1;j<n;j++){
				if(arr[j]<min){
					min=arr[j];
					index=j;
				}
			}
			//将最小值放在相应的位置
			arr[index]=arr[i];
			arr[i]=min;
		}
	}
	
	//堆排序（不稳定的选择排序算法），时间复杂度均为O(n*logn)
	public static void heapSort(int[] arr,int n){
		//建立初始堆
		initHeap(arr, n);
		for(int i=n;i>=1;i--){
			//将堆顶元素和最后一个元素交换
			int tmp=arr[1];
			arr[1]=arr[i];
			arr[i]=tmp;
			//交换之后在剩下的元素中建堆
			initHeap(arr, i-1);
		}
	}
	
	//建立初始堆
	/**
	 * @param arr	堆
	 * @param n	堆大小
	 */
	public static void initHeap(int[] arr,int n){
		for(int i=n;i>=1;i--){
			adjust(arr, n, i);
		}
	}
	
	//调整堆
	/**
	 * @param arr	堆
	 * @param size	堆大小
	 * @param index 需要调整的元素的位置
	 */
	public static void adjust(int[] arr,int size,int index){
		//只需要调整非叶子节点,调整需要递归调整
		if(index<=size/2){
			//需找父节点，左子节点，右子节点中的最小值
			int lchild=index*2;
			int rchild=index*2+1;
			int min=1000;
			int index_min=0;
			if(arr[lchild]<min){
				min=arr[lchild];
				index_min=lchild;
			}
			if(rchild<=size&&arr[rchild]<min){
				min=arr[rchild];
				index_min=rchild;
			}
			if(index_min!=index){
				//将最小元素和父元素交换
				arr[index_min]=arr[index];
				arr[index]=min;
				//调整左子节点或者右子节点
				adjust(arr, size, lchild);
				if(rchild<=size){
					adjust(arr, size, rchild);
				}
			}
		}
	}
}
