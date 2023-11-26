package DB;

import Animals.Other;
import Services.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OtherDB {
    private static OtherDB odb = null;
    private final DBConnection DBconn = DBConnection.getInstance();

    public static OtherDB getInstance() {
        if(odb == null)
            odb = new OtherDB();
        return odb;
    }

    public void getOthers (Service s) throws SQLException {
        try {
            Statement st = DBconn.getConn().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM others");
            while (rs.next()) {
                s.os.addOther(
                        new Other(rs.getString("name"),
                                rs.getString("sex"),
                                rs.getInt("age"),
                                rs.getFloat("weight"),
                                rs.getBoolean("trained"),
                                rs.getString("species"))
                );
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOther(Other other) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("INSERT INTO others VALUES(" +
                        "'" + other.getName() + "'," +
                        "'" + other.getSex() + "'," +
                        other.getAge() + "," +
                        other.getWeight() + "," +
                        other.getTrained() + "," +
                        "'" + other.getSpecies() + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteOtherByName(String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("DELETE FROM others WHERE name='" + name + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateOtherDB(String field, String value, String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                if (field.equals("name") || field.equals("sex") || field.equals("species"))
                    st.executeUpdate("UPDATE others SET " +
                            field + "='" + value + "'" +
                            " WHERE name=" + "'" + name + "'");
                else
                    st.executeUpdate("UPDATE others SET " +
                            field + "=" + value +
                            " WHERE name=" + "'" + name + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
