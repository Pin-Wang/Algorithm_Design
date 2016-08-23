package 排序算法;

import java.util.Scanner;

/*
 *2016年8月22日	下午11:11:29
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 基数排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=0;
		num=scanner.nextInt();
		int[] arr=new int[num];
		for(int i=0;i<num;i++){
			arr[i]=scanner.nextInt();
		}
		//基数排序
		cardinalSort(arr, num);
		for(int i=0;i<num;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
	
	//基数排序
	public static void cardinalSort(int[] a,int len){
		//寻找最大元素
		int max=-1;
		for(int i=0;i<len;i++){
			if(a[i]>max){
				max=a[i];
			}
		}
		int weishu=String.valueOf(max).length();
		//初始化二维数组，10个桶，
		int[][] marz=new int[10][len];
		//初始化第一个元素（第一个元素存储元素个数）
		for(int i=0;i<10;i++){
			marz[i][0]=0;
		}
		//循环各个位数
		for(int i=1;i<=weishu;i++){
			//寻找各个数字相应位数上的数字
			for(int j=0;j<len;j++){
				//得到相应位数上的数字
				int sz=getN(a[j], i);
				//System.out.println(sz);
				//将数字装进对应的桶中
				//获取元素个数(个数需要先加1)
				int sl=++marz[sz][0];
				marz[sz][sl]=a[j];
			}
			
			
			
			//装桶之后,将桶中的数据放进原始数组中
			int l=0;
			for(int k=0;k<10;k++){
				for(int n=1;n<=marz[k][0];n++){
					a[l++]=marz[k][n];
				}
				
			}
			//将第一个元素（第一个元素存储元素个数）置为0
			for(int y=0;y<10;y++){
				marz[y][0]=0;
			}
		}
		
		
	}
	
	//得到数字n第i为上的数字，各位为1
	/**
	 * @param n
	 * @param i
	 * @return
	 */
	public static int getN(int n,int i){
		return n/((int)Math.pow(10, i-1))%10;
	}

}
