package com.zerogift.backend.giftBox.entity;

import com.zerogift.backend.common.entity.BaseTimeEntity;
import com.zerogift.backend.member.entity.Member;
import com.zerogift.backend.pay.entity.PayHistory;
import com.zerogift.backend.product.entity.Product;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class GiftBox extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isUse;

    @Column(nullable = false)
    private String code; // 사용 코드

    private String barcodeUrl;

    @Column(nullable = false)
    private LocalDate expireDate;

    @Column(nullable = false)
    private Boolean answer;  // 답변을 하였는지

    @ManyToOne
    @JoinColumn(name = "send_member_id")
    private Member sendMember;  // 보낸 사람

    @ManyToOne
    @JoinColumn(name = "recipient_member_id")
    private Member recipientMember;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "payhistory_id")
    private PayHistory payHistory;

    @Builder
    public GiftBox(String code, String barcodeUrl,
        Member sendMember, Member recipientMember,
        Product product, PayHistory payHistory) {
        this.code = code;
        this.barcodeUrl = barcodeUrl;
        this.sendMember = sendMember;
        this.recipientMember = recipientMember;
        this.product = product;
        this.payHistory = payHistory;
        this.isUse = false;
        this.answer = false;
        this.expireDate = LocalDate.now().plusMonths(1);
    }

    public void answer() {
        this.answer = true;
    }

    public void addBarcodeUrl(String url) {
        this.barcodeUrl = url;
    }

    public void use() {
        this.isUse = true;
    }

}