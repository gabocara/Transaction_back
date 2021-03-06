package com.mendel.challenge.controllers.implementations;

import com.mendel.challenge.controllers.interfaces.ITransactionController;
import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;
import com.mendel.challenge.services.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransactionController implements ITransactionController {

    private final ITransactionService transactionService;

    @Override
    public ResponseEntity<TransactionResponse> getTransactionsByType(String transactionType) {
        return ResponseEntity.ok(transactionService.getTransactionsByType(transactionType));
    }

    @Override
    public ResponseEntity<TransactionResponse> createTransaction(TransactionRequest transactionRequest) {
       return new ResponseEntity<>(transactionService.createTransaction(transactionRequest), HttpStatus.CREATED);
    }
}
