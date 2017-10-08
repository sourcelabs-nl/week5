package nl.sourcelabs.se.week5.tueday.assignment1;

import java.sql.SQLException;

public interface BankingRepository {

    public void saveAccount(final Account account) throws SQLException;
    
    public Account findAccount(final String accountname) throws SQLException;
    
}
