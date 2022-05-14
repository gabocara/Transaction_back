package com.mendel.challenge.controllers.interfaces;

import com.mendel.challenge.requests.TransactionRequest;
import com.mendel.challenge.responses.TransactionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequestMapping("/v1/transactions")
public interface ITransactionController {

    @GetMapping("/type/{transactionType}")
    ResponseEntity<TransactionResponse> getTransactionsByType(@PathVariable @NotBlank String transactionType);

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<TransactionResponse> createTransaction(@RequestBody @Valid TransactionRequest transactionRequest);
}
