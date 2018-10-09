package com.pxy;
/*
 * @author pxy
 * @calss 游戏运行类
 */
public class GameMain {
	private Warship warShip;
	private Player player;
	public GameMain()
	{
		warShip=new Warship("大和号");
		player=new Player();
	}
	public void stratGame()
	{
		boolean status;//判断游戏的结束
		//status=player.hit(warShip);
		do
		{
			status=player.hit(warShip);
		}while(status);
		System.out.println("游戏结束，你的分数为："+player.achievement+"分");
	}
}
