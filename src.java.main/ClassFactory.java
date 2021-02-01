interface FactoryInterface<R, T> {
    R func(T t);
}

interface FactoryInterfaceArray<T> {
    T func(int i);
}

class DummyClassGeneric<T> {
    private T val;

    public DummyClassGeneric(T val) {
        this.val = val;
    }

    public DummyClassGeneric() {
    }

    public T getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "DummyClassGeneric{" +
                "val=" + val +
                '}';
    }
}

class DummyClass {
    private String val;

    public DummyClass(String val) {
        this.val = val;
    }

    public DummyClass() {
    }

    public String getVal() {
        return val;
    }
}

public class ClassFactory {
    static <R, T> R dummyClassFactory(FactoryInterface<R, T> func, T t) {
        return func.func(t);
    }

    public static void main(String[] args) {
        FactoryInterface<DummyClassGeneric<Double>, Double> fig = DummyClassGeneric::new;
//        FactoryInterface<DummyClassGeneric<Double>, Double> fig = val -> new DummyClassGeneric<Double>(val);
        DummyClassGeneric<Double> dcg = dummyClassFactory(fig, 55.5);
        System.out.println(dcg.getVal());
        FactoryInterface<DummyClass, String> fi = DummyClass::new;
//        FactoryInterface<DummyClass, String> fi = val -> new DummyClass(val);
        DummyClass dc = dummyClassFactory(fi, "ololololo");
        System.out.println(dc.getVal());
        ////////////////
        FactoryInterfaceArray<DummyClassGeneric<String>[]> fia = DummyClassGeneric[]::new;
        DummyClassGeneric<String>[] arr = fia.func(5);
        arr[0] = new DummyClassGeneric<>("qwer");
        arr[1] = new DummyClassGeneric<>("qwer");
        arr[2] = new DummyClassGeneric<>("qwer");
        arr[3] = new DummyClassGeneric<>("qwer");
        arr[4] = new DummyClassGeneric<>("qwer");
        for (DummyClassGeneric<String> dcgElement : arr) {
            System.out.println(dcgElement.toString());
        }


    }
}
