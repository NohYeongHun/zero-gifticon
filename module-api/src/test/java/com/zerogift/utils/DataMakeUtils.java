package com.zerogift.utils;

import com.zerogift.gift.domain.GiftBox;
import com.zerogift.member.domain.AuthType;
import com.zerogift.member.domain.Member;
import com.zerogift.member.domain.MemberStatus;
import com.zerogift.member.domain.Role;
import com.zerogift.pay.domain.PayHistory;
import com.zerogift.product.domain.Category;
import com.zerogift.product.domain.Product;
import com.zerogift.product.domain.ProductImage;
import com.zerogift.product.domain.Status;
import java.util.UUID;

public class DataMakeUtils {

    public static Member 회원_생성(String email, String nickname) {
        return Member.builder()
            .email(email)
            .nickname(nickname)
            .status(MemberStatus.PERMITTED)
            .authType(AuthType.KAKAO)
            .authId("test_id")
            .profileImageUrl("https://test.com")
            .role(Role.ROLE_ADMIN)
            .build();
    }

    public static Member 회원_생성(String email, String nickname, String authId) {
        return Member.builder()
            .email(email)
            .nickname(nickname)
            .status(MemberStatus.PERMITTED)
            .authType(AuthType.KAKAO)
            .profileImageUrl("https://test.com")
            .role(Role.ROLE_ADMIN)
            .build();
    }

    public static ProductImage 상품_이미지_생성(String url) {
        return ProductImage.builder()
            .url(url)
            .build();
    }

    public static Product 상품_생성(String name, String description, Member member) {
        return Product.builder()
            .name(name)
            .description(description)
            .price(1000)
            .category(Category.BIRTHDAY)
            .status(Status.PUBLIC)
            .member(member)
            .count(10)
            .build();
    }

    public static PayHistory 결제_히스트리_생성(Product product, Member fromMember, Member toMember) {
        return PayHistory.builder()
            .impUid("test_uid")
            .merchantUid("test_merchant")
            .name(product.getName())
            .price(product.getPrice())
            .pgProvider("test_provider")
            .pgTid("test_pgTid")
            .usePoint(1000)
            .product(product)
            .fromMember(fromMember)
            .toMember(toMember)
            .build();
    }

    public static GiftBox 선물함_생성(Product product, Member fromMember, Member toMember, PayHistory payHistory) {
        return GiftBox.builder()
            .code(UUID.randomUUID().toString())
            .barcodeUrl("https://test.com")
            .product(product)
            .sendMember(fromMember)
            .recipientMember(toMember)
            .payHistory(payHistory)
            .build();
    }

}
