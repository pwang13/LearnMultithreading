package activeobject;

public abstract class MethodRequest<T> {
    protected final FutureResult<T> result;
    protected final ActiveObject activeObject;

    public MethodRequest(FutureResult<T> result, ActiveObject activeObject) {
        this.result = result;
        this.activeObject = activeObject;
    }

    abstract void execute();
}
