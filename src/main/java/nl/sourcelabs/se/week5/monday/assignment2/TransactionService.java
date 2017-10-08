package nl.sourcelabs.se.week5.monday.assignment2;

/**
 * Transactionservice - Enforces business logic for transactions and handles
 * interactions with the transactionrepository.
 */
public class TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService(final TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Adds a transaction to the repository, but first checks if it is a valid transaction.
     *
     * @param transaction
     *         the transaction to add
     * @throws IllegalArgumentException
     *         if the transaction is not valid, we can't store it.
     */
    public void addTransaction(final Transaction transaction) {
        if (transaction.isValid()) {
            transactionRepository.add(transaction);
        } else {
            throw new IllegalArgumentException("Invalid transaction");
        }
    }

    /**
     * Finds a transaction in the repository, and returns it.
     *
     * @param id
     *         the id of the transaction to find
     * @return the found transaction
     */
    public Transaction findTransaction(final long id) {
        return transactionRepository.find(id);
    }
}
