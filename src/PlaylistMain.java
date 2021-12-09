import java.util.List;
import java.util.Scanner;

public class PlaylistMain {
    public static void main(String [] args){

        PlayListDbOperation pldbo = new PlayListDbOperation();
        List<PlaylistContent> masterdata = pldbo.getAllPlayListCont();
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do {
            System.out.println("Enter the Option You Want to Select");
            System.out.println("1.View All PlayList\n2.Add in PlayList By Song Id or ProdCast Episode Id");
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
                    System.out.println("Enter the Track Id ");
                    int track = sc.nextInt();
                    sc.nextLine();
                    boolean contId = pldbo.addPlayListByTrackId(plName,time,track);
                    sc.nextLine();
                    System.out.println("PlayList Addition is "+contId);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        while (choice==1);
    }
}
