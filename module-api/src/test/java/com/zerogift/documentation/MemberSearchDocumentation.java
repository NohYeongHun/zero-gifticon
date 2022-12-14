package com.zerogift.documentation;

import static com.zerogift.documentation.member.MemberSearchDetailStep.member_detail_search_documentation;
import static com.zerogift.documentation.member.MemberSearchDetailStep.member_detail_search_response_create;
import static com.zerogift.documentation.member.MemberSearchListStep.member_list_search_documentation;
import static com.zerogift.documentation.member.MemberSearchListStep.member_list_search_response_create;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.zerogift.member.application.MemberSearchService;
import com.zerogift.support.auth.authorization.AuthenticationPrincipalArgumentResolver;
import com.zerogift.support.auth.userdetails.AdminInfo;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

public class MemberSearchDocumentation extends Documentation{

    @MockBean
    private MemberSearchService memberSearchService;

    @MockBean
    private AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver;

    @Test
    void memberListSearch(){
        when(memberSearchService.searchMemberList(any(), any())).thenReturn(member_list_search_response_create());

        RestAssured
            .given(specification).log().all()
            .filter(member_list_search_documentation())
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .queryParam("nickname", "nickname")
            .queryParam("email","email")
            .when().get("/member-search/member-list")
            .then().log().all().extract();
    }

    @Test
    void memberSearchDetail(){
        when(authenticationPrincipalArgumentResolver.resolveArgument(any(), any(), any(), any())).thenReturn(
            AdminInfo.builder()
                .id(1L)
                .build());
        when(memberSearchService.searchMemberDetail(any())).thenReturn(member_detail_search_response_create());

        RestAssured
            .given(specification).log().all()
            .filter(member_detail_search_documentation())
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .when().get("/member-search/member")
            .then().log().all().extract();
    }
}
