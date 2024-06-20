package activeobject;

public class ActiveObjectFactory {
    public static ActiveObject getInstance() {
        Server server = new Server();
        RequestQueue requestQueue = new RequestQueue(5);
        SchedulerThread schedulerThread = new SchedulerThread(requestQueue);
        schedulerThread.start();
        return new ActiveObjectProxy(schedulerThread, server);
    }
}
