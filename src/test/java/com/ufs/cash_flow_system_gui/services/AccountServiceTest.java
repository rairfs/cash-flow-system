// src/test/java/com/ufs/cash_flow_system_gui/services/AccountServiceTest.java
package com.ufs.cash_flow_system_gui.services;

import com.ufs.cash_flow_system_gui.models.Account;
import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.models.Report;
import com.ufs.cash_flow_system_gui.persistence.AccountsPersistence;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Test
    void testGetAccountByName_returnsAccount() {
        Account account = Mockito.mock(Account.class);

        try (MockedStatic<AccountsPersistence> mocked = Mockito.mockStatic(AccountsPersistence.class)) {
            mocked.when(() -> AccountsPersistence.getAccountByClientName("Alice")).thenReturn(account);

            AccountService service = new AccountService();
            Account result = service.getAccountByName("Alice");

            assertSame(account, result);
            mocked.verify(() -> AccountsPersistence.getAccountByClientName("Alice"), times(1));
        }
    }

    @Test
    void testCreateAccount_callsAddAccount() {
        Client client = Mockito.mock(Client.class);

        try (MockedStatic<AccountsPersistence> mocked = Mockito.mockStatic(AccountsPersistence.class)) {
            AccountService service = new AccountService();
            service.createAccount(client);

            mocked.verify(() -> AccountsPersistence.addAccount(Mockito.any(Account.class)), times(1));
        }
    }

    @Test
    void testGetAccountBalance_byName_returnsBalanceWhenAccountExists() {
        Account account = Mockito.mock(Account.class);
        when(account.getBalance()).thenReturn(150.0);

        try (MockedStatic<AccountsPersistence> mocked = Mockito.mockStatic(AccountsPersistence.class)) {
            mocked.when(() -> AccountsPersistence.getAccountByClientName("Bob")).thenReturn(account);

            AccountService service = new AccountService();
            Double balance = service.getAccountBalance("Bob");

            assertNotNull(balance);
            assertEquals(150.0, balance);
        }
    }

    @Test
    void testGetAccountBalance_byClient_returnsBalanceWhenAccountExists() {
        Account account = Mockito.mock(Account.class);
        when(account.getBalance()).thenReturn(75.5);

        Client client = Mockito.mock(Client.class);
        when(client.getAccount()).thenReturn(account);

        AccountService service = new AccountService();
        Double balance = service.getAccountBalance(client);

        assertNotNull(balance);
        assertEquals(75.5, balance);
    }

    @Test
    void testDeposit_updatesBalanceAndAddsReportAndCallsUpdate() {
        Account account = Mockito.mock(Account.class);
        when(account.getBalance()).thenReturn(100.0);
        List<Report> tx = new ArrayList<>();
        when(account.getTransactionHistory()).thenReturn(tx);

        try (MockedStatic<AccountsPersistence> mocked = Mockito.mockStatic(AccountsPersistence.class)) {
            AccountService service = new AccountService();
            service.deposit(account, 50.0);

            // verifica que setBalance foi chamado com 150.0
            Mockito.verify(account, times(1)).setBalance(150.0);
            // verifica que um relatório foi adicionado ao histórico
            assertEquals(1, tx.size());
            assertTrue(tx.get(0) instanceof Report);
            mocked.verify(() -> AccountsPersistence.updateAccount(account), times(1));
        }
    }

    @Test
    void testWithdraw_success_updatesAndReturnsTrue() {
        Account account = Mockito.mock(Account.class);
        when(account.getBalance()).thenReturn(200.0);
        List<Report> tx = new ArrayList<>();
        when(account.getTransactionHistory()).thenReturn(tx);

        try (MockedStatic<AccountsPersistence> mocked = Mockito.mockStatic(AccountsPersistence.class)) {
            AccountService service = new AccountService();
            boolean result = service.withdraw(account, 50.0);

            assertTrue(result);
            Mockito.verify(account, times(1)).setBalance(150.0);
            assertEquals(1, tx.size());
            assertTrue(tx.get(0) instanceof Report);
            mocked.verify(() -> AccountsPersistence.updateAccount(account), times(1));
        }
    }

    @Test
    void testWithdraw_insufficientFunds_returnsFalseAndNoUpdate() {
        Account account = Mockito.mock(Account.class);
        when(account.getBalance()).thenReturn(30.0);
        List<Report> tx = new ArrayList<>();
        when(account.getTransactionHistory()).thenReturn(tx);

        try (MockedStatic<AccountsPersistence> mocked = Mockito.mockStatic(AccountsPersistence.class)) {
            AccountService service = new AccountService();
            boolean result = service.withdraw(account, 50.0);

            assertFalse(result);
            Mockito.verify(account, times(0)).setBalance(Mockito.anyDouble());
            assertEquals(0, tx.size());
            mocked.verify(() -> AccountsPersistence.updateAccount(account), times(0));
        }
    }

    @Test
    void testGetTransactionHistory_returnsList() {
        List<Report> tx = new ArrayList<>();
        tx.add(new Report(10.0));

        Account account = Mockito.mock(Account.class);
        when(account.getTransactionHistory()).thenReturn(tx);

        AccountService service = new AccountService();
        List<Report> result = service.getTransactionHistory(account);

        assertSame(tx, result);
        assertEquals(1, result.size());
    }
}
