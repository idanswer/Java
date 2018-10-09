package com.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author pxy
 * @class 玩家类
 */
public class Player {
	private List<String> hitHistory;
	public int achievement=0;
	public Player() {
		hitHistory=new ArrayList<String>();
	}
	/*
	 * @param 战舰类的一个对象
	 * @return true 战舰还在 false 战舰被击沉
	 */
	public boolean hit(Warship warShip) {
		System.out.println("请输入炮击位置（A~G，1~7）例如：A2");
		Scanner in=new Scanner(System.in);
		String guessPosi=in.nextLine();
		hitHistory.add(0,guessPosi);
		if(warShip.hitFlag(hitHistory.get(0)))
		{
			if(!warShip.getShipStatus())
				{
					achievement=achievement+10;
					System.out.println("恭喜你，击沉了"+warShip.shipName);
					return false;
				}
			achievement=achievement+5;
			System.out.println("恭喜你，击中了"+warShip.shipName+"但是它任然可以航行");
			return true;
		}
		else
			{
				achievement--;
				System.out.println("没击中");
				return true;
			}
	}
}
