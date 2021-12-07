import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProdcastFilter {

    public List<ProdEpiData> getByCelebrity(List<ProdEpiData> prodList,String celbName){

        List<ProdEpiData> filterByCelebrity=prodList.stream().filter(p->p.getCelbName().equalsIgnoreCase(celbName)).
                sorted(Comparator.comparing(ProdEpiData::getCelbName)).collect(Collectors.toList());
        return filterByCelebrity;
    }

    public List<ProdEpiData> getByPubDate(List<ProdEpiData> prodList, Date publishedDate){
        List<ProdEpiData> filterByDate = prodList.stream().filter(p->p.getPublishedDate().equals(publishedDate)).
                sorted(Comparator.comparing(ProdEpiData::getCelbName)).collect(Collectors.toList());
        return filterByDate;
    }

    public void display (List<ProdEpiData> displayList){

        Consumer<ProdEpiData> displayProdcast = (list)->System.out.println(list);
        displayList.forEach(displayProdcast);
        System.out.println();

    }
}
