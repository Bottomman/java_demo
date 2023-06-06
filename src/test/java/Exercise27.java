/**
 * ClassName: fgsd
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 段亚龙
 * @Create 2023/4/23 22:54
 * @Version 1.0
 */
public class Exercise27 {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.x);
        f.print();
    }
}
class Father{
    int x = 10;
    public Father(){
        this.print();
        x = 20;
    }
    public void print(){
        System.out.println("Father.x = " + x);
    }
}
class Son extends Father{
    int x = 30;
    public Son(){
        this.print();
        x = 40;
    }
    public void println(){
        System.out.println("Son.x = " + x);
    }
}