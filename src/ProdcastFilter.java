import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProdcastFilter {

    public List<ProdEpiData> getByCelebrity(List<ProdEpiData> prodList,String celbName){
        List<ProdEpiData> searchByCelbName = new ArrayList<ProdEpiData>();

        Optional filterByCelebrity=prodList.stream().filter(p->p.getCelbName().equalsIgnoreCase(celbName)).
                sorted(Comparator.comparing(ProdEpiData::getCelbName)).findAny();
        if(filterByCelebrity.isPresent()){
            searchByCelbName = prodList.stream().filter(p->p.getCelbName().equalsIgnoreCase(celbName)).
                    sorted(Comparator.comparing(ProdEpiData::getCelbName)).collect(Collectors.toList());
        }
        else{
            System.out.println("No Record Found");
        }
        return searchByCelbName;
    }

    public List<ProdEpiData> getByPubDate(List<ProdEpiData> prodList, Date publishedDate){
        List<ProdEpiData> searchByPubDate = new ArrayList<ProdEpiData>();

         Optional filterByDate = prodList.stream().filter(p->p.getPublishedDate().equals(publishedDate)).
                sorted(Comparator.comparing(ProdEpiData::getCelbName)).findAny();
         if(filterByDate.isPresent()){
             searchByPubDate = prodList.stream().filter(p->p.getPublishedDate().equals(publishedDate)).
                     sorted(Comparator.comparing(ProdEpiData::getCelbName)).collect(Collectors.toList());
         }
         else{
             System.out.println("No Record Found");
         }
        return searchByPubDate;
    }

    public void display (List<ProdEpiData> displayList){

        Consumer<ProdEpiData> displayProdcast = (list)->System.out.println(list);
        displayList.forEach(displayProdcast);
        System.out.println();

    }
}
