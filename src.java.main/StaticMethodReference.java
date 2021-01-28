/**
 * TODO: add documentation
 */
class StringReverser {
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
public class StaticMethodReference {

    public static String stringFunc(FunctionalInterfaceOneParamString fiops, String str) {
        return fiops.reverse(str);
    }

    public static void main(String[] args) {
        String reversStr = stringFunc(StringReverser::reverseString, "qwerty");
        System.out.println(reversStr);
    }


}
