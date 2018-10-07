package songstage;
/*
 * @class 主持人类 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Master {
	public static List<Song> listsong;//全局变量  歌单
	public Master() {
		listsong=new ArrayList<>();//构造函数用于初始化歌单
	}
	/*
	 * @return 当播放歌曲时 返回true
	 */
	public boolean play() {
		Iterator<Song> iterator=listsong.iterator();//迭代器
		if(iterator.hasNext()) {
			Song song=listsong.get(0);
			System.out.println("正在播放的歌曲是："+song.songname+" "+"作曲者："+song.singer+" "+"时长："+song.time);
			return true;
		}
		else 
			return false;
	}
}
