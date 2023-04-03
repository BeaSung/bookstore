package com.bea.springbootmysql.controller.request;

import lombok.Data;

@Data
public class OrderRequest {

    private Long memberId;
    private Long bookId;
}
