package activeobject;

public class Server implements ActiveObject {
    @Override
    public Result<String> makeString(int count, char filler) {
        char[] c = new char[count];
        for (int i = 0; i < count; i++) {
            c[i] = filler;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Result<String> result = new Result<>();
        result.setResult(new String(c));
        return result;
    }

    @Override
    public void displayString(String s) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);
    }
}
