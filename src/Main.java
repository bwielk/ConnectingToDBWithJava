import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Blazej W\\IdeaProjects\\TestDB\\test.db");
        }catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
