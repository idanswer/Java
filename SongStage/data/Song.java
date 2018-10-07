package songstage;
/*
 * @author pxy
 * @class 歌曲类 包含歌曲的信息和构造函数
 */
public class Song {
	public String songname ;
	public String singer;
	public double time;
	public Song(String songname,String singer,double time) {
		this.songname=songname;
		this.singer=singer;
		this.time=time;
	}
}
