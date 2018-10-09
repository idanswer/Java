package com.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @author pxy 
 * @class ս���� 
 */
public class Warship {
	public String shipName;//ս������
	private List<String> position;//ս��λ��
	private List<String> hitPosition;//����λ��
	private boolean shipStatus;//��ǰ״̬ trueΪ���� falseΪ��������
	private int hitCount=0;//���д���
	public Warship(String shipName) {
		this.shipName=shipName;
		shipStatus=true;
		position=new ArrayList<String>(3);
		hitPosition=new ArrayList<String>();
		createPosition();
	}
	/*
	 * @param ���������ڻ�λ��
	 * �ж��Ƿ����
	 */
	public boolean hitFlag(String guessPosi) {
		for(String str:position)
		{
			if(guessPosi.equals(str))
			{
				hitCount++;
				hitPosition.add(str);
				if(guessPosi.equals(position.get(1)))
					{
						
						shipStatus=false;
						return true;
					}
				return true;
			}
		}
		return false;
		
	}
	/*
	 * �������ս��λ��
	 */
	public void createPosition() {
		String[] xAxis=new String[] {"1","2","3","4","5","6","7"};
		String[] yAxis=new String[] {"A","B","C","D","E","F","G"};
		Random random=new Random();
		boolean flag=random.nextBoolean();//�� trueΪ���� falseΪ����
		String shipHead,shipBody,shipTail;//��ͷ��������β
		int xBodyNumber,yBodyNumber;
		// Ĭ�ϴ�ͷ��������x��y��������
		if(flag)//������ 
		{
			yBodyNumber=random.nextInt(7);//y�ķ�Χ[0,6]
			xBodyNumber=random.nextInt(5)+1;//x�ķ�Χ[1,5];
			shipBody=yAxis[yBodyNumber]+xAxis[xBodyNumber];
			shipHead=yAxis[yBodyNumber]+xAxis[xBodyNumber+1];
			shipTail=yAxis[yBodyNumber]+xAxis[xBodyNumber-1];
		}
		else//������
		{
			yBodyNumber=random.nextInt(5)+1;//x�ķ�Χ[1,5]
			xBodyNumber=random.nextInt(7);//x��Χ[0,6]
			shipBody=yAxis[yBodyNumber]+xAxis[xBodyNumber];
			shipHead=yAxis[yBodyNumber+1]+xAxis[xBodyNumber];
			shipTail=yAxis[yBodyNumber-1]+xAxis[xBodyNumber];
		}
		position.add(shipHead);
		position.add(shipBody);
		position.add(shipTail);
	}
	//@return �õ�˽�е�shipStatus
	public boolean getShipStatus()
	{
		return shipStatus;
	}
}



















