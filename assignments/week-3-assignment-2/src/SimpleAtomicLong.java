// Import the necessary Java synchronization and scheduling classes.

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;
    
    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
    // TODO - replace the null with the appropriate initialization:
    private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock(); //null;

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue)
    {
        long value = 0;
        // TODO - you fill in here
    	
    	//lock for write
    	mRWLock.writeLock().lock();
    	
    	// write a value 
    	mValue = initialValue;
    	
    	//release the lock
    	mRWLock.writeLock().unlock();
    }

    /**
     * @brief Gets the current value.
     * 
     * @returns The current value
     */
    public long get()
    {
        long value = 0;
        // TODO - you fill in here, using a readLock()
        //lock for reading
    	mRWLock.readLock().lock();
    	
    	value = mValue; 
    	
    	//release the lock
    	mRWLock.readLock().unlock();

    	return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet()
    {
        long value = 0;
        // TODO - you fill in here, using a writeLock()
    	//lock for write
    	mRWLock.writeLock().lock();
    	
    	// the value decrease
    	mValue = mValue - 1;
    	value = mValue;
    	
    	//release the lock
    	mRWLock.writeLock().unlock();
 
    	return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement()
    {
        long value = 0;
        // TODO - you fill in here, using a writeLock()
       	//lock for write
    	mRWLock.writeLock().lock();
    	
    	// the value decrease
    	value = mValue;
    	mValue = mValue + 1;
     	
    	//release the lock
    	mRWLock.writeLock().unlock();
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement()
    {
        long value = 0;
        // TODO - you fill in here, using a writeLock()
      	//lock for write     
        mRWLock.writeLock().lock();
    	
    	// the value decrease
    	value = mValue;
    	mValue = mValue - 1;
     	
    	//release the lock
    	mRWLock.writeLock().unlock();

       return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet()
    {
        long value = 0;
        // TODO - you fill in here, using a writeLock()
      	//lock for write
    	mRWLock.writeLock().lock();
    	
    	// the value decrease
    	mValue = mValue + 1;
    	value = mValue;
     	
    	//release the lock
    	mRWLock.writeLock().unlock();

        return value;
    }
}

