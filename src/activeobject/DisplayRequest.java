package activeobject;

public class DisplayRequest extends MethodRequest<Object> {
    private final String s;
    private final ActiveObject activeObject;

    public DisplayRequest(String s, ActiveObject activeObject) {
        super(null, activeObject);
        this.activeObject = activeObject;
        this.s = s;
    }

    @Override
    public void execute() {
        activeObject.displayString(s);
    }
}
