package com.zerogift.backend.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.zerogift.backend.security.dto.AdminInfo;
import com.zerogift.backend.security.dto.MemberInfo;

@Component
public class TokenUtil {
    public static String getAdminEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = null;
        try {
            email = ((AdminInfo) auth.getPrincipal()).getEmail();
        } catch (Exception e) {
            return email;
        }
        return email;
    }

    public static String getMemberEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = null;
        try {
            email = ((MemberInfo) auth.getPrincipal()).getEmail();
        } catch (Exception e) {
            return email;
        }
        return email;
    }
}