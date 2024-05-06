package appstart.mymodappdemo;
import appfuncs.simplefuncs.SimpleMathFuncs;
public class MyModAppDemo {
    public static void main(String[] args) {
        if(SimpleMathFuncs.isFactor(2,10))
            System.out.println("2 - делитель 10");
        System.out.println(SimpleMathFuncs.lcf(35, 105));
        System.out.println(SimpleMathFuncs.gcf(35, 105));
    }
}
