import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "glory", "myPassword");


    static String connectionString = "jdbc:postgresql://ec2-35-173-114-25.compute-1.amazonaws.com:5432/d36ju5uho7ifrd";
//    public static Sql2o sql2o = new Sql2o(connectionString,"cqakpyxyhxrhdr", "73858a622af42b1124feccec1ce43cb27cbb1b8fa1cc1a3dcdd98045e7c535ab");
}
