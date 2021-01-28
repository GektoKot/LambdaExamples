interface FI<T> {
    int func(T[] vals, T val);
}

class FC {
    static <T> int count(T[] vals, T val) {
        int counter = 0;

        for (T t : vals) {
            if (t == val) {
                counter++;
            }
        }
        return counter;
    }
}

public class GenericMethodReferencesExample {

    static <T> int counterFunc(FI<T> fi, T[] vals, T val) {
        return fi.func(vals, val);
    }

    public static void main(String[] args) {

        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 1, 3, 5, 7};
        String[] strings = new String[]{"qwer", "qwer", "asdf", "zxcv"};
        int count = 0;
        count = counterFunc(FC::count, integers, 5);
        System.out.println(count);
        count = counterFunc(FC::<String>count, strings, "qwer");
        System.out.println(count);

    }
}
