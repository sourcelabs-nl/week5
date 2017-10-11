package nl.sourcelabs.se.week5.tuesday.assignment2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankingServiceTest {

    @InjectMocks
    private BankingService bankingService;

    @Mock
    private BankingRepository bankingRepository;

    @Mock
    private Account account;

    @Test
    public void testFindAccount() throws SQLException {
        when(account.getBalance()).thenReturn(1000);
        when(bankingRepository.findAccount("NUMBER1")).thenReturn(account);

        final Account found = bankingService.find("NUMBER1");

        assertEquals(account, found);

        System.out.println(account.getBalance());
    }

    @Test(expected = SQLException.class)
    public void testFindAccountError() throws SQLException {
        when(bankingRepository.findAccount("NUMBER1")).thenThrow(SQLException.class);

        final Account found = bankingService.find("NUMBER1");
    }

    @Test
    public void testDepositOk() throws SQLException {
        final Account account = new Account("NUMBER1", true, 100);

        bankingService.deposit(account, 100);

        verify(bankingRepository, times(1)).saveAccount(account);
        assertEquals(200, account.getBalance());
    }

    @Test
    public void testDepositError() throws SQLException {
        final Account account = new Account("NUMBER1", true, 100);

        doThrow(SQLException.class).when(bankingRepository).saveAccount(account);

        bankingService.deposit(account, 100);

        verify(bankingRepository, times(1)).saveAccount(account);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdrawalOk() throws SQLException {
        final Account account = new Account("NUMBER1", true, 100);

        bankingService.withdraw(account, 150);

        verify(bankingRepository, times(1)).saveAccount(account);
        assertEquals(-50, account.getBalance());
    }

    @Test
    public void testWithdrawalError() throws SQLException {
        final Account account = new Account("NUMBER1", true, 100);

        doThrow(SQLException.class).when(bankingRepository).saveAccount(account);

        bankingService.withdraw(account, 150);

        verify(bankingRepository, times(1)).saveAccount(account);
        assertEquals(100, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalNotAllowed() throws SQLException {
        final Account account = new Account("NUMBER1", false, 100);

        doThrow(SQLException.class).when(bankingRepository).saveAccount(account);

        bankingService.withdraw(account, 150);
    }

    @Test
    public void testTransferOk() throws SQLException {
        final Account source = new Account("NUMBER1", false, 100);
        final Account target = new Account("NUMBER2", false, 100);

        bankingService.transferAmount(source, target, 50);

        verify(bankingRepository, times(1)).saveAccount(source);
        verify(bankingRepository, times(1)).saveAccount(target);

        assertEquals(50, source.getBalance());
        assertEquals(150, target.getBalance());
    }

    @Test
    public void testTransferOkNegativeAmount() throws SQLException {
        final Account source = new Account("NUMBER1", true, 100);
        final Account target = new Account("NUMBER2", false, 100);

        bankingService.transferAmount(source, target, 150);

        verify(bankingRepository, times(1)).saveAccount(source);
        verify(bankingRepository, times(1)).saveAccount(target);

        assertEquals(-50, source.getBalance());
        assertEquals(250, target.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferNotOk() throws SQLException {
        final Account source = new Account("NUMBER1", false, 100);
        final Account target = new Account("NUMBER2", false, 100);

        bankingService.transferAmount(source, target, 150);
    }

    @Test
    public void testTransferError() throws SQLException {
        final Account source = new Account("NUMBER1", true, 100);
        final Account target = new Account("NUMBER2", false, 100);

        doThrow(SQLException.class).when(bankingRepository).saveAccount(source);

        bankingService.transferAmount(source, target, 150);

        verify(bankingRepository, times(1)).saveAccount(source);
        verify(bankingRepository, times(0)).saveAccount(target);

        assertEquals(100, source.getBalance());
        assertEquals(100, target.getBalance());
    }

    @Test
    public void testTransferErrorTwo() throws SQLException {
        final Account source = new Account("NUMBER1", true, 100);
        final Account target = new Account("NUMBER2", false, 100);

        doThrow(SQLException.class).when(bankingRepository).saveAccount(target);

        bankingService.transferAmount(source, target, 150);

        verify(bankingRepository, times(1)).saveAccount(source);
        verify(bankingRepository, times(1)).saveAccount(target);

        assertEquals(100, source.getBalance());
        assertEquals(100, target.getBalance());
    }
}