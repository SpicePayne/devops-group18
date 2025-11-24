import java.sql.SQLException;

public class ReportsApp {

    /**
     * Connection to MySQL database.
     */
    private Connection connection = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        ReportsApp  r = new ReportsApp();

        if(args.length < 1){
            r.connect("localhost:33060", 0);
        }else{
            r.connect("db:3306", 30000);
        }

}