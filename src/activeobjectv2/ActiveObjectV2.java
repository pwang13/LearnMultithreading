package activeobjectv2;

import java.util.concurrent.Future;

public interface ActiveObjectV2 {
    Future<String> makeString(int count, char c);

    void displayString(String s);
    void shutdown();
}
