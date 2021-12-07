import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws ParseException {

        SongDbOpeartion sdbo = new SongDbOpeartion();
        SongFilter sf = new SongFilter();
        List<Songdata1> masterdata = sdbo.getSongs();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Option You Want to Select");
        System.out.println("1.View All Song List\n2.To Add Song\n3.Filter Songs By Artist Name\n"+
                "4.Filter Songs By Album Name\n5.Filter Songs By Genere Name");

        int choice= sc.nextInt();
        switch (choice) {
            case 1:
                 masterdata = sdbo.getSongs();
                sf.display(masterdata);
                break;

            case 2:
                java.util.Date dt1 = new SimpleDateFormat("yyyy-mm-dd").parse("2019-10-15");
                boolean add = sdbo.addSong("Mehrama", "00:03:20", "Sudha", "F",
                        "NewYwear", dt1, "Classic");
                System.out.println("Addition is " + add);
                break;

            case 3:
                List<Songdata1> filterByartist = sf.getSongsByArtist(masterdata,"arijit singh");
                sf.display(filterByartist);
                break;

            case 4:
                List<Songdata1> filterByAlbum = sf.getSongsByAlbum(masterdata,"perfect");
                sf.display(filterByAlbum);
                break;

            case 5:
                List<Songdata1> filterByGenere = sf.getSongsByGenere(masterdata,"soul");
                sf.display(filterByGenere);
                break;
        }
    }
}
