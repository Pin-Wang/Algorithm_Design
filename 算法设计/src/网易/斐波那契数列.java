package 网易;

import java.util.Scanner;

/*
 *2016年8月6日	下午7:14:59
 *@Author Pin-Wang
 *@E-mail 1228935432@qq.com
*/
public class 斐波那契数列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Integer in;
		in=scanner.nextInt();
		Integer tmp=in;
		int countR=0;
		//向右走
		while(!isF(tmp)){
			tmp++;
			countR++;
		}
		tmp=in;
		//向左走
		int countL=0;
		while(!isF(tmp)){
			tmp--;
			countL++;
		}
		//取最小值
		System.out.println(countL<countR?countL:countR);
		
	}
		
	
	//判断是否是斐波那契数字
	public static boolean isF(Integer n){
		Integer sum=0;
		int k=1;
		while(sum<=n){
			sum=get(k++);
			if(sum==n){
				return true;
			}
		}
		return false;
	}
	
	//求第i个斐波那契数字
	public static Integer get(int i){
		
		if(i==1){
			return 0;
		}
		else if(i==2){
			return 1;
		}
		else{
			return get(i-1)+get(i-2);
		}
	}

}
