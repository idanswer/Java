package songstage;
/*
 * @author pxy
 * @class ����� ����������
 */
import java.util.Scanner;

public class Player {
	/*
	 * @���û�����ĸ���ʵ�����ɸ������󲢷���赥��
	 */
	public boolean addSong() {
		System.out.println("��������������ƣ����ֺ�ʱ����");
		Scanner input=new Scanner(System.in);
		Song song1=new Song(input.nextLine(),input.nextLine(),input.nextDouble());
		Master.listsong.add(song1);
		return true;
	}
}
