package demo;

import entity.oneToMany.Department;
import entity.oneToMany.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Demo5 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*Employee employee = new Employee();
        Employee employee1 = new Employee();

        employee.setName("Michel");
        employee1.setName("Patrick");

        Department department = new Department();
        department.setDepName("Comptable");

        employee.setDepartment(department);
        employee1.setDepartment(department);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);

        department.setEmployees(employees);

        em.persist(department);

        em.getTransaction().commit();*/

        Department department1 = em.find(Department.class, 1L);
        /*for (Employee e : department1.getEmployees()){
            System.out.println("Employee : " + e);
        }*/
        System.out.println(department1);

        em.close();
        emf.close();
    }

}
