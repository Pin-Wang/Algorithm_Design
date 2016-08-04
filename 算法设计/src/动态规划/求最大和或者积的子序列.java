package 动态规划;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/** * @author  作者 :Pin-Wang
 * @E-mail:1228935432@qq.com
 * @date 创建时间：2016年8月4日 下午3:17:40 
 * @version 1.0 
 * @parameter  
 * @since 
 * @return  
 */

public class 求最大和或者积的子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		Scanner scanner=new Scanner(System.in);
		//处理输入
		while(scanner.hasNext()){
			list.add(scanner.nextInt());
		}
		GetSubSeq g=new GetSubSeq(list);
		g.getMaxAnd(list, list.size()-1);
		
		System.out.println("最大子和的子序列为  "+g.getAndResult());
		
		g.getMaxProduct(list, list.size()-1);
		System.out.println("最大乘积子序列为  "+g.getMaxProducResult());
		
		g.getMinProduct(list, list.size()-1);
		System.out.println("最小乘积子序列为  "+g.getMinProducResult());

	}
}

/*求最大和的子序列
 *将M[i]表示为以 arr[i]结尾的序列的和。
 *那么动态方程为	M[i]=max{M[i-1]*arr[i],arr[i]}
 *求最小和的子序列同理
 *
 *如果是求最大乘积子序列，序列有（正数，负数，0）
 *则动态方程为         M[i]=max{M[i-1]*arr[i],arr[i],m[i-1]*arr[i]}
 *m[i]为以arr[i]未结束的最小乘积的序列
 */

class GetSubSeq{
	private List<Integer> list=new ArrayList<Integer>();
	//存储最终和的最大值
	private Integer AndResult=-10000;
	//存储最终乘积的最大值
	private Integer MaxProducResult=-10000;
	//存储最终乘积的最小值
	private Integer MinProducResult=10000;
	public Integer getAndResult() {
		return AndResult;
	}
	public void setAndResult(Integer andResult) {
		AndResult = andResult;
	}
	public Integer getMaxProducResult() {
		return MaxProducResult;
	}
	public void setMaxProducResult(Integer maxProducResult) {
		MaxProducResult = maxProducResult;
	}
	public Integer getMinProducResult() {
		return MinProducResult;
	}
	public void setMinProducResult(Integer minProducResult) {
		MinProducResult = minProducResult;
	}
	//构造器
	public GetSubSeq(List<Integer> list){
		this.list=list;
	}
	//求以索引为index的元素结尾的最大和的子序列
	public Integer getMaxAnd(List<Integer> list,int index){
			//递归边界条件
			if(index==0){
				AndResult=list.get(0)>AndResult?list.get(0):AndResult;
				return list.get(0);
			}
			else{
				Integer tmp=Math.max(getMaxAnd(list, index-1)+list.get(index), list.get(index));
				AndResult=tmp>AndResult?tmp:AndResult;
				return tmp;
			}
	}
		
	
	//求以索引为index的元素结尾的最大积的子序列
	public Integer getMaxProduct(List<Integer> list,int index){
			if(index<list.size()){
				//递归边界条件
				if(index==0){
					MaxProducResult=list.get(0)>MaxProducResult?list.get(0):MaxProducResult;
					return list.get(0);
				}
				else{
					Integer tmp=Math.max(getMinProduct(list, index-1)*list.get(index),getMaxProduct(list, index-1)*list.get(index));
					tmp= list.get(index)>tmp? list.get(index):tmp;
					MaxProducResult=tmp>MaxProducResult?tmp:MaxProducResult;
					return tmp;
				}
			}
			else{
				return null;
			}
			
		}
		
	//求以索引为index的元素结尾的最小积的子序列
	public Integer getMinProduct(List<Integer> list,int index){
				if(index<list.size()){
					//递归边界条件
					if(index==0){
						MinProducResult=list.get(0)<MinProducResult?list.get(0):MinProducResult;
						return list.get(0);
					}
					else{
						Integer tmp=Math.min(getMinProduct(list, index-1)*list.get(index),getMaxProduct(list, index-1)*list.get(index));
						tmp= list.get(index)<tmp? list.get(index):tmp;
						MinProducResult=tmp<MinProducResult?tmp:MinProducResult;
						return tmp;
					}
				}
				else{
					return null;
				}
				
			}
}
