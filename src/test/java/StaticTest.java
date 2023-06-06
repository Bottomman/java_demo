/**
 * ClassName: fa
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 段亚龙
 * @Create 2023/4/25 23:02
 * @Version 1.0
 */
public class StaticTest {
    public static void main(String[] args) {
        Demo test = null;
        test.hello();
    }
}

class Demo{
    public static void hello(){
        System.out.println("hello!");
    }
}