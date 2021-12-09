public class PlaylistContent {

    private int contId;
    private String PlayName,listDuration;

    public PlaylistContent(){

    }
    public PlaylistContent(int contId,String playName,String listDuration){
        this.contId=contId;
        this.PlayName=playName;
        this.listDuration=listDuration;
    }
    public int getContId() {
        return contId;
    }

    public void setContId(int contId) {
        this.contId = contId;
    }

    public String getPlayName() {
        return PlayName;
    }

    public void setPlayName(String playName) {
        PlayName = playName;
    }

    public String getListDuration() {
        return listDuration;
    }

    public void setListDuration(String listDuration) {
        this.listDuration = listDuration;
    }

    @Override
    public String toString() {
        return "PlaylistContent{" +
                "contId=" + contId +
                ", PlayName='" + PlayName + '\'' +
                ", listDuration='" + listDuration + '\'' +
                '}';
    }
}
