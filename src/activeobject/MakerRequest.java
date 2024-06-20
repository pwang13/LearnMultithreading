package activeobject;

public class MakerRequest extends MethodRequest<String> {
    private final int count;
    private final char filler;

    public MakerRequest(int count, char filler, ActiveObject activeObject, FutureResult<String> result) {
        super(result, activeObject);
        this.count = count;
        this.filler = filler;
    }

    @Override
    public void execute() {
        Result<String> s = activeObject.makeString(count, filler);
        result.setResult(s.getResult());
    }
}
