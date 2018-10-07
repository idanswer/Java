package songstage;
/*
 * @author pxy
 * @class 玩家类 包含点歌操作
 */
import java.util.Scanner;

public class Player {
	/*
	 * @将用户输入的歌曲实例化成歌曲对象并放入歌单内
	 */
	public boolean addSong() {
		System.out.println("请输入歌曲的名称，歌手和时长：");
		Scanner input=new Scanner(System.in);
		Song song1=new Song(input.nextLine(),input.nextLine(),input.nextDouble());
		Master.listsong.add(song1);
		return true;
	}
}
