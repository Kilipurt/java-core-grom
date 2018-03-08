package lesson4;

public class StringConcat {
    public static void main(String[] args) {
        System.out.println(concat("I ", "like ", "it"));
    }

    public static String concat(String string1, String string2, String string3){
        return (string1 + string2 + string3);
    }
}
