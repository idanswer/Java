package com.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author pxy
 * @class �����
 */
public class Player {
	private List<String> hitHistory;
	public int achievement=0;
	public Player() {
		hitHistory=new ArrayList<String>();
	}
	/*
	 * @param ս�����һ������
	 * @return true ս������ false ս��������
	 */
	public boolean hit(Warship warShip) {
		System.out.println("�������ڻ�λ�ã�A~G��1~7�����磺A2");
		Scanner in=new Scanner(System.in);
		String guessPosi=in.nextLine();
		hitHistory.add(0,guessPosi);
		if(warShip.hitFlag(hitHistory.get(0)))
		{
			if(!warShip.getShipStatus())
				{
					achievement=achievement+10;
					System.out.println("��ϲ�㣬������"+warShip.shipName);
					return false;
				}
			achievement=achievement+5;
			System.out.println("��ϲ�㣬������"+warShip.shipName+"��������Ȼ���Ժ���");
			return true;
		}
		else
			{
				achievement--;
				System.out.println("û����");
				return true;
			}
	}
}
