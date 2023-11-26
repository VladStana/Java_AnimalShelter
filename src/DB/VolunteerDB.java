package DB;

import Employees.Volunteer;
import Services.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VolunteerDB {
    private static VolunteerDB vdb = null;
    private final DBConnection DBconn = DBConnection.getInstance();

    public static VolunteerDB getInstance() {
        if(vdb == null)
            vdb = new VolunteerDB();
        return vdb;
    }

    public void getVolunteers (Service s) throws SQLException {
        try {
            Statement st = DBconn.getConn().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM volunteers");
            while (rs.next()) {
                s.vs.addVolunteer(
                        new Volunteer(rs.getString("name"),
                                rs.getInt("age"))
                );
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertVolunteer(Volunteer ak) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("INSERT INTO volunteers VALUES(" +
                        "'" + ak.getName() + "'," +
                        ak.getAge() + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteVolunteerByName(String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("DELETE FROM volunteers WHERE name='" + name + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateVolunteerDB(String field, String value, String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                if (field.equals("name"))
                    st.executeUpdate("UPDATE volunteers SET " +
                            field + "='" + value + "'" +
                            " WHERE name=" + "'" + name + "'");
                else
                    st.executeUpdate("UPDATE volunteers SET " +
                            field + "=" + value +
                            " WHERE name=" + "'" + name + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
