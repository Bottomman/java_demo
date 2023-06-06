import org.testng.annotations.Test;

import java.util.Scanner;

public class Testdemo {
    @Test
    public void testdemo1() {
        short b1 = 120;
        short b2 = 8;
        byte b3 = (byte) 128;
        System.out.println(b3);

        char c1 = '0';
        char c2 = '1';
        char c3 = (char) (c1 + c2);
        System.out.println(c1 + c2);

        int i = 1;
        i *= 1.9;
        i *= i++;
        System.out.println(i);
        char i1 = 1;
        i1 += 96 + 128 + 128;
        System.out.println(i1);
        i++;
        System.out.println("i=" + i);//i=1

        byte b11 = 10;
        byte b12 = 20;
        byte b13 = (byte) (b1 + b2);

        char ch1 = 68;
        int i11 = 1;
        System.out.println(ch1);

        boolean b111 = (10) % 2 == 0;
        boolean b112 = (11) % 2 == 0;
        boolean b113 = (12) % 2 == 1;
        boolean b114 = (13) % 2 == 1;
        System.out.println("10 偶？" + b111);
        System.out.println("11 偶？" + b112);
        System.out.println("12 奇？" + b113);
        System.out.println("13 奇？" + b114);

        int num = 60;
        int j1 = num & 15;
        String s1 = (j1 > 9) ? (char) (j1 - 10 + 'A') + "" : j1 + "";//取出了最低的4位对应的字符

        int j2 = (num >>> 4) & 15;
        String s2 = (j2 > 9) ? (char) (j2 - 10 + 'A') + "" : j2 + "";//取出了次最低的4位对应的字符

        System.out.println(s2 + s1);

        int num1 = 7;
        System.out.println("num1 << 1 : " + (num1 << 1));//7+8-1
        System.out.println("num1 << 2 : " + (num1 << 2));//7+8+16-1-2-4
        System.out.println("num1 << 3 : " + (num1 << 3));//7+8+16+32-...
        System.out.println("num1 << 28 : " + (num1 << 28));//
        System.out.println("num1 << 29 : " + (num1 << 29));//过犹不及

        int num2 = -7;
        System.out.println("num2 << 1 : " + (num2 << 1));//-14
        System.out.println("num2 << 2 : " + (num2 << 2));//-28
        System.out.println("num2 << 3 : " + (num2 << 3));

        System.out.println(~9);//111111111111111101110
        System.out.println(~-10);//100000000000000010010
        //11111111111111111101101
        //11111111111111111101110
        //00000000000000000010001
        //-9

        //声明num1,num2,num3三个变量并赋值
        int nn1 = 23, nn2 = 32, nn3 = 12;

        if (nn1 >= nn2) {

            if (nn3 >= nn1)
                System.out.println(nn2 + "-" + nn1 + "-" + nn3);
//                System.out.println();
            else if (nn3 <= nn2)
                System.out.println(nn3 + "-" + nn2 + "-" + nn1);
            else
                System.out.println(nn2 + "-" + nn3 + "-" + nn1);
        } else { //nn1 < nn2

            if (nn3 >= nn2) {
                System.out.println(nn1 + "-" + nn2 + "-" + nn3);
            } else if (nn3 <= nn1) {
                System.out.println(nn3 + "-" + nn1 + "-" + nn2);
            } else {
                System.out.println(nn1 + "-" + nn3 + "-" + nn2);
            }
        }

        int x = 4;
        int y = 1;
        if (x > 2) {
            if (y > 2)
                System.out.println(x + y);
            System.out.println("atguigu");
        } else
            System.out.println("x is " + x);

        int num11 = 1;
        switch (num11) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("other");
                //break;
        }

        int score = 11;
		/*
		写法1：极不推荐
		switch(score){
			case 0:
				System.out.println("不及格");
				break;
			case 1:
				System.out.println("不及格");
				break;
			//...

			case 60:
				System.out.println("及格");
				break;
			//...略...

		}
		*/

        //写法2：
        switch (score / 10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("不及格");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("及格");
                break;
            default:
                System.out.println("输入的成绩有误");
                break;
        }

        //写法3：
        switch (score / 60) {
            case 0:
                System.out.println("不及格");
                break;
            case 1:
                System.out.println("及格");
                break;
            default:
                System.out.println("输入的成绩有误");
                break;
        }

        int num111 = 1;
        for (System.out.print("a"); num111 < 3; System.out.print("c"), num111++) {
            System.out.print("b");

        }

