package com.mendel.challenge.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mendel.challenge.ChallengeApplication;
import com.mendel.challenge.controllers.implementations.TransactionController;
import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;
import com.mendel.challenge.services.impl.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
@ContextConfiguration(classes= ChallengeApplication.class)
@AutoConfigureMockMvc
public class TransactionControllerIT
{

    @Value("${server.port}")
    private int port;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    public TransactionController transactionController;

    @MockBean
    public TransactionService transactionService;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    private String getBaseUrl() {
        return new StringBuilder("http://localhost:").append(port).toString();
    }


    @Test
    public void createTransactionITest() throws Exception {

        TransactionRequest transactionRequestMock = new TransactionRequest("buy", 1L, 1L);
        TransactionResponse.Tx tx = new TransactionResponse.Tx(1L, "buy", 1L);
        List<TransactionResponse.Tx> txList = new ArrayList<>();
        txList.add(tx);
        TransactionResponse transactionResponseMock = new TransactionResponse(txList, 1L);
        when(transactionService.createTransaction(transactionRequestMock))
                .thenReturn(transactionResponseMock);


        mockMvc.perform( MockMvcRequestBuilders
                        .post(getBaseUrl() +"/v1/transactions/create")
                        .content(asJsonString(transactionRequestMock))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactions").exists());


    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
