package songstage;
/*
 * @author pxy
 * @class ����̨ �������മ������
 */
public class SongDrive {
	public Master master;
	public Player player;
	public SongDrive() {
		master=new Master();
		player=new Player();
	}
	public static void main(String[] args) {
		SongDrive GeLaiMei=new SongDrive();
		GeLaiMei.player.addSong();
		GeLaiMei.master.play();
		//String name1=input.nextLine();
		//string singer1=
		
		//GeLaiMei.player.addSong(GeLaiMei.master.listsong, song1);
		//GeLaiMei.master.play(listsong[0]);
	}

}