        //100以内的偶数及偶数的和
        int count = 0;
        int sum = 0;
        for (i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
//                System.out.println(i);
                count++;
                sum += i;
            }
        }
        System.out.println(count + " " + sum);

    }

    @Test
    public void testDemo2() {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int c = i % 10;
            int b = i / 10 % 10;
            int a = i / 100 % 10;
            if (c * c * c + b * b * b + a * a * a == i) {
                count++;
                System.out.println("第" + count + "个水仙花数：" + i);
            }
        }

        count = 0;
        for (int i = 1000; i < 10000; i++) {
            int a = i / 1000 % 10;
            int b = i / 100 % 10;
            int c = i / 10 % 10;
            int d = i % 10;
            if (a + c == b + d && d % 2 == 0 && a % 2 == 1) {
                count++;
//                System.out.println("第" + count + "个符合的数：" + i);
            }
        }

        //输入两个正整数m和n，求其最大公约数和最小公倍数。
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入m:");
        int m = scan.nextInt();
        System.out.println("请输入n:");
        int n = scan.nextInt();

        //最大公约数
        int min = m < n ? m : n;
        int zdgys = 1;
        for (int i = min; i >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                System.out.println("公约数：" + i);
                zdgys = i;
                break;
            }
        }

        //最小公倍数
        int max = m > n ? m : n;
        int zxgbs = max;
        for (int i = max; i <= m * n; i++) {
            if (i % m == 0 && i % n == 0) {
                System.out.println("公倍数:" + i);
                zxgbs = i;
                break;
            }
        }
        System.out.println("最大公约数：" + zdgys);
        System.out.println("最小公倍数：" + zxgbs);

    }

    //99乘法表
    @Test
    public void testDemo3() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    //打印每分钟
    @Test
    public void testDemo4() {
        for (int i = 0; i <= 23; i++) {
            for (int j = 0; j <= 59; j++) {
                System.out.print(i + "小时" + j + "分钟\t");
            }
            System.out.println();
        }
    }

    //100000以内的质数 约数判断根号以下-110 约数判断一般-384 约数全部判断712 循环定义变量-742 去掉break-7233
    @Test
    public void testDemo5() {
        //定义起始时间、计数器、布尔标志
        long start = System.currentTimeMillis();
        int count = 0;
//        boolean isflag = true;

        //循环2-100000
        for1:
        for (int i = 2; i < 100000; i++) {
//            isflag = true;
            //循环判断2-（i-1）是否为约数
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
//                    System.out.println(Math.sqrt(i) + 1);
//                    isflag = false;
//                    break;
                    continue for1;
                }
            }

//            if (isflag) {
            count++;
//                System.out.println(i);
//            }

        }
