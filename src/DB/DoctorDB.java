package DB;

import Employees.Doctor;
import Services.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorDB {
    private static DoctorDB docdb = null;
    private final DBConnection DBconn = DBConnection.getInstance();

    public static DoctorDB getInstance() {
        if(docdb == null)
            docdb = new DoctorDB();
        return docdb;
    }

    public void getDoctors (Service s) throws SQLException {
        try {
            Statement st = DBconn.getConn().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM doctors");
            while (rs.next()) {
                s.docs.addDoctor(
                        new Doctor(rs.getString("name"),
                                rs.getInt("age"))
                );
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDoctor(Doctor ak) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("INSERT INTO doctors VALUES(" +
                        "'" + ak.getName() + "'," +
                        ak.getAge() + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteDoctorByName(String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("DELETE FROM doctors WHERE name='" + name + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateDoctorDB(String field, String value, String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                if (field.equals("name"))
                    st.executeUpdate("UPDATE doctors SET " +
                            field + "='" + value + "'" +
                            " WHERE name=" + "'" + name + "'");
                else
                    st.executeUpdate("UPDATE doctors SET " +
                            field + "=" + value +
                            " WHERE name=" + "'" + name + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
