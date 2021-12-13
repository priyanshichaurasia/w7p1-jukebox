import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Media {
    int index=0;
    List<String> names;

    public Media(){
    }
    public void play(List<PlaylistContent> playlist,String path, String plname) {
        try {
            names = new ArrayList<String>();
            for(PlaylistContent pc: playlist) {
                if (pc.getPlayName().equalsIgnoreCase(plname)){
                    if (pc instanceof SongType) {
                        names.add(path + ((SongType) pc).getsName() + ".wav");
                        System.out.println(((SongType) pc).getsName());
                    } else {
                        names.add(path + ((ProdEpisodeType) pc).getEpiName() + ".wav");
                        System.out.println(((ProdEpisodeType)pc).getEpiName());
                    }
                }
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(names.get(index)).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            Scanner sc = new Scanner(System.in);
            String choice = "";
            while(!choice.equals("Q")){
                System.out.println("P = Play    S = Stop    R = Reset    N = Next    X = Previous    Q = Quit");
                System.out.println("Enter your choice: ");
                choice = sc.next();
                choice = choice.toUpperCase(Locale.ROOT);
                switch (choice){
                    case ("P"): clip.start();
                        break;
                    case ("S"): clip.stop();
                        break;
                    case ("R") : clip.setMicrosecondPosition(0);
                    break;
                    case ("N"): clip.stop();
                        audioStream = AudioSystem.getAudioInputStream(new File(names.get(++index)).getAbsoluteFile());
                        clip = AudioSystem.getClip();
                        clip.open(audioStream);
                        clip.start();
                        break;
                    case ("X"): clip.stop();
                        audioStream = AudioSystem.getAudioInputStream(new File(names.get(--index)).getAbsoluteFile());
                        clip = AudioSystem.getClip();
                        clip.open(audioStream);
                        clip.start();
                        break;
                    case ("Q"): clip.close();
                        break;
                    default:System.out.println("Enter a valid choice");
                }
            }
            System.out.println("Audio close");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
}
