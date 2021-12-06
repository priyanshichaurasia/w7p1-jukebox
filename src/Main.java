import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String [] args) throws ParseException {

        SongDbOpeartion sdbo = new SongDbOpeartion();
        int artId = sdbo.generateArtistId("Darshan Raval","M");
        java.util.Date dt = new SimpleDateFormat("yyyy-mm-dd").parse("2020-08-10");
        int albId = sdbo.genersteAlbumId("Love Aaj Kal",dt);
        int gId = sdbo.generateGenereId("Romantic");
        boolean add = sdbo.addSong("Mehrama","00:03:20",artId,albId,gId);
        System.out.println("Addition is " +add);
        int arId = sdbo.getArtistId("palak singh","F");
        System.out.println(arId);
        List<Songdata1> filter = sdbo.getSongsByArtist();
        for(Songdata1 s:filter){
            System.out.println(s);
        }


    }
}
