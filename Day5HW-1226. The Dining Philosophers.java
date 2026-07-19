import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    // One lock for each fork
    private final ReentrantLock[] forks = new ReentrantLock[5];

    // Allow only 4 philosophers to compete for forks simultaneously
    private final Semaphore semaphore = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        semaphore.acquire();

        forks[left].lock();
        forks[right].lock();

        try {
            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putRightFork.run();
            putLeftFork.run();
        } finally {
            forks[right].unlock();
            forks[left].unlock();
            semaphore.release();
        }
    }
}
