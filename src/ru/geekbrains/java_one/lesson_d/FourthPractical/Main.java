package ru.geekbrains.java_one.lesson_d.FourthPractical;

public class Main {
    public static void main(String[] args){
//        Staff e1 = new Staff("Ivan Alexandrovich Petrov", 55000, 48);
//        System.out.println("Name: " + e1.getFio() + ", age:" + e1.getAge());

        Staff[] employees = new Staff[] {
                new Staff("Roman Ivanovich Semenov", 28000, 29),
                new Staff("Petr Sergeevich Frolov", 38000, 38),
                new Staff("Galina Ivanovna Bondarenko", 40000, 53),
                new Staff("Denis Evgenievich Lyamin", 75000, 25),
                new Staff("Ivan Nikolaevich Shaligin", 82000, 31)
        };
        for (Staff value : employees) {
            if (value.getAge() > 40) {
                System.out.println("Name: " + value.getFio() + ", salary: " + value.getSalary() +
                        ", age:" + value.getAge());
            }
        }
        Staff.increaseSalary();
        Staff[] employeesArr = Staff.getEmployeesArr();
        for (Staff staff : employeesArr) {
            System.out.println("Name: " + staff.getFio() + ", salary: " + staff.getSalary() +
                    ", age:" + staff.getAge());
        }
        System.out.println("Employee's average age: " + Staff.getAverageAge(employees));
        System.out.println("Average salary: " + Staff.getAverageSalary(employees));

            for (Staff employee : employees) {
                System.out.println(employee.getId());
            }
    }
}