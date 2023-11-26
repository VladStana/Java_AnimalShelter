package DB;

import Animals.Cat;
import Services.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CatDB {
    private static CatDB cdb = null;
    private final DBConnection DBconn = DBConnection.getInstance();

    public static CatDB getInstance() {
        if(cdb == null)
            cdb = new CatDB();
        return cdb;
    }

    public void getCats (Service s) throws SQLException {
        try {
            Statement st = DBconn.getConn().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM cats");
            while (rs.next()) {
                s.cs.addCat(
                        new Cat(rs.getString("name"),
                                rs.getString("sex"),
                                rs.getInt("age"),
                                rs.getFloat("weight"),
                                rs.getBoolean("trained"),
                                rs.getString("fur_pattern"),
                                rs.getString("fur_color"))
                );
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCat(Cat cat) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("INSERT INTO cats VALUES(" +
                        "'" + cat.getName() + "'," +
                        "'" + cat.getSex() + "'," +
                        cat.getAge() + "," +
                        cat.getWeight() + "," +
                        cat.getTrained() + "," +
                        "'" + cat.getFur_pattern() + "'," +
                        "'" + cat.getFur_color() + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteCatByName(String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("DELETE FROM cats WHERE name='" + name + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCatDB(String field, String value, String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                if (field.equals("name") || field.equals("sex") || field.equals("fur_pattern") || field.equals("fur_color"))
                    st.executeUpdate("UPDATE cats SET " +
                            field + "='" + value + "'" +
                            " WHERE name=" + "'" + name + "'");
                else
                    st.executeUpdate("UPDATE cats SET " +
                            field + "=" + value +
                            " WHERE name=" + "'" + name + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
