package com.yape.codechallenge.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String transactionExternalId;

    private Description transactionType;

    private Description transactionStatus;

    private String value;

    private String createdAt;

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Description implements Serializable {

        private static final long serialVersionUID = 1L;

        private String name;
    }
}
