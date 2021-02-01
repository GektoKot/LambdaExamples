import java.util.function.*;

public class Main {
    static int staticInt = 0;

    public static String methodWithLambda(FunctionalInterfaceGeneric<String> fig, String str) {
     return fig.function(str);
    }

    public static void main(String[] args)  {

        FunctionalInterfaceOneParam fi;
        FunctionalInterfaceOneParam fi1;
        fi = n -> n * 5;
        fi1 = n -> n + 5;
        System.out.println(fi.getValue(10));
        System.out.println(fi1.getValue(5));
        ////////////////
        FunctionalInterfaceTwoParam fitp;
        fitp = (a, b) -> (a % b) == 0;
        System.out.println(fitp.multiplayerOrNot(fi.getValue(10), fi1.getValue(5)));
        ////////////////
        FunctionalInterfaceOneParam fiWithBlock;
        fiWithBlock = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println(fiWithBlock.getValue(5));
        ////////////////
        FunctionalInterfaceOneParamString fiops;
        fiops = str -> {
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        };
        System.out.println(fiops.reverse("sosip"));
        ////////////////
        FunctionalInterfaceGeneric<Integer> figInt;
        FunctionalInterfaceGeneric<String> figStr;
        figInt = integer -> integer * 20;
        System.out.println(figInt.function(10));
        figStr = s -> {
            StringBuilder sb = new StringBuilder(s);
            return sb.reverse().toString();
        };
        System.out.println(figStr.function("abvgd"));
        ////////////////
        System.out.println(methodWithLambda(str -> {
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        }, "АбыРВалГ"));
        ////////////////
        Double[] val = new Double []{1d,1d,2d,3d,6d,4d};
        Double[] val0 = new Double [0];
        FunctionalInterfaceGenericArr<Double> figarr = (arr) -> {
            if (arr.length == 0) {
                throw new EmptyArrayException();
            }
            Double res = 0d;
            for(Double d : arr){
                res += d;
            }
            return res;
        };
        try {
            System.out.println(figarr.func(val));
            System.out.println(figarr.func(val0));
        } catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
        }
        ////////////
        int num = 10;
        FunctionalInterfaceOneParam fiop1 = n -> {
            n += num;
            staticInt = 10;
//            num++; Нельзя менять локальные переменные таким макаром!
            return n;
        };
        /////////////
        Function<Integer, Integer> function = integer -> {
            int res = 1;
            for (int i = 1; i <= integer; i++) {
                res *= i;
            }
            return res;
        };
        System.out.println(function.apply(5));

    }
}
