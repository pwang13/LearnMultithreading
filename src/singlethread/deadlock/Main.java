package singlethread.deadlock;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Tool fork = new Tool("fork");
        Tool knife = new Tool("knife");
        UserThread alice = new UserThread("alice", fork, knife);
        UserThread bobby = new UserThread("bobby", fork, knife);

        Thread aliceThread = new Thread(alice);
        Thread bobbyThread = new Thread(bobby);

        aliceThread.start();
        bobbyThread.start();


        // deadlock - sequence is different
//        alice = new UserThread("alice", fork, knife);
//        bobby = new UserThread("bobby", knife, fork);
//
//        aliceThread = new Thread(alice);
//        bobbyThread = new Thread(bobby);
//
//        aliceThread.start();
//        bobbyThread.start();

        // another solution: create another object to solve deadlock
        ToolPair toolPair = new ToolPair(fork, knife);
        PairUserThread alicePair = new PairUserThread("alice", toolPair);
        PairUserThread bobbyPair = new PairUserThread("bobby", toolPair);

        new Thread(alicePair).start();
        new Thread(bobbyPair).start();
    }
}
