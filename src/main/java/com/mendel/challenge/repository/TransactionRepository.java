package com.mendel.challenge.repository;

import com.mendel.challenge.models.Transaction;
import com.mendel.challenge.requests.TransactionRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    private static List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getTransctions(){
        return transactionList;
    }

    public List<Transaction> createTransaction(TransactionRequest transactionRequest) {
        transactionList.add(new Transaction(transactionRequest));
        return transactionList;
    }
}
