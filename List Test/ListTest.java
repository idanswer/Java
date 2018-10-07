package com.pxy;
/*
 * @author pxy
 * @���Ը������͵Ĳ��룬ɾ�������������ʱ��
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
public class ListTest {
	/*
	 * count Ϊ������ ���鳤��
	 * firsttimeΪ���в�����ʱ��
	 * lasttimeΪ�����������ʱ��
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
	 * @param list���������� ����֮������
	 * @instanceof boolean����  ��Ϊһ�����ʵ���Ƿ���true
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
	 * @�������count�����ݵ�ʱ��
	 */
	public void timeInsert(List<Integer> list,int count) {
		firsttime=System.currentTimeMillis();
		for(int i=0;i<count;i++) {
			list.add(0,i);
		}
		lasttime=System.currentTimeMillis();
		derttime=lasttime-firsttime;		
		System.out.println(getname(list)+"����"+count+"�����ݵ�ʱ���ǣ�"+derttime/count+"����");
	}
	/*
	 * @�������count�����ݵ�ʱ��
	 */
	public void timeIndex(List<Integer> list,int count) {
		firsttime=System.currentTimeMillis();
		for(int i=0;i<count;i++)
			list.get(i);
		lasttime=System.currentTimeMillis();
		derttime=lasttime-firsttime;
		System.out.println(getname(list)+"����"+count+"�����ݵ�ʱ���ǣ�"+derttime/count+"����");
	}
	/*
	 * @����ɾ��count�����ݵ�ʱ��
	 */
	public void timeDelete(List<Integer> list,int count) {
		firsttime=System.currentTimeMillis();
		for(int i=0;i<count;i++)
			list.remove(0);
		lasttime=System.currentTimeMillis();
		derttime=lasttime-firsttime;
		System.out.println(getname(list)+"ɾ��"+count+"�����ݵ�ʱ���ǣ�"+derttime/count+"����");
	}
}
