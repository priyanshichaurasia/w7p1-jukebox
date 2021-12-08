import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SongFilter {

    public List<Songdata1> getSongsBySongName(List<Songdata1> filterAllSong, String songName){
        List<Songdata1> searchBysName = new ArrayList<Songdata1>();

        Optional filterlist = filterAllSong.stream().filter(p->p.getsName().equalsIgnoreCase(songName)).
                sorted(Comparator.comparing(Songdata1::getsName)).findAny();

        if(filterlist.isPresent()) {
            searchBysName = filterAllSong.stream().filter(p->p.getsName().equalsIgnoreCase(songName)).
                    sorted(Comparator.comparing(Songdata1::getsName)).collect(Collectors.toList());
        }
        return searchBysName;
    }

    public List<Songdata1> getSongsByArtist(List<Songdata1> filterAllSong, String artName){
        List<Songdata1> searchByArtName = new ArrayList<Songdata1>();

        Optional filterlist = filterAllSong.stream().filter(p->p.getArtName().equalsIgnoreCase(artName)).
                sorted(Comparator.comparing(Songdata1::getArtName)).findAny();
        if(filterlist.isPresent()){
            searchByArtName = filterAllSong.stream().filter(p->p.getArtName().equalsIgnoreCase(artName)).
                    sorted(Comparator.comparing(Songdata1::getArtName)).collect(Collectors.toList());
        }
        return searchByArtName;
    }

    public List<Songdata1> getSongsByAlbum(List<Songdata1> filterAllSong, String albName){
        List<Songdata1> searchByAlbName = new ArrayList<Songdata1>();

        Optional filterAlbum = filterAllSong.stream().filter(p->p.getAlbName().equalsIgnoreCase(albName)).
                sorted(Comparator.comparing(Songdata1::getAlbName)).findAny();
        if(filterAlbum.isPresent()){
            searchByAlbName = filterAllSong.stream().filter(p->p.getAlbName().equalsIgnoreCase(albName)).
                    sorted(Comparator.comparing(Songdata1::getAlbName)).collect(Collectors.toList());
        }
        return searchByAlbName;
    }

    public List<Songdata1> getSongsByGenere(List<Songdata1> filterAllSong, String gName){
        List<Songdata1> searchByGenName = new ArrayList<Songdata1>();
        Optional filterGenere = filterAllSong.stream().filter(p->p.getgName().equalsIgnoreCase(gName)).
                sorted(Comparator.comparing(Songdata1::getgName)).findAny();
        if(filterGenere.isPresent()){
            searchByGenName = filterAllSong.stream().filter(p->p.getgName().equalsIgnoreCase(gName)).
                    sorted(Comparator.comparing(Songdata1::getsName)).collect(Collectors.toList());
        }
        return  searchByGenName;
    }

    public void display (List<Songdata1> displayData){

        Consumer<Songdata1> displaySong = (list)->System.out.println(list);
        displayData.forEach(displaySong);
        System.out.println();

    }

}
