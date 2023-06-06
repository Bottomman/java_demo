package org.example;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * ClassName: Exercise
 * Package: org.example
 * Description:
 *
 * @Author 段亚龙
 * @Create 2023/4/20 22:24
 * @Version 1.0
 */

public class Exercise {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("李聪豪");
        employees[1] = new SalaryEmployee("杨晓航", 3000, new MyDate(1997, 5, 27));
        employees[2] = new HourEmployee("陈彤", 20, 8);
        employees[3] = new Manager("王晓豪", 8000, 1997, 5, 1, 0.3);
        employees[4] = new Manager("林巧", 12000, 1996, 4, 7, 0.3);

        double grossSalary = 0;
        try {
            for (Employee employee : employees) {
                System.out.println(employee.getInfo());
                grossSalary += employee.earning();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("grossSalary:" + grossSalary);
            System.out.println("通知财务准备工资，必须大于" + grossSalary);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入月份:");
        int month = scanner.nextInt();
        String nameList = "";

        for (Employee employee : employees) {
            if (employee.getClass() == SalaryEmployee.class || employee.getClass() == Manager.class) {
                if (((SalaryEmployee) employee).getMyDate().getMonth() == month) {
                    nameList += employee.getName() + "、";
                }
            }
        }
        System.out.println("请" + nameList.substring(0, nameList.length() - 1) + "来领取生日礼物");

        int currentMonth = LocalDate.now().getMonthValue();
        for (Employee employee : employees) {
            if (employee.getClass() == SalaryEmployee.class || employee.getClass() == Manager.class) {
                if (((SalaryEmployee) employee).getMyDate().getMonth() == currentMonth) {
                    System.out.println("请" + employee.getName().substring(0, 1) + "先生来领取生日礼物");
                }
            }
        }
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double earning() {
        return 0.0;
    }

    public String getInfo() {
        return "name:" + name + ", salary:" + earning();
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getInfo() {
        return year + "年" + month + "月" + day + "日";
    }
}

class SalaryEmployee extends Employee {
    private double salary;
    private MyDate myDate;

    public SalaryEmployee(String name, double salary, MyDate birthday) {
        super(name);
        this.salary = salary;
        this.myDate = birthday;
    }

    public SalaryEmployee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.myDate = new MyDate(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    @Override
    public double earning() {
        return salary;
    }

    @Override
    public String getInfo() {
        return "name:" + getName() + ", salary:" + earning() + ", birthday:" + myDate.getInfo();
    }
}

class HourEmployee extends Employee {
    double hours;
    double hourlyWage;

    public HourEmployee(String name, double hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public HourEmployee(String name, double hourlyWage, double hours) {
        super(name);
        this.hourlyWage = hourlyWage;
        this.hours = hours;
    }

    @Override
    public double earning() {
        return hours * hourlyWage * LocalDate.now().lengthOfMonth();
    }

    @Override
    public String getInfo() {
        return "name:" + getName() + ", salary:" + earning() + ", hourlyWage:" + hourlyWage + ", hours:" + hours;
    }
}

class Manager extends SalaryEmployee {
    private double bonusRate;

    public Manager(String name, double salary, MyDate birthday, double bonusRate) {
        super(name, salary, birthday);
        this.bonusRate = bonusRate;
    }

    public Manager(String name, double salary, int year, int month, int day, double bonusRate) {
        super(name, salary, year, month, day);
        this.bonusRate = bonusRate;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    @Override
    public double earning() {
        return super.earning() * (1 + bonusRate);
    }

    @Override
    public String getInfo() {
        return "name:" + getName() + ", salary:" + earning() + ", birthday:" + getMyDate().getInfo() + ", bonusRate:" + bonusRate;
    }
}