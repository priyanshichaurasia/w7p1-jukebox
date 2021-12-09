import java.util.Date;

public class ProdEpisodeType extends PlaylistContent{
    private String epiName,epiTime;

    public ProdEpisodeType(){

    }
    public ProdEpisodeType(int contId,String playName,String listDuration,String epiName, String epiTime){
        super(contId,playName,listDuration);
        this.epiName=epiName;
        this.epiTime=epiTime;
    }

    public String getEpiName() {
        return epiName;
    }

    public void setEpiName(String epiName) {
        this.epiName = epiName;
    }

    public String getEpiTime() {
        return epiTime;
    }

    public void setEpiTime(String epiTime) {
        this.epiTime = epiTime;
    }

    @Override
    public String toString(){
        return (super.toString()+" , "+ epiName+" , "+ epiTime);
    }


}
