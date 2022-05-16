package com.mendel.challenge.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@Accessors(chain = true)
public class TransactionResponse {

    private List<Tx> transactions;
    private Long totalAmount;

    public TransactionResponse(List<Tx> transactions, Long totalAmount) {
        this.transactions = transactions;
        this.totalAmount = totalAmount;
    }

    public TransactionResponse(List<Tx> transactions) {
        this.transactions = transactions;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tx {
        private Long amount;
        private String transactionType;
        private Long parentId;
    }

}
