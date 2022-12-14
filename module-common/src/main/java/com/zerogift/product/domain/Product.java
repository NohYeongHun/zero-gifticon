package com.zerogift.product.domain;

import com.zerogift.member.domain.Member;
import java.time.LocalDateTime;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Integer count;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Builder.Default
    private Long viewCount = 0L;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String mainImageUrl;
    @Lob
    @Builder.Default
    private HashSet<Long> liked = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @Builder.Default
    private Long likeCount = 0L;

    public void plusViewCount() {
        this.viewCount += 1;
    }

    public void payProduct() {
        this.count -= 1;
    }

}
