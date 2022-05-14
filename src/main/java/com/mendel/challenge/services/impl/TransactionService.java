package com.mendel.challenge.services.impl;

import com.mendel.challenge.models.Transaction;
import com.mendel.challenge.repository.TransactionRepository;
import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;
import com.mendel.challenge.services.ITransactionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
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
        return new TransactionResponse(transactions.stream().filter(transaction ->  transaction.getTransactionType().equalsIgnoreCase(transactionType)));

    }

    @Override
    public List<TransactionResponse> createTransaction(TransactionRequest transactionRequest) {
        List<Transaction> transactionList = transactionRepository.createTransaction(transactionRequest);
        return transactionList.stream().map(this::convertToTransactionResponse).collect(Collectors.toUnmodifiableList());
    }

    private TransactionResponse convertToTransactionResponse(Transaction transaction){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TransactionResponse transactionResponse = modelMapper.map(transaction, TransactionResponse.class);
        return transactionResponse;
    }
}
