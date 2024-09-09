package com.yape.codechallenge.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.yape.codechallenge.dto.TransactionResponseDto;
import com.yape.codechallenge.model.Transaction;
import com.yape.codechallenge.service.TransactionService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.UUID;


@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @MockBean
    private TransactionService transactionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateTransaction() throws Exception {
        
        TransactionResponseDto responseDto = new TransactionResponseDto();

        Mockito.when(transactionService.createTransaction(Mockito.any(Transaction.class))).thenReturn(responseDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetTransaction() throws Exception {
        Transaction transaction = new Transaction();
        UUID id = UUID.randomUUID();

        Mockito.when(transactionService.getTransaction(id)).thenReturn(transaction);

        mockMvc.perform(MockMvcRequestBuilders.get("/transactions/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllTransactions() throws Exception {
        Transaction transaction = new Transaction();

        Mockito.when(transactionService.getAllTransactions()).thenReturn(Arrays.asList(transaction));

        mockMvc.perform(MockMvcRequestBuilders.get("/transactions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
