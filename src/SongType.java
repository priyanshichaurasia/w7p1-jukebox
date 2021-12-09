public class SongType extends PlaylistContent {

    private String sName,sTime;

    public SongType(){

    }
    public SongType(int contId,String playName,String listDuration,String sName,String sTime){
        super(contId,playName,listDuration);
        this.sName=sName;
        this.sTime=sTime;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    @Override
    public String toString() {
        return super.toString()+"  "+"SongType{" +
                "sName='" + sName + '\'' +
                ", sTime='" + sTime + '\'' +
                '}';
    }
}
