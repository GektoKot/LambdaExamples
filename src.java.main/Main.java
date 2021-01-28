
public class Main {
    public static void main(String[] args) {
        FunctionalInterface fi;
        fi = n -> n * 5;
        System.out.println(fi.getValue(5));
    }
}
