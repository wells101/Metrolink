import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaming on 5/5/2015.
 */
public class MetrolinkDAO implements LaunchCodeDAO{

    public static final String JDBC_SQLITE_METROLINK_DB = "jdbc:sqlite:metrolink.db";
    public static final String ORG_SQLITE_JDBC = "org.sqlite.JDBC";
    private static MetrolinkDAO dao;

    public static MetrolinkDAO getInstance(){
        if(dao == null){
            dao = new MetrolinkDAO();
        }
        return dao;
    }
    @Override
    public List<Station> getMetrolinkStops() {
        try(Connection conn = getConnection()){
            PreparedStatement statement = conn.prepareStatement("SELECT stop_name, stop_id FROM stops WHERE stop_name LIKE '%METROLINK STATION%'");
            ResultSet myResults = statement.executeQuery();
            List<Station> stops = new ArrayList<Station>();
            while(myResults.next()){
                Station nextStop = new Station();
                nextStop.setName(myResults.getString("stop_name"));
                nextStop.setID(myResults.getString("stop_id"));
                stops.add(nextStop);
            }
            return stops;
        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Unable to find Database", e);
        }
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName(ORG_SQLITE_JDBC);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find class for loading the database", e);
        }
        return DriverManager.getConnection(JDBC_SQLITE_METROLINK_DB);
    }

    public List<String> getArrivals(Station stop) {
        try(Connection conn = getConnection()){
            PreparedStatement statement = conn.prepareStatement("SELECT arrival_time FROM stop_times WHERE stop_id LIKE '" + stop.getID() + "'");
            ResultSet myResults = statement.executeQuery();
            List<String> arrivals = new ArrayList<String>();
            while(myResults.next()){
               arrivals.add(myResults.getString("arrival_time"));
            }
            return arrivals;
        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Unable to find Database", e);
        }
    }
}
