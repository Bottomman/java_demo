package org.example;

import java.util.Scanner;

/**
 * ClassName: FamilyBill
 * Package: org.example
 * Description:
 *
 * @Author 段亚龙
 * @Create 2023/3/5 17:00
 * @Version 1.0
 */
public class FamilyBill {
    public static void main(String[] args) {
        //变量初始化
        Boolean ifcontinue = true;
        Scanner input = new Scanner(System.in);
        int cmd = 0;
        double amount = 0, balance = 0;
        String describe;
        String billdetails = "";
        int count;
        Boolean reAmount;

        //输出标题
        System.out.println("-------------小林账本--------------");
        System.out.println("           1.收支明细");
        System.out.println("           2.登记收入");
        System.out.println("           3.登记支出");
        System.out.println("           4.退出");
        //处理逻辑
        do {
            //输出提示
            System.out.print("请选择(1-4)：");
            cmd = input.nextInt();
            switch (cmd) {
                case 1:
                    //分类    金额  说明
                    if (billdetails.length() > 0) {
                        System.out.println("分类\t\t账户余额\t\t金额\t\t说明");
                        System.out.println(billdetails);
                        System.out.println("账户余额为：" + balance);
                    } else {
                        System.out.println("尚无记录，请积极填写~");
//                        System.out.println("账户余额为：" + balance);
                    }
                    break;
                case 2:
                    //错误计数器
                    count = 0;
//                    reAmount = false;
                    do {
                        System.out.print("请输入收入金额：");
                        amount = input.nextDouble();
                        //若金额合法，则继续处理；不合法重新输入，有2次错误机会
                        if (amount > 0) {
                            System.out.print("请输入收入说明：");
                            describe = input.next();
                            balance += amount;
                            System.out.println("登记成功，账户余额为：" + balance);
                            billdetails += "收入\t\t" + balance + "\t\t\t" + amount + "\t\t" + describe + "\n";
                            break;
                        } else {
                            count++;
                            System.out.println("金额第" + count + "次输入错误(两次自动退至首页)!");
                            reAmount = count > 1 ? false : true;
                        }
                    } while (reAmount);
                    break;
                case 3:
                    //错误计数器
                    count = 0;
//                    reAmount = false;
                    do {
                        System.out.print("请输入支出金额：");
                        amount = input.nextDouble();
                        //若金额合法，则继续处理；不合法重新输入，有2次错误机会
                        if (amount > 0) {
                            System.out.print("请输入支出说明：");
                            describe = input.next();
                            balance -= amount;
                            System.out.println("登记成功，账户余额为：" + balance);
                            System.out.println(balance > 0 ? "手里有粮，心里不慌~" : "不敢再花了，家里没余粮啦！");
                            billdetails += "支出\t\t" + balance + "\t\t\t" + amount + "\t\t" + describe + "\n";
                            break;
                        } else {
                            count++;
                            System.out.println("金额第" + count + "次输入错误(两次自动退至首页)!");
                            reAmount = count > 1 ? false : true;
                        }
                    } while (reAmount);
                    break;
                case 4:
                    System.out.print("确定退出吗？[Y/N]：");
                    char ifExit = input.next().charAt(0);
                    if (ifExit == 'Y' || ifExit == 'y') {
                        System.out.println("欢迎再次登录~");
                        ifcontinue = false;
                        break;
                    } else if (ifExit == 'N' || ifExit == 'n') {
                        break;
                    }
                default:
                    System.out.print("输入不合法，请重新选择~");
                    break;
            }
        } while (ifcontinue);
    }
}
