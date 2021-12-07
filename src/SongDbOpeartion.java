import java.sql.*;
import java.util.Date;
import java.util.*;

public class SongDbOpeartion {

    public boolean addSong(String sName,String timedur, String artname,String gend,String albname,Date relDtate, String genname) {

            int artid = getArtistId(artname,gend);
            int albid = getAlbumId(albname,new java.sql.Date(relDtate.getTime()));
            int genid = getGenereId(genname);
            boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into song(sName,timeDuration,artId,albId,gId) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,sName);
            ps.setString(2, timedur);
            ps.setInt(3,artid);
            ps.setInt(4,albid);
            ps.setInt(5,genid);
            if(ps.executeUpdate()==1){
                result = true;
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int sId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;

    }
    public int getArtistId(String Artname, String gender) {
        int artistId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "select * from artist where artName =? and gender = ?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Artname);
            ps.setString(2, gender);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                artistId = rs.getInt(1);
            } else {
                artistId = addArtistId(Artname, gender);
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return artistId;
    }

    public int addArtistId(String name, String gender){
        int artId =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into artist(artName,gender) values(?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, gender);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    artId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return artId;
    }

    public int getAlbumId(String albname, Date releaseDate) {
        int albId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "select * from album where albName =? and releaseDate = ?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, albname);
            ps.setDate(2, new java.sql.Date(releaseDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                albId = rs.getInt(1);
            } else {
                albId = addAlbId(albname,releaseDate);
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return albId;
    }

    public int addAlbId(String albName, Date releaseDate){
        int albId =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into album(albName,releaseDate) values(?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, albName);
            ps.setDate(2, new java.sql.Date(releaseDate.getTime()));
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    albId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return albId;
    }

    public int getGenereId(String gName) {
        int gId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "select * from genere where gName =? ";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gId = rs.getInt(1);
            } else {
                gId = addGenereId(gName);
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gId;
    }

    public int addGenereId(String gName){
        int gId =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into genere(gName) values(?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gName);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    gId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gId;
    }

    public List<Songdata1> getSongs(){
        List<Songdata1> filterAllSong = new ArrayList<Songdata1>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            Statement st = con.createStatement();
            String query = "select * from songdata1";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Songdata1 sd1 = new Songdata1(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6));
                filterAllSong.add(sd1);
            }
//            for(Songdata1 sd: filterAllSong){
//                System.out.println(sd);
//            }
            rs.close();
            st.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return filterAllSong;
    }
}
