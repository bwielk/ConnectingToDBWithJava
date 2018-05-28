import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Blazej W\\IdeaProjects\\TestDB\\test.db");
            connection.setAutoCommit(true);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE contacts");
            statement.execute("CREATE TABLE IF NOT EXISTS contacts(name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                                    " VALUES ('Blaise', '09871223443', 'blaise@blaise.bl')");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                                    " VALUES ('John', '09321231123', 'john@john.jo')");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                                    " VALUES ('Janette', '0923111123', 'janette@jane.ja')");
            statement.execute("INSERT INTO contacts (name, phone, email)" +
                                    " VALUES ('Esther', '01121231123', 'esther@esther.est')");
            statement.close();
            connection.close();
        }catch(SQLException e) {
            System.out.println(e);
        }
    }
}
