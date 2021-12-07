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
        List<ProdEpiData> ped1 = pcdbo.getProdEpiList();
        ProdcastFilter pcf = new ProdcastFilter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Option You Want to Select");
        System.out.println("1.View All Song List\n2.To Add Song\n3.Filter Songs By Artist Name\n"+
                "4.Filter Songs By Album Name\n5.Filter Songs By Genere Name\n6.View Prodcast\n7.Add Prodcast\n" +
                "8.Filter Prodcast By Celebrity Name\n9.Filter Prodcast By Published Date");

        int choice= sc.nextInt();
        switch (choice) {
            case 1:
                 masterdata = sdbo.getSongs();
                sf.display(masterdata);
                break;

            case 2:
                System.out.println("Enter Song Name");
                String songName = sc.next();
                System.out.println("Enter Song Duration");
                String duration = sc.next();
                System.out.println("Enter the Artist Name");
                String artName = sc.next();
                System.out.println("Enter the Gender Of Artist");
                String gender = sc.next();
                System.out.println("Enter the Album name");
                String albName = sc.next();
                System.out.println("Enter the Release Date Of Album");
                String date = sc.next();
                java.util.Date dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                System.out.println("Enter the genere name");
                String genName = sc.next();
                boolean add = sdbo.addSong(songName,duration,artName,gender,albName,dt1,genName);
                System.out.println("Addition is " + add);
                break;

            case 3:
                System.out.println("Enter the Artist Name To Search");
                String arName=sc.next();
                List<Songdata1> filterByartist = sf.getSongsByArtist(masterdata,arName);
                sf.display(filterByartist);
                break;

            case 4:
                System.out.println("Enter the Album Name To Search");
                String alName=sc.next();
                List<Songdata1> filterByAlbum = sf.getSongsByAlbum(masterdata,alName);
                sf.display(filterByAlbum);
                break;

            case 5:
                System.out.println("Enter the Genere Name To Search");
                String generName = sc.next();
                List<Songdata1> filterByGenere = sf.getSongsByGenere(masterdata,generName);
                sf.display(filterByGenere);
                break;
            case 6:
                ped1 = pcdbo.getProdEpiList();
                pcf.display(ped1);
                break;
            case 7:
                System.out.println("Enter the Prodcast Name");
                String podName = sc.next();
                System.out.println("Enter the Prodcast Type Name");
                String prodType = sc.next();
                System.out.println("Enter the Narrator Name");
                String narName = sc.next();
                System.out.println("Enter the Celebrity Name");
                String celbName = sc.next();
                boolean prod = pcdbo.addProdcast(podName,prodType,narName,celbName);
                System.out.println("Addition Of Prodcast Is "+prod);
                break;
            case 8:
                System.out.println("Enter the Celebrity Name To Search");
                String cName = sc.next();
                List<ProdEpiData> filterByCelb = pcf.getByCelebrity(ped1,cName);
                pcf.display(filterByCelb);
                break;
            case 9:
                System.out.println("Enter the Published Date For Search");
                String pubDate = sc.next();
                java.util.Date pDate = new SimpleDateFormat("yyyy-MM-dd").parse(pubDate);
                List<ProdEpiData> filterByPubDate = pcf.getByPubDate(ped1,pDate);
                break;
        }
    }
}
