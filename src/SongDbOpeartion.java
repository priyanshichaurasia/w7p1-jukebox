import java.sql.*;
import java.util.Date;
import java.util.*;
import java.util.function.Consumer;
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

    public  int generateAlbumId(String albName, Date releaseDate) {
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

    public boolean addSong(String sName,String timedur, int artId, int albId, int gId ) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into song(sName,timeDuration,artId,albId,gId) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,sName);
            ps.setString(2, timedur);
            ps.setInt(3,artId);
            ps.setInt(4,albId);
            ps.setInt(5,gId);
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
            ps.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
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
            ps.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
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
            Consumer<Songdata1> displaySong = (list)->System.out.println(list);
            System.out.println("List of All Songs");
            filterAllSong.forEach(displaySong);
            System.out.println();

            rs.close();
            st.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return filterAllSong;
    }

    public List<Songdata1> getSongsByArtist(List<Songdata1> filterAllSong,String name){

        List<Songdata1> filterlist = filterAllSong.stream().filter(p->p.getArtName().equalsIgnoreCase(name)).
                sorted((s1,s2)->s1.getsName().compareTo(s2.getsName())).collect(Collectors.toList());
        System.out.println("List of Songs filter By Artitst Name");
        filterlist.forEach(i->System.out.println(i));
//        Collection.sort(filterlist);

        return filterlist;
    }
}
