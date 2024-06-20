package activeobject;

public class ActiveObjectProxy implements ActiveObject {
    private final SchedulerThread schedulerThread;
    private final Server server;

    public ActiveObjectProxy(SchedulerThread schedulerThread, Server server) {
        this.schedulerThread = schedulerThread;
        this.server = server;
    }

    @Override
    public Result<String> makeString(int count, char filler) {
        FutureResult<String> result = new FutureResult<>();
        MakerRequest makerRequest = new MakerRequest(count, filler, server, result);
        try {
            schedulerThread.putRequest(makerRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void displayString(String s) {
        DisplayRequest displayRequest = new DisplayRequest(s, server);
        try {
            schedulerThread.putRequest(displayRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
