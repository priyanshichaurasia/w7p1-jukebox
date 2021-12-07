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
                if(filterByartist.size()==0){
                    System.out.println("No Record available with Artist Name "+arName);
                }
                else {
                    sf.display(filterByartist);
                }
                break;

            case 4:
                System.out.println("Enter the Album Name To Search");
                String alName=sc.next();
                List<Songdata1> filterByAlbum = sf.getSongsByAlbum(masterdata,alName);
                if(filterByAlbum.size()==0){
                    System.out.println("No Record available with Album Name "+alName);
                }
                else {
                    sf.display(filterByAlbum);
                }
                break;

            case 5:
                System.out.println("Enter the Genere Name To Search");
                String generName = sc.next();
                List<Songdata1> filterByGenere = sf.getSongsByGenere(masterdata,generName);
                if(filterByGenere.size()==0){
                    System.out.println("No Record available with Genere Name "+generName);
                }
                else {
                    sf.display(filterByGenere);
                }
                break;
            case 6:
                masterdata2 = pcdbo.getProdEpiList();
                pcf.display(masterdata2);
                break;
            case 7:
                System.out.println("Enter the Prodcast Name");
                String podName = sc.next();
                System.out.println("Enter the Narrator Name");
                String narName = sc.next();
                System.out.println("Enter the Prodcast Type Name");
                String prodType = sc.next();
                System.out.println("Enter the Celebrity Name");
                String celbName = sc.next();
                System.out.println("Enter Episode No");
                int episodeNo=sc.nextInt();
                System.out.println("Enter the Name For Episode");
                String epiName=sc.next();
                System.out.println("Enter Time Duration for Episode");
                String time=sc.next();
                System.out.println("Enter the Published Date");
                String publishdDate=sc.next();
                java.util.Date pubshdDt = new SimpleDateFormat("yyyy-MM-dd").parse(publishdDate);
                int prod = pcdbo.addProdcast(podName,prodType,narName,celbName);
                boolean epiadd = pcdbo.addProdEpisode(episodeNo,epiName,time,pubshdDt,podName,prodType,narName,celbName);
                System.out.println("Addition is "+epiadd +" Your Prodcast Id Is "+prod);
                break;
            case 8:
                System.out.println("Enter the Celebrity Name To Search");
                String cName = sc.next();
                List<ProdEpiData> filterByCelb = pcf.getByCelebrity(masterdata2,cName);
                if(filterByCelb.size()==0){
                    System.out.println("No Record available with name "+cName+ " as Celebrity");
                }
                else {
                    pcf.display(filterByCelb);
                }
                break;
            case 9:
                System.out.println("Enter the Published Date For Search");
                String pubDate = sc.next();
                java.util.Date pDate = new SimpleDateFormat("yyyy-MM-dd").parse(pubDate);
                List<ProdEpiData> filterByPubDate = pcf.getByPubDate(masterdata2,pDate);
                if(filterByPubDate.size()==0){
                    System.out.println("No Record Matches with upload date "+pDate);
                }
                else {
                    pcf.display(filterByPubDate);
                }
                break;
        }
    }
}
