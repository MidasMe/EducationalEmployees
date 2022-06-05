

import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);

    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Stream<Employee> stream = staff.stream();
        return staff.stream()
                .filter(e -> e.getWorkStart().getYear() == year - 1900)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }
}