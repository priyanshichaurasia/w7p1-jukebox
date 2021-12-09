import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class PlaylistMain {
    public static void main(String [] args) throws ParseException {

        PlayListDbOperation pldbo = new PlayListDbOperation();
        List<PlaylistContent> masterdata = pldbo.getAllPlayListCont();
        PlayListFilter plf = new PlayListFilter();
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do {
            System.out.println("Enter the Option You Want to Select");
            System.out.println("1.View All PlayList    2.Add in PlayList By Song Id    3.Add in PlayList By Prodcast Episode " +
                    "Id    4.Add By Song Name    5.Filter By PlayName");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    masterdata = pldbo.getAllPlayListCont();
                    plf.display(masterdata);

                    break;
                case 2:
                    SongDbOpeartion sdbo1 = new SongDbOpeartion();
                    List<Songdata1> sdd= sdbo1.getSongs();
                    SongFilter sf1 = new SongFilter();
                    System.out.println("Available Songs");
                    sf1.display(sdd);
                    System.out.println("Enter the PlayList Name");
                    String plName=sc.nextLine();
                    System.out.println("Enter the Time Duration For PlayList");
                    String time = sc.nextLine();
                    System.out.println("Enter the Song Id ");
                    int track = sc.nextInt();
                    sc.nextLine();
                    boolean contId = pldbo.addPlayListByTrackId(plName,time,track);
                    sc.nextLine();
                    System.out.println("PlayList Addition is "+contId);
                    break;
                case 3:
                    ProdcastDbOperation pdep = new ProdcastDbOperation();
                    List<ProdEpiData> epelist = pdep.getProdEpiList();
                    ProdcastFilter pcf1 = new ProdcastFilter();
                    pcf1.display(epelist);
                    System.out.println("Enter the PlayList Name");
                    String plEpName=sc.nextLine();
                    System.out.println("Enter the Time Duration For PlayList");
                    String epiTime = sc.nextLine();
                    System.out.println("Enter the Track Id ");
                    int trackEpi = sc.nextInt();
                    sc.nextLine();
                    boolean epiId = pldbo.addPlayListByTrackId(plEpName,epiTime,trackEpi);
                    sc.nextLine();
                    System.out.println("PlayList Addition is "+epiId);
                    break;
                case 4:
                    System.out.println("Enter the PlayList Name");
                    String plName1=sc.nextLine();
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
                    int contId1 = pldbo.addPlayListBySongName(plName1,time1,track1,sTime,artName,gender,albName,dt1,genName);
                    sc.nextLine();
                    System.out.println("PlayList Is Added Succesfully your id is "+contId1);
                    break;
                case 5:
                    System.out.println("Enter the PlayList Name To Search");
                    String pName = sc.nextLine();
                    List<PlaylistContent> filterBypName =plf.getByPlayName(masterdata,pName);
                    plf.display(filterBypName);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
        while (choice==1);
    }
}
