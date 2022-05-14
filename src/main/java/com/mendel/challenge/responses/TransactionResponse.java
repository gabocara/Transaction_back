package com.mendel.challenge.responses;

import com.mendel.challenge.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.stream.Stream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TransactionResponse {

    private Long totalAmount;

    public TransactionResponse(Stream<Transaction> transactionStream) {
        this.totalAmount = transactionStream.mapToLong(t -> t.getAmount()).sum();
    }
}
