package com.pxy;
/*
 * @author pxy
 * @calss ��Ϸ������
 */
public class GameMain {
	private Warship warShip;
	private Player player;
	public GameMain()
	{
		warShip=new Warship("��ͺ�");
		player=new Player();
	}
	public void stratGame()
	{
		boolean status;//�ж���Ϸ�Ľ���
		//status=player.hit(warShip);
		do
		{
			status=player.hit(warShip);
		}while(status);
		System.out.println("��Ϸ��������ķ���Ϊ��"+player.achievement+"��");
	}
}
