package com.mendel.challenge.repository;

import com.mendel.challenge.models.Transaction;
import com.mendel.challenge.requests.TransactionRequest;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TransactionRepository {

    private static List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getTransctions(){
        return transactionList;
    }

    public List<Transaction> createTransaction(TransactionRequest transactionRequest) {

        Transaction transaction = new Transaction(transactionRequest, getParentId(transactionList, transactionRequest.getTransactionType()));
        transactionList.add(transaction);
        return transactionList;
    }

    private Long getParentId(List<Transaction> transactionList, String transactionType){
        Optional<Transaction> transactionOptional = transactionList.stream().filter(t -> t.getTransactionType().equalsIgnoreCase(transactionType)).findFirst();
        Long transactionMax = 0L;
        if(transactionList.size() != 0) {
            transactionMax = transactionList.stream().max(Comparator.comparing(Transaction::getParentId)).orElseThrow(NoSuchElementException::new).getParentId();
        }
        Long parentId = transactionList == null ? 0L : transactionOptional.isPresent() && transactionList != null ? transactionOptional.get().getParentId() : transactionMax +1;
        return parentId;
    }
}
