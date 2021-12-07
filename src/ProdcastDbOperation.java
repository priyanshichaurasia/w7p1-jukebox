import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ProdcastDbOperation {

    public int addProdcast(String podName,String typeName,String narName,String celbName){
        int prodTypeId = getProdTypeId(typeName);
        int narId = getNarId(narName);
        int celbId = getCelbId(celbName);
        int podId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "insert into prodcast(podName,ptId,narId,celbId) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,podName);
            ps.setInt(2,prodTypeId);
            ps.setInt(3,narId);
            ps.setInt(4,celbId);
            if(ps.executeUpdate()==1){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    podId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return podId;
    }

    private int getProdTypeId(String typeName){
        int prodTypeId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "select * from prodType where typeName =?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, typeName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prodTypeId = rs.getInt(1);
            } else {
                prodTypeId = addProdType(typeName);
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return prodTypeId;
    }

    private int addProdType(String typeName){
        int prodTypeId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query ="insert into prodtype(typeName) values(?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, typeName);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    prodTypeId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return  prodTypeId;
    }

    private int getNarId(String narName){
        int narId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "select * from prodType where typeName =?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, narName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                narId = rs.getInt(1);
            } else {
                narId = addNarrator(narName);
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return narId;
    }

    private int addNarrator(String narName){
        int narId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query ="insert into narrator(narName) values(?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, narName);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                     narId= rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return  narId;
    }

    private int getCelbId(String celbName){
        int celbId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query = "select * from prodType where typeName =?";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, celbName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                celbId = rs.getInt(1);
            } else {
                celbId = addCelebrity(celbName);
            }
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return celbId;
    }

    private int addCelebrity(String celbName){
        int celbId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query ="insert into celebrity(celbName) values(?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, celbName);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    celbId= rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return  celbId;
    }

    public boolean addProdEpisode(int epiNo,String epiName,String time,Date pubDate,String podName,String typeName,String narName,String celbName){
        int podId = addProdcast(podName,typeName,narName,celbName);
        boolean res = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            String query ="insert into prodEpisode(epiNo,epiName,timeDuration,publishedDate,podId) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,epiNo);
            ps.setString(2,epiName);
            ps.setString(3,time);
            ps.setDate(4,new java.sql.Date(pubDate.getTime()));
            ps.setInt(5,podId);
            if (ps.executeUpdate() == 1) {
                res = true;
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int prodEpiId = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return  res;
    }

    public List<ProdEpiData> getProdEpiList(){
        List<ProdEpiData> prodList = new ArrayList<ProdEpiData>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeBox",
                    "root", "root");
            Statement st = con.createStatement();
            String query = "select * from prodEpiData";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                ProdEpiData ped = new ProdEpiData(rs.getInt(1),rs.getInt(2),rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),rs.getDate(7),
                        rs.getString(8),rs.getString(9));
                prodList.add(ped);
            }
            rs.close();
            st.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return prodList;
    }
}
