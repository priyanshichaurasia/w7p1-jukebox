import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws ParseException {

        SongDbOpeartion sdbo = new SongDbOpeartion();
        SongFilter sf = new SongFilter();
        List<Songdata1> masterdata = sdbo.getSongs();
        ProdcastDbOperation pcdbo = new ProdcastDbOperation();
        List<ProdEpiData> masterdata2 = pcdbo.getProdEpiList();
        ProdcastFilter pcf = new ProdcastFilter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Option You Want to Select");
        int choice = sc.nextInt();
        sc.nextLine();
        do {
            System.out.println("1.View All Song List\n2.To Add Song\n3.Filter Songs By SongName\n4.Filter Songs By Artist Name\n" +
                    "5.Filter Songs By Album Name\n6.Filter Songs By Genere Name\n7.View Prodcast\n8.Add Prodcast\n" +
                    "9.Filter Prodcast By Celebrity Name\n10.Filter Prodcast By Published Date");

            switch (choice) {
                case 1:
                    masterdata = sdbo.getSongs();
                    sf.display(masterdata);
                    break;

                case 2:
                    System.out.println("Enter Song Name");
                    String songName = sc.nextLine();
                    System.out.println("Enter Song Duration");
                    String duration = sc.nextLine();
                    System.out.println("Enter the Artist Name");
                    String artName = sc.nextLine();
                    System.out.println("Enter the Gender Of Artist");
                    String gender = sc.nextLine();
                    System.out.println("Enter the Album name");
                    String albName = sc.nextLine();
                    System.out.println("Enter the Release Date Of Album");
                    String date = sc.nextLine();
                    java.util.Date dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                    System.out.println("Enter the genere name");
                    String genName = sc.nextLine();
                    boolean add = sdbo.addSong(songName, duration, artName, gender, albName, dt1, genName);
                    System.out.println("Addition is " + add);
                    break;

                case 3:
                    System.out.println("Enter the Song Name To Search");
                    String sName = sc.nextLine();
                    List<Songdata1> filterBysName = sf.getSongsBySongName(masterdata, sName);
                    sf.display(filterBysName);
                    break;

                case 4:
                    System.out.println("Enter the Artist Name To Search");
                    String arName = sc.nextLine();
                    List<Songdata1> filterByartist = sf.getSongsByArtist(masterdata, arName);
                    sf.display(filterByartist);
                    break;

                case 5:
                    System.out.println("Enter the Album Name To Search");
                    String alName = sc.nextLine();
                    List<Songdata1> filterByAlbum = sf.getSongsByAlbum(masterdata, alName);
                    sf.display(filterByAlbum);
                    break;

                case 6:
                    System.out.println("Enter the Genere Name To Search");
                    String generName = sc.nextLine();
                    List<Songdata1> filterByGenere = sf.getSongsByGenere(masterdata, generName);
                    sf.display(filterByGenere);
                    break;
                case 7:
                    masterdata2 = pcdbo.getProdEpiList();
                    pcf.display(masterdata2);
                    break;
                case 8:
                    System.out.println("Enter the Prodcast Name");
                    String podName = sc.nextLine();
                    System.out.println("Enter the Narrator Name");
                    String narName = sc.nextLine();
                    System.out.println("Enter the Prodcast Type Name");
                    String prodType = sc.nextLine();
                    System.out.println("Enter the Celebrity Name");
                    String celbName = sc.nextLine();
                    System.out.println("Enter Episode No");
                    int episodeNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Name For Episode");
                    String epiName = sc.nextLine();
                    System.out.println("Enter Time Duration for Episode");
                    String time = sc.nextLine();
                    System.out.println("Enter the Published Date");
                    String publishdDate = sc.nextLine();
                    java.util.Date pubshdDt = new SimpleDateFormat("yyyy-MM-dd").parse(publishdDate);
                    int prod = pcdbo.addProdcast(podName, prodType, narName, celbName);
                    boolean epiadd = pcdbo.addProdEpisode(episodeNo, epiName, time, pubshdDt, podName, prodType, narName, celbName);
                    System.out.println("Addition is " + epiadd + " Your Prodcast Id Is " + prod);
                    break;
                case 9:
                    System.out.println("Enter the Celebrity Name To Search");
                    String cName = sc.nextLine();
                    List<ProdEpiData> filterByCelb = pcf.getByCelebrity(masterdata2, cName);
                    pcf.display(filterByCelb);
                    break;
                case 10:
                    System.out.println("Enter the Published Date For Search");
                    String pubDate = sc.nextLine();
                    java.util.Date pDate = new SimpleDateFormat("yyyy-MM-dd").parse(pubDate);
                    List<ProdEpiData> filterByPubDate = pcf.getByPubDate(masterdata2, pDate);
                    pcf.display(filterByPubDate);
                    break;
                case 11:
                    System.out.println("Exit from Menu Choice");
                    break;
            }
        }
        while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7
                    || choice == 8 || choice == 9 || choice == 10) ;
    }
}
