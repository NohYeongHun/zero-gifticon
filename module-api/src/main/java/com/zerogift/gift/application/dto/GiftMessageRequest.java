package com.zerogift.gift.application.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftMessageRequest {

    @ApiModelProperty(example = "선물함 아이디")
    @NotNull(message = "giftBoxId는 필수값입니다.")
    private Long giftBoxId;

    @ApiModelProperty(example = "감사 메시지 내용")
    @NotNull(message = "message는 필수 값입니다.")
    private String message;

    @Builder
    public GiftMessageRequest(Long giftBoxId, String message) {
        this.giftBoxId = giftBoxId;
        this.message = message;
    }
}
