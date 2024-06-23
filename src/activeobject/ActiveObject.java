package activeobject;

import java.util.concurrent.Future;

public interface ActiveObject {
    Result<String> makeString(int count, char filler);
    void displayString(String s);
}
