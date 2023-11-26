package DB;

import Animals.Dog;
import Services.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DogDB {
    private static DogDB ddb = null;
    private final DBConnection DBconn = DBConnection.getInstance();

    public static DogDB getInstance() {
        if(ddb == null)
            ddb = new DogDB();
        return ddb;
    }

    public void getDogs (Service s) throws SQLException {
        try {
            Statement st = DBconn.getConn().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM dogs");
            while (rs.next()) {
                s.ds.addDog(
                        new Dog(rs.getString("name"),
                                rs.getString("sex"),
                                rs.getInt("age"),
                                rs.getFloat("weight"),
                                rs.getBoolean("trained"),
                                rs.getString("breed"),
                                rs.getInt("category"))
                );
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDog(Dog dog) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("INSERT INTO dogs VALUES(" +
                        "'" + dog.getName() + "'," +
                        "'" + dog.getSex() + "'," +
                        dog.getAge() + "," +
                        dog.getWeight() + "," +
                        dog.getTrained() + "," +
                        "'" + dog.getBreed() + "'," +
                        "'" + dog.getCategory() + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteDogByName(String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                st.execute("DELETE FROM dogs WHERE name='" + name + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateDogDB(String field, String value, String name) {
        if(DBconn.getConn() != null) {
            try {
                Statement st = DBconn.getConn().createStatement();
                if (field.equals("name") || field.equals("sex") || field.equals("breed"))
                    st.executeUpdate("UPDATE dogs SET " +
                            field + "='" + value + "'" +
                            " WHERE name=" + "'" + name + "'");
                else
                    st.executeUpdate("UPDATE dogs SET " +
                            field + "=" + value +
                            " WHERE name=" + "'" + name + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
