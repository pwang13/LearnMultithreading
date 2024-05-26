package sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("before");
        Sleep.sleep(1000);
        System.out.println("after");
    }
}
