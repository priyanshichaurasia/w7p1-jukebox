
public class Songdata1{

    private int sId;
    private String sName, timeDuration,artName,albName,gName;

    public Songdata1(int sId, String sName, String timeDuration, String artName,String albName, String gName){
        this.sId=sId;
        this.sName=sName;
        this.timeDuration=timeDuration;
        this.artName=artName;
        this.albName=albName;
        this.gName=gName;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getAlbName() {
        return albName;
    }

    public void setAlbName(String albName) {
        this.albName = albName;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }
    @Override
    public String toString(){
        return (sId +" , "+ sName +" , "+ timeDuration +" , "+ artName +" , "+ albName +" , "+ gName);
    }
}
