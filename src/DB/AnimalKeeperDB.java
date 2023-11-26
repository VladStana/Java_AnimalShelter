package DB;

import Employees.AnimalKeeper;
import Services.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalKeeperDB {
    private static AnimalKeeperDB akdb = null;
    private final DBConnection DBconn = DBConnection.getInstance();

    public static AnimalKeeperDB getInstance() {
        if(akdb == null)
            akdb = new AnimalKeeperDB();
        return akdb;
    }

    public void getAnimalKeepers (Service s) throws SQLException {
        try {
            Statement st = DBconn.getConn().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM animal_keepers");
            while (rs.next()) {
                s.aks.addAnimalKeeper(
                        new AnimalKeeper(rs.getString("name"),
                                rs.getInt("age"),
                                rs.getString("assign_animal"))
                );
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAnimalKeeper(AnimalKeeper ak) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("INSERT INTO animal_keepers VALUES(" +
                        "'" + ak.getName() + "'," +
                        ak.getAge() + "," +
                        "'" + ak.getAssign_animal() + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteAnimalKeeperByName(String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("DELETE FROM animal_keepers WHERE name='" + name + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateAnimalKeeperDB(String field, String value, String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                if (field.equals("name") || field.equals("assign_animal"))
                    st.executeUpdate("UPDATE animal_keepers SET " +
                            field + "='" + value + "'" +
                            " WHERE name=" + "'" + name + "'");
                else
                    st.executeUpdate("UPDATE animal_keepers SET " +
                            field + "=" + value +
                            " WHERE name=" + "'" + name + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
