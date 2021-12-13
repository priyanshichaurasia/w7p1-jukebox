import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class JukeBoxMain {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("Enter the Option You Want to Select");
        System.out.println("1.Songs\n2.Prodcast\n3.Playlist");
        choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            SongDbOpeartion sdbo = new SongDbOpeartion();
            SongFilter sf = new SongFilter();
            List<Songdata1> masterdata = sdbo.getSongs();
            int select = 0;
            do {
                System.out.println("1.View All Song List     2.To Add Song     3.Filter Songs By SongName\n4.Filter Songs By Artist Name" +
                        "     5.Filter Songs By Album Name     6.Filter Songs By Genere Name     7.To Exit");
                select = sc.nextInt();
                sc.nextLine();
                switch (select) {
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
                        int add = sdbo.addSong(songName, duration, artName, gender, albName, dt1, genName);
                        System.out.println("Addition is succesful your song Id is: " + add);
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
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } while (select != 7);
        } else if (choice == 2) {
            ProdcastDbOperation pcdbo = new ProdcastDbOperation();
            List<ProdEpiData> masterdata2 = pcdbo.getProdEpiList();
            ProdcastFilter pcf = new ProdcastFilter();
            int select2 = 0;
            do {
                System.out.println("1.View Prodcast     2.Add Prodcast     3.Filter Prodcast By Celebrity Name     " +
                        "4.Filter Prodcast By Published Date     5.To Exit");
                select2 = sc.nextInt();
                sc.nextLine();
                switch (select2) {
                    case 1:
                        masterdata2 = pcdbo.getProdEpiList();
                        pcf.display(masterdata2);
                        break;
                    case 2:
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
                        int epi_add = pcdbo.addProdEpisode(episodeNo, epiName, time, pubshdDt, podName, prodType, narName, celbName);
                        System.out.println("Addition is done your episode id: " + epi_add + " Your Prodcast Id Is " + prod);
                        break;
                    case 3:
                        System.out.println("Enter the Celebrity Name To Search");
                        String cName = sc.nextLine();
                        List<ProdEpiData> filterByCelb = pcf.getByCelebrity(masterdata2, cName);
                        pcf.display(filterByCelb);
                        break;
                    case 4:
                        System.out.println("Enter the Published Date For Search");
                        String pubDate = sc.nextLine();
                        java.util.Date pDate = new SimpleDateFormat("yyyy-MM-dd").parse(pubDate);
                        List<ProdEpiData> filterByPubDate = pcf.getByPubDate(masterdata2, pDate);
                        pcf.display(filterByPubDate);
                        break;
                    case 5:
                        System.out.println("Exit");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            }
            while (select2 != 5);
        } else {
            PlayListDbOperation pldbo = new PlayListDbOperation();
            List<PlaylistContent> masterdata = pldbo.getAllPlayListCont();
            List<SongType> songfilter = pldbo.getSongPlayListCont();
            PlayListFilter plf = new PlayListFilter();
            int select3 = 0;
            do {
                System.out.println("1.View All PlayList    2.Add in PlayList By Song Id    3.Add in PlayList By Prodcast Episode Id    " +
                        "4.Add By Song Name\n5.Filter By PlayName    6.Filter By Song Name        7.play the playlist    8.To Exit");
                select3 = sc.nextInt();
                sc.nextLine();
                switch (select3) {
                    case 1:
                        masterdata = pldbo.getAllPlayListCont();
                        plf.display(masterdata);
                        break;
                    case 2:
                        SongDbOpeartion sdbo1 = new SongDbOpeartion();
                        List<Songdata1> sdd = sdbo1.getSongs();
                        SongFilter sf1 = new SongFilter();
                        System.out.println("Available Songs");
                        sf1.display(sdd);
                        System.out.println("Enter the PlayList Name");
                        String plName = sc.nextLine();
                        System.out.println("Enter the Time Duration For PlayList");
                        String time = sc.nextLine();
                        System.out.println("Enter the Song Id ");
                        int track = sc.nextInt();
                        sc.nextLine();
                        boolean contId = pldbo.addPlayListByTrackId(plName, time, track);
                        sc.nextLine();
                        System.out.println("PlayList Addition is " + contId);
                        break;
                    case 3:
                        ProdcastDbOperation pdep = new ProdcastDbOperation();
                        List<ProdEpiData> epelist = pdep.getProdEpiList();
                        ProdcastFilter pcf1 = new ProdcastFilter();
                        pcf1.display(epelist);
                        System.out.println("Enter the PlayList Name");
                        String plEpName = sc.nextLine();
                        System.out.println("Enter the Time Duration For PlayList");
                        String epiTime = sc.nextLine();
                        System.out.println("Enter the Track Id ");
                        int trackEpi = sc.nextInt();
                        sc.nextLine();
                        boolean epiId = pldbo.addPlayListByTrackId(plEpName, epiTime, trackEpi);
                        sc.nextLine();
                        System.out.println("PlayList Addition is " + epiId);
                        break;
                    case 4:
                        System.out.println("Enter the PlayList Name");
                        String plName1 = sc.nextLine();
                        System.out.println("Enter the Time Duration For PlayList");
                        String time1 = sc.nextLine();
                        System.out.println("Enter the Song Name");
                        String track1 = sc.nextLine();
                        System.out.println("Enter Song Duration");
                        String sTime = sc.nextLine();
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
                        int contId1 = pldbo.addPlayListBySongName(plName1, time1, track1, sTime, artName, gender, albName, dt1, genName);
                        sc.nextLine();
                        System.out.println("PlayList Is Added Succesfully your id is " + contId1);
                        break;
                    case 5:
                        System.out.println("Enter the PlayList Name To Search");
                        String pName = sc.nextLine();
                        List<PlaylistContent> filterBypName = plf.getByPlayName(masterdata, pName);
                        plf.display(filterBypName);
                        break;
                    case 6:
                        System.out.println("Enter the Song Name To Search");
                        String sName = sc.nextLine();
                        List<SongType> filterBySName = plf.getBySongName(songfilter, sName);
                        plf.displaySong(filterBySName);
                        break;
                    case 7:
                        PlayListDbOperation pldb = new PlayListDbOperation();
                        List<PlaylistContent> list = pldb.getAllPlayListCont();
                        String path = "D:\\prjct\\JukeBox\\w7p1-jukebox\\music\\";
                        Media m = new Media();
                        m.play(list, path, "music");
                        break;
                    case 8:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            }
            while (select3!=8);
        }
    }
}
