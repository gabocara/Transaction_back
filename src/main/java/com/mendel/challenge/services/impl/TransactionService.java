package com.mendel.challenge.services.impl;

import com.mendel.challenge.models.Transaction;
import com.mendel.challenge.repository.TransactionRepository;
import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;
import com.mendel.challenge.services.ITransactionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    private final ModelMapper modelMapper;

    @Override
    public TransactionResponse getTransactionsByType(String transactionType) {
        List<Transaction> transactions = transactionRepository.getTransctions();
        return null;
    }

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        List<Transaction> transactionList = transactionRepository.createTransaction(transactionRequest);
        return new TransactionResponse(transactionList.stream().map(this::convertToTransactionResponse).collect(Collectors.toUnmodifiableList()), transactionList.stream().mapToLong(t -> t.getAmount()).sum());
    }

    private TransactionResponse.Tx convertToTransactionResponse(Transaction transaction){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TransactionResponse.Tx transactionResponse = modelMapper.map(transaction, TransactionResponse.Tx.class);
        return transactionResponse;
    }
}
