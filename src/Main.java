import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String [] args) throws ParseException {

        SongDbOpeartion sdbo = new SongDbOpeartion();

        int artId = sdbo.generateArtistId("Darshan Raval","M");
        java.util.Date dt = new SimpleDateFormat("yyyy-mm-dd").parse("2020-08-10");
        int albId = sdbo.generateAlbumId("Love Aaj Kal",dt);
        int gId = sdbo.generateGenereId("Romantic");
        boolean add = sdbo.addSong("Mehrama","00:03:20",artId,albId,gId);
        System.out.println("Addition is " +add);

        int arId = sdbo.getArtistId("palak singh","F");
        System.out.println(arId);

        java.util.Date dt1 = new SimpleDateFormat("yyyy-mm-dd").parse("2019-10-15");
        int alId = sdbo.getAlbumId("woow",dt1);
        System.out.println(alId);

        int genId = sdbo.getGenereId("sufi");
        System.out.println(gId);

        List<Songdata1> filter = sdbo.getSongs();

        List<Songdata1> filterByartist = sdbo.getSongsByArtist(filter,"arijit singh");


    }
}
