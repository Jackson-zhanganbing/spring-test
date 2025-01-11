package com.zab.designpattern.pattern.structure.composite;

/**
 * 组合模式
 *
 * @author zab
 * @date 2024/11/11 23:02
 */
public class Test {
    public static void main(String[] args) {
        Employee CEO = new Employee("张三","CEO", 30000);

        Employee headSales = new Employee("李四","销售部老大", 20000);

        Employee headMarketing = new Employee("王五","市场部老大", 20000);

        Employee clerk1 = new Employee("路人甲","市场部", 10000);
        Employee clerk2 = new Employee("路人乙","市场部", 10000);

        Employee salesExecutive1 = new Employee("员工1","销售部", 10000);
        Employee salesExecutive2 = new Employee("员工2","销售部", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印该组织的所有员工
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
