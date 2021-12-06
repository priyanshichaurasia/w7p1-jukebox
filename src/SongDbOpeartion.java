import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SongDbOpeartion {

    public int generateArtistId(String artName, String gender){
        int artId =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into artist(artName,gender) values(?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, artName);
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

    public  int genersteAlbumId(String albName, Date releaseDate) {
        int albId =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into album(albName,releaseDate) values(?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, albName);
            ps.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    albId = rs.getInt(1);
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return albId;
    }

    public int generateGenereId(String gName){
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
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gId;
    }

    public boolean addSong(Song sd) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into song(sName,timeDuration,artId,albId,gId) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,sd.getSName());
            ps.setString(2, sd.getTimeDuration());
            ps.setInt(3,sd.getArtId());
            ps.setInt(4,sd.getAlbId());
            ps.setInt(5,sd.getGId());
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

    public List<Song> getSongsByArtist(){
        List<Song> filterAllSong = new ArrayList<Song>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            Statement st = con.createStatement();
            String query = "select * from songdata2";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Song s1 = new Song(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6));
                filterAllSong.add(s1);
            }
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
