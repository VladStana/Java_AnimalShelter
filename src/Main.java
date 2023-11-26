import Animals.*;
import DB.*;
import Files.*;
import Services.*;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
//        service.ReadCSV();
//        service.ConnectToDB();

        DBConnection DBconn = DBConnection.getInstance();
        DogDB ddb = DogDB.getInstance();
        CatDB cdb = CatDB.getInstance();
        OtherDB odb = OtherDB.getInstance();
        AnimalKeeperDB akdb = AnimalKeeperDB.getInstance();
        DoctorDB docdb = DoctorDB.getInstance();
        VolunteerDB vdb = VolunteerDB.getInstance();
        try {
            DBconn.startConnection();
            System.out.println("Database connection established!\n");

            ddb.getDogs(service);
            cdb.getCats(service);
            odb.getOthers(service);
            akdb.getAnimalKeepers(service);
            docdb.getDoctors(service);
            vdb.getVolunteers(service);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: Database connection failed!");
        }

        service.start();


    }
}
