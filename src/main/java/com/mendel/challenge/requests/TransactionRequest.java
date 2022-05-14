package com.mendel.challenge.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TransactionRequest {

    @NotNull private String transactionType;
    @NotNull private Long amount;
             private Integer parentId;

}
