package lesson10.polyexample;

public class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void run() {
        if (name != null) {
            System.out.println("Human class is called...");
            System.out.println(name + " is running");
        }
    }
}
