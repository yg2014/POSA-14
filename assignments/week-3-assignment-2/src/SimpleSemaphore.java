import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

/**
 * @class SimpleSemaphore
 *
 * @brief This class provides a simple counting semaphore
 *        implementation using Java a ReentrantLock and a
 *        ConditionObject.  It must implement both "Fair" and
 *        "NonFair" semaphore semantics, just liked Java Semaphores. 
 */
public class SimpleSemaphore {
    /**
     * Constructor initialize the data members.  
     */
    public SimpleSemaphore (int permits, boolean fair)
    { 
        // TODO - you fill in here
        iPermits = permits;
        lock = new ReentrantLock(fair);
        ConditionIsZero = lock.newCondition();
    }

    /**
     * Acquire one permit from the semaphore in a manner that can
     * be interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here
        lock.lock();
        while (iPermits == 0)
        	ConditionIsZero.await();
        iPermits--;
        lock.unlock();
    }

    /**
     * Acquire one permit from the semaphore in a manner that
     * cannot be interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here
        lock.lock();
        while (iPermits == 0)
            try {
            	ConditionIsZero.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        iPermits--;
        lock.unlock();

    }

    /**
     * Return one permit to the semaphore.
     */
    void release() {
        // TODO - you fill in here
        lock.lock();
        try {
            iPermits++;
            ConditionIsZero.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Define a ReentrantLock to protect the critical section.
     */
    // TODO - you fill in here
    private ReentrantLock lock;

    /**
     * Define a ConditionObject to wait while the number of
     * permits is 0.
     */
    // TODO - you fill in here
    private Condition ConditionIsZero;

    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here
 	private int iPermits;
}

