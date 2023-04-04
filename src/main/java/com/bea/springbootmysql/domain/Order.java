package com.bea.springbootmysql.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@Table(name="orders")
public class Order {

    @Id
    private Long id;
    private Long memberId;
    private Long bookId;
    private int bookPrice;
    private int discountAmount;

    public Order(Long memberId, Long bookId, int bookPrice, int discountAmount) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.discountAmount = discountAmount;
    }

    public int calculatePaymentPrice() {
        if (bookPrice < discountAmount) {
            return 0;
        }
        return bookPrice - discountAmount;
    }
}
