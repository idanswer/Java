package com.pxy;
/*
 * @author pxy
 * @测试各种类型的插入，删除，查找所需的时间
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
public class ListTest {
	/*
	 * count 为横坐标 数组长度
	 * firsttime为进行操作的时间
	 * lasttime为结束操作后的时间
	 */
	
	private final static int count1=10000;
	private final static int count2=100000;
	private final static int count3=500000;
	private static int count;
	private double firsttime,lasttime,derttime;
	public static void main(String[] args) {
		ArrayList<Integer> list1=new ArrayList<Integer>();
		LinkedList<Integer> list2=new LinkedList<Integer>();
		Stack<Integer> list3=new Stack<Integer>();
		Vector<Integer> list4=new Vector<Integer>();
		count=count3;
		ListTest test=new ListTest();
		
		test.timeInsert(list1, count);
		test.timeIndex(list1, count);
		test.timeDelete(list1, count);
		test.timeInsert(list2, count);
		test.timeIndex(list2, count);
		test.timeDelete(list2, count);
		/*test.timeInsert(list3, count);
		test.timeIndex(list3, count);
		test.timeDelete(list3, count);
		test.timeInsert(list4, count);
		test.timeIndex(list4, count);
		test.timeDelete(list4, count);*/
	}
	/*
	 * @param list容器的种类 方便之后的输出
	 * @instanceof boolean类型  当为一个类的实例是返回true
	 */
	public String getname(List<Integer> list) {
		if(list instanceof ArrayList)
			return "ArrayList";
		else if(list instanceof LinkedList)
			return "LinkList";
		else if(list instanceof Stack)
			return "Stack";
		else if(list instanceof Vector)
			return "Vector";
		else
			return null;
			
	}
	/*
	 * @计算插入count个数据的时间
	 */
	public void timeInsert(List<Integer> list,int count) {
		firsttime=System.currentTimeMillis();
		for(int i=0;i<count;i++) {
			list.add(0,i);
		}
		lasttime=System.currentTimeMillis();
		derttime=lasttime-firsttime;		
		System.out.println(getname(list)+"插入"+count+"个数据的时间是："+derttime/count+"毫秒");
	}
	/*
	 * @计算查找count个数据的时间
	 */
	public void timeIndex(List<Integer> list,int count) {
		firsttime=System.currentTimeMillis();
		for(int i=0;i<count;i++)
			list.get(i);
		lasttime=System.currentTimeMillis();
		derttime=lasttime-firsttime;
		System.out.println(getname(list)+"查找"+count+"个数据的时间是："+derttime/count+"毫秒");
	}
	/*
	 * @计算删除count个数据的时间
	 */
	public void timeDelete(List<Integer> list,int count) {
		firsttime=System.currentTimeMillis();
		for(int i=0;i<count;i++)
			list.remove(0);
		lasttime=System.currentTimeMillis();
		derttime=lasttime-firsttime;
		System.out.println(getname(list)+"删除"+count+"个数据的时间是："+derttime/count+"毫秒");
	}
}
