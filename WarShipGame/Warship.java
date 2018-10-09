package com.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @author pxy 
 * @class 战舰类 
 */
public class Warship {
	public String shipName;//战舰名字
	private List<String> position;//战舰位置
	private List<String> hitPosition;//击中位置
	private boolean shipStatus;//当前状态 true为还在 false为被击沉了
	private int hitCount=0;//击中次数
	public Warship(String shipName) {
		this.shipName=shipName;
		shipStatus=true;
		position=new ArrayList<String>(3);
		hitPosition=new ArrayList<String>();
		createPosition();
	}
	/*
	 * @param 玩家输入的炮击位置
	 * 判断是否击中
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
	 * 随机生成战舰位置
	 */
	public void createPosition() {
		String[] xAxis=new String[] {"1","2","3","4","5","6","7"};
		String[] yAxis=new String[] {"A","B","C","D","E","F","G"};
		Random random=new Random();
		boolean flag=random.nextBoolean();//设 true为横着 false为竖着
		String shipHead,shipBody,shipTail;//船头，船身，船尾
		int xBodyNumber,yBodyNumber;
		// 默认船头方向沿着x，y轴正方向
		if(flag)//船横着 
		{
			yBodyNumber=random.nextInt(7);//y的范围[0,6]
			xBodyNumber=random.nextInt(5)+1;//x的范围[1,5];
			shipBody=yAxis[yBodyNumber]+xAxis[xBodyNumber];
			shipHead=yAxis[yBodyNumber]+xAxis[xBodyNumber+1];
			shipTail=yAxis[yBodyNumber]+xAxis[xBodyNumber-1];
		}
		else//船竖着
		{
			yBodyNumber=random.nextInt(5)+1;//x的范围[1,5]
			xBodyNumber=random.nextInt(7);//x范围[0,6]
			shipBody=yAxis[yBodyNumber]+xAxis[xBodyNumber];
			shipHead=yAxis[yBodyNumber+1]+xAxis[xBodyNumber];
			shipTail=yAxis[yBodyNumber-1]+xAxis[xBodyNumber];
		}
		position.add(shipHead);
		position.add(shipBody);
		position.add(shipTail);
	}
	//@return 得到私有的shipStatus
	public boolean getShipStatus()
	{
		return shipStatus;
	}
}



















