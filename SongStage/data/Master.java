package songstage;
/*
 * @class �������� 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Master {
	public static List<Song> listsong;//ȫ�ֱ���  �赥
	public Master() {
		listsong=new ArrayList<>();//���캯�����ڳ�ʼ���赥
	}
	/*
	 * @return �����Ÿ���ʱ ����true
	 */
	public boolean play() {
		Iterator<Song> iterator=listsong.iterator();//������
		if(iterator.hasNext()) {
			Song song=listsong.get(0);
			System.out.println("���ڲ��ŵĸ����ǣ�"+song.songname+" "+"�����ߣ�"+song.singer+" "+"ʱ����"+song.time);
			return true;
		}
		else 
			return false;
	}
}
