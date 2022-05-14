package com.mendel.challenge.services;

import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;

public interface ITransactionService {

    TransactionResponse getTransactionsByType(String transactionType);

    TransactionResponse createTransaction(TransactionRequest transactionRequest);

}
