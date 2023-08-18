package com.example.bank.controller;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.bank.model.Account;
import com.example.bank.service.AccountService;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAccountById() throws Exception {
        Long accountId = 1L;
        Account account = new Account();
        account.setId(accountId);
        account.setAccountNumber("12345");
        account.setBalance(1000.0);

        given(accountService.getAccountById(accountId)).willReturn(account);

        mockMvc.perform(get("/accounts/{id}", accountId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(accountId.intValue())))
                .andExpect(jsonPath("$.accountNumber", is("12345")))
                .andExpect(jsonPath("$.balance", is(1000.0)));
    }

    // Add more test methods for other controller endpoints
}
