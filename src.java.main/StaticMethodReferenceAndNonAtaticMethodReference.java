interface FunctionalInterfaceOneParamString {
    String reverse(String str);
}

class StringReverser {
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public String reverseStringNonStatic(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
public class StaticMethodReferenceAndNonAtaticMethodReference {

    public static String stringFunc(FunctionalInterfaceOneParamString fiops, String str) {
        return fiops.reverse(str);
    }

    public static void main(String[] args) {
        String reversStr = stringFunc(StringReverser::reverseString, "qwerty");
        System.out.println(reversStr);
        StringReverser sr = new StringReverser();
        reversStr = stringFunc(sr::reverseStringNonStatic, "asdfg");
        System.out.println(reversStr);
    }


}
