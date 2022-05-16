package com.mendel.challenge.models;

import com.mendel.challenge.requests.TransactionRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private static Integer id = 0;
    private Long amount;
    private static Long finalAmount =0L;
    private String transactionType;
    private Long parentId;


    public Transaction(TransactionRequest transactionRequest, Long parentId) {
        this.id+=1;
        this.amount=transactionRequest.getAmount();
        this.finalAmount=this.amount;
        this.transactionType=transactionRequest.getTransactionType();
        this.parentId = parentId;
    }
}
