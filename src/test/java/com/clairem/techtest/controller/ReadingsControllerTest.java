package com.clairem.techtest.controller;

import com.clairem.techtest.model.Account;
import com.clairem.techtest.service.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReadingsController.class)
@AutoConfigureMockMvc
public class ReadingsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    AccountRepository accountRepository;
    List<Account> accounts = new ArrayList<>();
    @Before
    public void setUp() throws Exception {

        Account account = new Account(1, 1, 100, 10000, LocalDate.now());
        accountRepository.save(account);
        accounts.add(account);
    }

    @Test
    public void get_AccountID_by_ID() throws Exception {
        when(accountRepository.findByAccountId(1)).thenReturn(accounts);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/smart/reads/{accountId}", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string("[{\"accountId\":1,\"id\":1,\"meterId\":100,\"reading\":10000,\"date\":[2022,9,16]}]"))
                .andExpect(status().isOk());
    }

    @Test
    public void retreiveNothingByID() throws Exception {
        when(accountRepository.findByAccountId(2)).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/smart/reads/{accountId}", 2)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn().getResponse();

    }

}
