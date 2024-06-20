package activeobject;

public interface ActiveObject {
    Result<String> makeString(int count, char filler);
    void displayString(String s);
}
