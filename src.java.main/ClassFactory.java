interface FactoryInterface<R, T> {
    R func(T t);
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
    static <R,T> R dummyClassFactory(FactoryInterface<R,T> func, T t) {
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

    }
}
