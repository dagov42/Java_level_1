package ru.geekbrains.java_one.lesson_d.FourthPractical;
        /* 1.Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст; Done!
           2.Конструктор класса должен заполнять эти поля при создании объекта;
           3.Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
           4.Вывести при помощи методов из пункта 3 ФИО и возраст.
           5.Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
           6.* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
           7.* Подсчитать средние арифметические зарплаты и возраста
           8.*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался
            личный уникальный идентификационный порядковый номер.
 */

public class Staff {
    private String fio;
    private int salary;
    private int age;
    private int id;
    private static Staff[] employeesArr = new Staff[5];
    private static int index = 0;

    Staff(String fio, int salary, int age){
        this.id = index++;
        this.fio = fio;
        this.salary = salary;
        this.age = age;
        employeesArr[id] = this;
    }
    public String getFio(){
        return fio;
    }
    public int getSalary(){
        return salary;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return this.id;
    }
    public static Staff[] getEmployeesArr() {
        return employeesArr;
    }
    public static void increaseSalary() {
        for (Staff staff : employeesArr) {
            if (staff.getAge() > 45)
                staff.salary += 5000;
        }
    }
    public static float getAverageAge(Staff[] employeesList){
        int averageAge = 0;

        for (Staff staff : employeesList) averageAge += staff.getAge();

        return averageAge/(float)employeesList.length;
    }
    public static float getAverageSalary(Staff[] employeesList){
        float avgSalary = 0;
        for (Staff staff : employeesList) {
            avgSalary += staff.getSalary();
        }
        avgSalary /= employeesList.length;
        return avgSalary;
    }
}
