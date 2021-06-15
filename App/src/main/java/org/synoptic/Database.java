package org.synoptic;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {

    private static Connection databaseConnection;

    static {
        Database.connectDatabase();
    }

    // (DG) - Return the Database Connection
    public static Connection getDatabaseConnection() {
        return databaseConnection;
    }

    // (DG) - Create a Database Connection. Returns true upon successful creation, terminates program upon failure.
    private static void connectDatabase() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            databaseConnection = DriverManager.getConnection("jdbc:mariadb://81.104.43.46:3306/ecoSwellDatabase", "appUser", "9iPTs#ko");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(1);
        }
    }

    public static boolean registerShop(String name, String address, String phoneNumber, String description)
    {
        try
        {
            PreparedStatement statement = getDatabaseConnection().prepareStatement("INSERT INTO poi (name, address, phone, description, type) VALUES (?, ?, ?, ?, ?);");
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, phoneNumber);
            statement.setString(4, description);
            statement.setString(5, POI.Type.SHOP.toString());

            statement.executeUpdate();

            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static List<POI> getAllPOIs() throws SQLException
    {
        PreparedStatement statement = getDatabaseConnection().prepareStatement("SELECT * FROM poi;");
        ResultSet resultSet = statement.executeQuery();

        List<POI> pois = new ArrayList<>();

        while (resultSet.next())
        {
            POI.Type type = POI.Type.valueOf(resultSet.getString("type"));

            if (type == POI.Type.WALKING_TRAIL)
            {
                pois.add(new POI(resultSet.getString("phone"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("description"), resultSet.getString("endAddress")));
            }
            else
            {
                pois.add(new POI(type, resultSet.getString("phone"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("description"), new HashMap<Integer, LocalTime[]>()));
            }
        }

        return pois;
    }


    /*
        CREATE TABLE poi (
                     name VARCHAR(200),
                     address VARCHAR(200),
                     phone VARCHAR(20) NOT NULL PRIMARY KEY ,
                     description VARCHAR(200),
                     type VARCHAR(20),
                     endAddress VARCHAR(200)
);
     */
}
