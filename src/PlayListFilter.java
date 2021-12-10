import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PlayListFilter {

    public List<PlaylistContent> getByPlayName(List<PlaylistContent> playList, String plName){
        List<PlaylistContent> searchByplayName = new ArrayList<PlaylistContent>();

        Optional filterByCelebrity=playList.stream().filter(p->p.getPlayName().equalsIgnoreCase(plName)).
                sorted(Comparator.comparing(PlaylistContent::getPlayName)).findAny();
        if(filterByCelebrity.isPresent()){
            searchByplayName = playList.stream().filter(p->p.getPlayName().equalsIgnoreCase(plName)).
                    sorted(Comparator.comparing(PlaylistContent::getPlayName)).collect(Collectors.toList());
        }
        else{
            System.out.println("No Record Found");
        }
        return searchByplayName;
    }
    public List<SongType> getBySongName(List<SongType> playList, String songName){
        List<SongType> searchBySongName = new ArrayList<SongType>();

        Optional filterBySong=playList.stream().filter(p->p.getsName().equalsIgnoreCase(songName)).
                sorted(Comparator.comparing(SongType::getsName)).findAny();
        if(filterBySong.isPresent()){
            searchBySongName = playList.stream().filter(p->p.getsName().equalsIgnoreCase(songName)).
                    sorted(Comparator.comparing(SongType::getsName)).collect(Collectors.toList());
        }
        else{
            System.out.println("No Record Found");
        }
        return searchBySongName;
    }

    public void display (List<PlaylistContent> displayData){

        Consumer<PlaylistContent> displayplaylist = (list)->System.out.println(list);
        displayData.forEach(displayplaylist);
        System.out.println();
    }

    public void displaySong(List<SongType> songs){
        Consumer<SongType> displayplaylist = (list)->System.out.println(list);
        songs.forEach(displayplaylist);
        System.out.println();
    }

}
