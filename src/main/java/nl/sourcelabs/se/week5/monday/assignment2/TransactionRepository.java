package nl.sourcelabs.se.week5.monday.assignment2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

class TransactionRepository {

    private AtomicLong atomicLong = new AtomicLong();
    private ConcurrentHashMap<Long, Transaction> store = new ConcurrentHashMap<Long, Transaction>();

    /**
     * Finds a transaction in the local store.
     *
     * @param id
     *         the id for the transaction to find
     * @return the transaction with the given id
     */
    public Transaction find(final long id) {
        return store.get(id);
    }

    /**
     * Adds a transaction to the local store. Generates an id for the transaction
     * and returns it after inserting.
     *
     * @param transaction
     *         the transaction to insert
     * @return the generated id for the transaction
     */
    public long add(final Transaction transaction) {
        final Transaction toStore = new Transaction(transaction);
        toStore.setId(atomicLong.incrementAndGet());
        store.put(toStore.getId(), toStore);
        return toStore.getId();
    }
}
