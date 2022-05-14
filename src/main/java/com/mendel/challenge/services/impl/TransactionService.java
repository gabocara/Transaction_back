package com.mendel.challenge.services.impl;

import com.mendel.challenge.repository.TransactionRepository;
import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;
import com.mendel.challenge.services.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public TransactionResponse getTransactionsByType(String transactionType) {
        return transactionRepository.getTransactionsByType(transactionType);
    }

    @Override
    public List<TransactionResponse> createTransaction(TransactionRequest transactionRequest) {
         return transactionRepository.createTransaction(transactionRequest);
    }
}
