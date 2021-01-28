interface FunctionalInterfaceTwoParamsGeneric<T> {
    boolean func(T t1, T t2);
}

class HighTemp {
    private int hTemp;

    HighTemp(int t) {
        this.hTemp = t;
    }

    boolean sameTemp(HighTemp hT2) {
        return hTemp == hT2.hTemp;
    }

    boolean LessThan(HighTemp hT2) {
        return hTemp < hT2.hTemp;
    }
}

public class ReferencesOnInstanceMethodsExample {

    static <T> int counter(T[] vals, FunctionalInterfaceTwoParamsGeneric<T> func, T val) {
        int counter = 0;
        for (T t : vals) {
            if (func.func(t, val)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int count = 0;
        HighTemp[] highTemps = new HighTemp[]{
                new HighTemp(15), new HighTemp(20),
                new HighTemp(15), new HighTemp(20),
                new HighTemp(10), new HighTemp(30),
                new HighTemp(5), new HighTemp(40),
                new HighTemp(1), new HighTemp(50)
        };
        count = counter(highTemps, HighTemp::sameTemp, new HighTemp(20));
        System.out.println(count);
        count = counter(highTemps, HighTemp::LessThan, new HighTemp(30));
        System.out.println(count);

    }
}
