import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SongFilter {

    public List<Songdata1> getSongsByArtist(List<Songdata1> filterAllSong, String artName){

        List<Songdata1> filterlist = filterAllSong.stream().filter(p->p.getArtName().equalsIgnoreCase(artName)).
                sorted(Comparator.comparing(Songdata1::getArtName)).collect(Collectors.toList());
        return filterlist;
    }

    public List<Songdata1> getSongsByAlbum(List<Songdata1> filterAllSong, String albName){

        List<Songdata1> filterAlbum = filterAllSong.stream().filter(p->p.getAlbName().equalsIgnoreCase(albName)).
                sorted(Comparator.comparing(Songdata1::getAlbName)).collect(Collectors.toList());
        return filterAlbum;
    }

    public List<Songdata1> getSongsByGenere(List<Songdata1> filterAllSong, String gName){

        List<Songdata1> filterGenere = filterAllSong.stream().filter(p->p.getgName().equalsIgnoreCase(gName)).
                sorted(Comparator.comparing(Songdata1::getsName)).collect(Collectors.toList());
        return  filterGenere;
    }

    public void display (List<Songdata1> displayData){

        Consumer<Songdata1> displaySong = (list)->System.out.println(list);
        displayData.forEach(displaySong);
        System.out.println();

    }

}
