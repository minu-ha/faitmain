package com.faitmain.domain.order.domain;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Order{

    /* 주문번호 */
    private int orderNumber;

    /* 상품번호 */
    private int productNumber;

    /* 구매자 PK */
    private String buyerId;

    /* 판매자 PK */
    private String storeId;

    /* 주문상태 */
    private String orderStatus;

    /* 주문상품 */
    private List<OrderOne> orderBundle;

    /* 배송비 */
    private int deliveryCharge;

    /* 주문날짜 */
    private Date orderDate;

    /* 수취인 이름 */
    private String receiverName;

    /* 수취인 전화번호 */
    private String receiverPhone;

    /* 수취인 우편번호 */
    private String receiverAddress1;

    /* 수취인 기본주소 */
    private String receiverAddress2;

    /* 수취인 상세주소 */
    private String receiverAddress3;

    /* 사용 포인트 */
    private int usingPoint;

    /* ===================== */
    /* DB에 존재하지 않는 데이터 */
    /* ===================== */

    /* 판매가 ( 모든 상품 ) */
    private int orderSalePrice;

    /* 적립 포인트 */
    private int orderRewardPoint;

    /* 최종 판매 비용 */
    private int orderFinalSalePrice;


    public void getOrderPriceInfo(){

        /* 상품 비용 & 적립포인트 */
        for ( OrderOne order : orderBundle ) {
            orderSalePrice += order.getTotalPrice();
            orderRewardPoint += order.getTotalRewardPoint();
        }

        /* 배송비용 */
        if ( orderSalePrice >= 30000 ) {
            deliveryCharge = 0;
        } else {
            deliveryCharge = 3000;
        }

        /* 최종비용 */
        orderFinalSalePrice = orderSalePrice + deliveryCharge - usingPoint;
    }








/*
    private int deliveryTrackingNumber;

    private String deliveryCompanyCode;

    private String paymentOption;


    private Date orderClaimRequestDate;

    private Date orderClaimResponseDate;

    private int orderClaimReason;
*/

}