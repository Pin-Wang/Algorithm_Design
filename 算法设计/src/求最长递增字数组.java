import java.util.Scanner;

import javax.swing.text.html.parser.TagElement;

/*
 *2016年8月11日	下午5:15:11
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 求最长递增字数组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={0,2,3,5,4,6};
		//计算
		int[] tag=new int[6];
		//初始化标记数组
		for(int i=0;i<6;i++){
			tag[i]=0;
		}
		//
		for (int i = 4; i >=0 ; i--) {
			for(int j=5;j>i;j--){
				if(tag[i]<=tag[j]&&arr[i]<arr[j]){
					tag[i]=tag[j]+1;
				}
			}
		}
		
		//输出tag数组
//		for(int i=0;i<6;i++){
//			System.out.println(tag[i]);
//		}
		int max=0;
		int lo=0;
		for(int i=0;i<6;i++){
			if(tag[i]>max){
				max=tag[i];
				lo=i;
			}
		}
		//System.out.println(max);
		for(int i=0;i<6;i++){
			//System.out.println(arr[i]);
			if(tag[i]==max){
				
				System.out.println(arr[i]);
				max--;
			}
		}
		
	}

}