//        System.out.println(2 < Math.sqrt(2) + 1);
        long end = System.currentTimeMillis();
        System.out.println("总个数:" + count);
        System.out.println("总共耗时（毫秒）：" + (end - start));

    }

    //三天打鱼，两条晒网
    @Test
    public void testDemo6() {
        //定义输入时间
        Scanner scanner = new Scanner(System.in);
        int select = 1;
        do {
            //获取输入日期
            System.out.println("请输入年份：");
            int year = scanner.nextInt() - 2000;
            System.out.println("请输入月份：");
            int month = scanner.nextInt();
            System.out.println("请输入日期：");
            int day = scanner.nextInt();
            int days;
            int day_m = 0;

            //判断总共多少天，取余确定返回值
            //days = year*365+year/4-year/100+month(m-1)+day
            for (int i = 1; i < month; i++) {
                if (i == 4 || i == 6 || i == 9 || i == 11) {
                    day_m += 30;
                } else if (i == 2) {
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        day_m += 29;
                    } else {
                        day_m += 28;
                    }
                } else {
                    day_m += 31;
                }
            }
            int day_y = year * 365 + year / 4 - year / 100;
            days = day_y + day_m + day;
            int day_r = days % 5;
            switch (day_r) {
                case 1:
                case 2:
                case 3:
                    System.out.println(days);
                    System.out.println("今天该打鱼啦~");
                    break;
                case 4:
                case 0:
                    System.out.println(days);
                    System.out.println("今天该晒网啦~");
                    break;
                default:
                    System.out.println("输入错误！");
            }

            System.out.println("选择是否继续：");
            select = scanner.nextInt();
        } while (select != 0);

    }

    //1000以内的完数
    @Test
    public void testDemo7() {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                count++;
                System.out.println("完数：" + i);
            }
            sum = 0;
        }
        System.out.println("总共" + count + "个完数");
    }

    //100大洋买鸡
    @Test
    public void testDemo8() {
//        int a = 0, b = 0, c = 0;
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 33; j++) {
                for (int k = 0; k <= 100; k++) {
                    if (i * 5 + j * 3 + k == 100) {
                        System.out.println("本次买" + i + "只a鸡，" + j + "只b鸡，" + 3 * k + "只c鸡；");
                    }
                }
            }
        }
        test("Thread1");
        test("Thread2");
    }

    public static void test(String threadName) {
        new Thread(
                () -> System.out.println(Thread.currentThread().getName()),
                threadName
        ).start();
    }

    @Test
    public void testDemo9() {
        //存储26个字母
        char[] letters = new char[26];
        System.out.println("letters数组的长度：" + letters.length);
        System.out.print("存储字母到letters数组之前：[");
        for (int i = 0; i < letters.length; i++) {
            letters[i] = (char) ('a' + i);
            if (i == 0) {
                System.out.print(letters[i]);
            } else {
                System.out.print("," + letters[i]);
            }
        }
        System.out.println("]");

        //存储5个姓名
        String[] names = new String[5];
        System.out.println("names数组的长度：" + names.length);
        System.out.print("存储姓名到names数组之前：[");
        for (int i = 0; i < names.length; i++) {
            if (i == 0) {
                System.out.print(names[i]);
            } else {
                System.out.print("," + names[i]);
            }
        }
        System.out.println("]");
    }

    //输出矩阵
    @Test
    public void testDemo10() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵宽度：");
        int len = scanner.nextInt();
        int all = len * len;
        int[][] arr = new int[len][len];

        //循环写入二维数组
        int k = 1;//1-向右；2-向下；3-向左；4-向上
        int x = 0, y = 0;
        for (int i = 0; i < all - 1; i++) {
            if (k == 1) {
                if (x < len && arr[x][y] == 0) {
                    arr[y][x++] = i;
                } else {
                    k = 2;
                    x--;
                    y++;
                }
            } else if (k == 2) {

            }
        }
    }
}


interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {

    public void pX() {
        System.out.println(super.x);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}

interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");

}

class Ball implements Rollable {
    private final String name;

    public String getName() {
        return name;
    }

    public Ball(String name) {
        this.name = name;
    }

    public void play() {
        //ball = new Ball("Football");
        System.out.println(ball.getName());
    }
}

interface CompareObject {
    //比较大小
    int compareTo(Object o);
}

class ComparableCircle extends Circle implements CompareObject {

    ComparableCircle(double radius, String color, double weight) {
        super(radius, color, weight);
    }

    public int compareTo(Object o) {
        ComparableCircle circle = (ComparableCircle) o;
        if (getRadius() == circle.getRadius()) {
            return 0;
        } else if (getRadius() > circle.getRadius()) {
            return 1;
        } else return -1;
    }
}

class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle circle = new ComparableCircle(1, "", 0);
        ComparableCircle circle1 = new ComparableCircle(2, "", 0);

        System.out.println(circle1.compareTo(circle));
    }
}

class Developer {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void takeVehicle(Vehicle vehicle) {
        vehicle.run();
    }

    ;
}

abstract class Vehicle {
    private String brand;
    private String color;

    public Vehicle() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void run();

}

class Bicycle extends Vehicle {

    public Bicycle(String brand, String color) {
        setBrand(brand);
        setColor(color);
    }

    @Override
    public void run() {
        System.out.println("我是自行车，全靠人力" + getBrand() + getColor());
    }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String brand, String color) {
        setBrand(brand);
        setColor(color);
    }

    public void run() {
        System.out.println("我是能源车，我的动力是电能" + getBrand() + getColor());
    }
}

class Car extends Vehicle {
    private String carNumber;

    public Car(String brand, String color, String carNumber) {
        this.carNumber = carNumber;
        setBrand(brand);
        setColor(color);
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("我是机动车，动力是汽油" + getBrand() + getColor() + getCarNumber());
    }
}

class VehicleTest {
    public static void main(String[] args) {
        Developer developer = new Developer();
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Bicycle("捷安特", "蓝");
        vehicles[1] = new ElectricVehicle("特斯拉", "黑");
        vehicles[2] = new Car("保时捷", "白", "88888");

        for (Vehicle vehicle : vehicles) {
            developer.takeVehicle(vehicle);
        }
    }
}