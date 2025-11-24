import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public static void main(String[] args) {
    // Create new Application and connect to database
    App a = new App();

    if(args.length < 1){
        a.connect("localhost:33060", 30000);
    }else{
        a.connect(args[0], Integer.parseInt(args[1]));
    }

    Department dept = a.getDepartment("Development");
    ArrayList<Employee> employees = a.getSalariesByDepartment(dept);


    // Print salary report
    a.printSalaries(employees);

    // Disconnect from database
    a.disconnect();
}