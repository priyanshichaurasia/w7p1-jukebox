import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PlaylistMain {
    public static void main(String [] args) throws ParseException {

        PlayListDbOperation pldbo = new PlayListDbOperation();
        List<PlaylistContent> masterdata = pldbo.getAllPlayListCont();
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do {
            System.out.println("Enter the Option You Want to Select");
            System.out.println("1.View All PlayList\n2.Add in PlayList By Song Names\n3.Add in PlayList By ProdCast Episode");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    masterdata = pldbo.getAllPlayListCont();
                    pldbo.display(masterdata);
                    break;
                case 2:
                    System.out.println("Enter the PlayList Name");
                    String plName=sc.nextLine();
                    System.out.println("Enter the Time Duration For PlayList");
                    String time = sc.nextLine();
                    System.out.println("Enter the Song Name");
                    String track = sc.nextLine();
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
                    int contId = pldbo.addPlayListBySongName(plName,time,track,sTime,artName,gender,albName,dt1,genName);
                    sc.nextLine();
                    System.out.println("PlayList Is Added Succesfully your id is "+contId);
                    break;
                case 3:
                    System.out.println("Enter the PlayList Name");
                    String plName1=sc.nextLine();
                    System.out.println("Enter the Time Duration For PlayList");
                    String time1 = sc.nextLine();
                    System.out.println("Enter Episode No");
                    int epiNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Name For Episode");
                    String epiName = sc.nextLine();
                    System.out.println("Enter Time Duration for Episode");
                    String epitime = sc.nextLine();
                    System.out.println("Enter the Published Date");
                    String publishdDate = sc.nextLine();
                    java.util.Date pubshdDt = new SimpleDateFormat("yyyy-MM-dd").parse(publishdDate);
                    System.out.println("Enter the Prodcast Name");
                    String podName = sc.nextLine();
                    System.out.println("Enter the Narrator Name");
                    String narName = sc.nextLine();
                    System.out.println("Enter the Prodcast Type Name");
                    String prodType = sc.nextLine();
                    System.out.println("Enter the Celebrity Name");
                    String celbName = sc.nextLine();
                    int contEpId = pldbo.addPlayListByEpisodeName(plName1,time1,epiNo,epiName,epitime,pubshdDt,
                            podName,prodType,narName,celbName);
                    sc.nextLine();
                    System.out.println("PlayList Is Added Succesfully your id is "+contEpId);
                    break;
            }
        }
        while (choice==2);
    }
}
