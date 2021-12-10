import java.util.Collections;
import java.util.List;

public class Audio {
    public static void main(String [] args){
        PlayListDbOperation pldb = new PlayListDbOperation();
        List<PlaylistContent> list= pldb.getAllPlayListCont();
        String path = "D:\\prjct\\JukeBox\\w7p1-jukebox\\music\\";
        Media m = new Media();
        m.play(list,path);

    }



}
