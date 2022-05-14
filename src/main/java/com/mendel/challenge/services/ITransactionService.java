package com.mendel.challenge.services;

import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;

import java.util.List;

public interface ITransactionService {

    TransactionResponse getTransactionsByType(String transactionType);

    List<TransactionResponse> createTransaction(TransactionRequest transactionRequest);

}
