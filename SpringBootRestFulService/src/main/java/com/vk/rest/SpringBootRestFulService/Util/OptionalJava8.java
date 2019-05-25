package com.vk.rest.SpringBootRestFulService.Util;

import com.vk.rest.SpringBootRestFulService.Beans.Employee;
import jdk.nashorn.internal.objects.annotations.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Stream;

public class OptionalJava8 {

    public static void main(String[] args) {
        try {


            Optional<String> name = Optional.ofNullable(null);
            System.out.println(name.orElseGet(() -> "kannan"));
            System.out.println(name.isPresent());
            Optional<Employee> employee = Optional.of(new Employee("Vinoth", "kannan", "15244"));
            Optional<Employee> employee1 = Optional.empty();
            employee1 = Optional.of(new Employee());
            System.out.println(employee.get().toString());
            System.out.println("employee " + employee);
            System.out.println("emloyee 1 " + employee1);
            employee1.get().setFirstName("Prasanth");
            Employee actualEmployee = employee.get();
            System.out.println("Printing actual employee "+actualEmployee.toString());
            System.out.println(employee.get().toString());

            List<Optional<Employee>> employeeList = new ArrayList<>();
            employeeList.add(employee);
            employeeList.add(employee1);
            Optional<List<Optional<Employee>>> optionalEmployeeList = Optional.of(employeeList);
           /* Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .findFirst();

            assertEquals(getHello(), found);
*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
