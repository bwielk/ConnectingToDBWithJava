import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Blazej W\\IdeaProjects\\TestDB\\test.db");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE contacts(name TEXT, phone INTEGER, email TEXT)");
            statement.close();
            connection.close();
        }catch(SQLException e) {
            System.out.println(e);
        }
    }
}
