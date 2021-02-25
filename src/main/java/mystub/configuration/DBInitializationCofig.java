package mystub.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sergey Shilov
 */
public class DBInitializationCofig {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS stub");
            statement.executeUpdate(
                    "CREATE TABLE stub(" +
                            "ID VARCHAR (100) Primary key, " +
                            "NAME VARCHAR (100))"
            );
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
