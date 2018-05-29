import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {

    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\\\Users\\\\Blazej W\\\\IdeaProjects\\\\TestDB\\\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String NAME_COLUMNS_CONTACTS = "name";
    public static final String PHONE_COLUMNS_CONTACTS = "phone";
    public static final String EMAIL_COLUMNS_CONTACTS = "email";

    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS contacts" + "(" +
                    NAME_COLUMNS_CONTACTS + " TEXT, " +
                    PHONE_COLUMNS_CONTACTS + " INTEGER, " +
                    EMAIL_COLUMNS_CONTACTS + " TEXT)");
            insertNewContact(statement,"Blaise", 987123, "blaise@blaise.bl");
            insertNewContact(statement,"John", 932123, "john@john.jo");
            insertNewContact(statement,"Janette", 3111123, "janette@jane.ja");
////            statement.execute("INSERT INTO contacts (name, phone, email)" +
////                                    " VALUES ('Esther', '01121231123', 'esther@esther.est')");
//            statement.execute("UPDATE contacts SET email = 'est@est.est' WHERE name = 'Esther'");
//            statement.execute("DELETE FROM contacts WHERE name = 'Janette'");
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while(results.next()){
                System.out.println(results.getString("name") + " " + results.getInt("phone") +
                " " + results.getString("email"));
            }
            results.close();
            statement.close();
            connection.close();
        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    public static void insertNewContact(Statement statement, String name, int phoneNum, String email){
        try {
            statement.execute("INSERT INTO " + TABLE_CONTACTS + "" + " (" +
                    NAME_COLUMNS_CONTACTS + ", " +
                    PHONE_COLUMNS_CONTACTS + ", " +
                    EMAIL_COLUMNS_CONTACTS + ")" +
                    " VALUES ('" + name + "', ' " + phoneNum + "', '" + email + "')");
        }catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
