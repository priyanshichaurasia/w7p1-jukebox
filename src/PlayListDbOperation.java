import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class PlayListDbOperation {

    private int getPlayListId(String playName){
        int playId=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox","root","root");
            String query = "select * from playlist where playName =? ";
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,playName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                playId=rs.getInt(1);
            }
            else{
                playId=addPlayList(playName);
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return playId;
    }

    private int addPlayList(String playName){
        int playId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query ="insert into playlist(playName) values(?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, playName);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    playId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return playId;

    }

    public boolean addPlayListByTrackId(String playName, String duration,int trackId) {
        boolean result = false;
        int playId = getPlayListId(playName);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into playlistcontent(playId,listDuration,trackId) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, playId);
            ps.setString(2, duration);
            ps.setInt(3, trackId);
            if (ps.executeUpdate() == 1) {
                result=true;
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int playContId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    public int addPlayListBySongName(String playName, String duration, String trackName, String sTime, String artName,
                                     String gender, String albName, Date relDate,String genereName) {
        int playContId = 0, trackId=0;
        int playId = getPlayListId(playName);

        SongDbOpeartion sdbo = new SongDbOpeartion();
        List<Songdata1> songlist = sdbo.getSongs();

        for (Songdata1 sd1 : songlist) {
            if (sd1.getgName().equalsIgnoreCase(trackName)) {
                trackId = sd1.getsId();
            }
        }
        if(trackId==0){
            trackId=sdbo.addSong(trackName,sTime,artName,gender,albName,relDate,genereName);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into playlistcontent(playId,listDuration,trackId) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, playId);
            ps.setString(2, duration);
            ps.setInt(3, trackId);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    playContId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return playContId;
    }

    public List<PlaylistContent> getAllPlayListCont(){
        List<PlaylistContent> data = new ArrayList<PlaylistContent>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            //-- episode int, string, string, --,--,string, string
            //-- song int, string, string, string, string, -- , --
            Statement st = con.createStatement();
            String query = "select * from playlistcontdata1";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(4)!= null){
                    SongType st1 = new SongType(rs.getInt(1),rs.getString(2),rs.getString(3),
                            rs.getString(4),rs.getString(5));
                    data.add(st1);
                }
                else{
                    ProdEpisodeType playet = new ProdEpisodeType(rs.getInt(1),rs.getString(2),
                            rs.getString(3),rs.getString(6),rs.getString(7));
                    data.add(playet);
                }
            }
            rs.close();
            st.close();
            con.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return data;
    }
//    public void display(List<PlaylistContent> disp){
//        for(PlaylistContent plc: disp){
//            System.out.println(plc);
//        }
//    }
}
