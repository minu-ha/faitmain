package com.faitmain.domain.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCancle{

    private String buyerId;

    private int OrderNumber;

    private String keyword;

    private int PageAmount;

    private int PageNumber;
}