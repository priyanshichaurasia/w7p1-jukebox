import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PlayListFilter {

    public List<PlaylistContent> getByPlayName(List<PlaylistContent> playList, String plName){
        List<PlaylistContent> searchBySongName = new ArrayList<PlaylistContent>();

        Optional filterByCelebrity=playList.stream().filter(p->p.getPlayName().equalsIgnoreCase(plName)).
                sorted(Comparator.comparing(PlaylistContent::getPlayName)).findAny();
        if(filterByCelebrity.isPresent()){
            searchBySongName = playList.stream().filter(p->p.getPlayName().equalsIgnoreCase(plName)).
                    sorted(Comparator.comparing(PlaylistContent::getPlayName)).collect(Collectors.toList());
        }
        return searchBySongName;
    }
    public void display (List<PlaylistContent> displayData){

        Consumer<PlaylistContent> displayplaylist = (list)->System.out.println(list);
        displayData.forEach(displayplaylist);
        System.out.println();
    }

}
