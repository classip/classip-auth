package com.pyjava.classip.auth.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>描述: 默认加密器 </p>
 *
 * @author zhaojj11
 * @date 2021/1/4 13:13
 * @since v1.0.0-SNAPSHOT
 */
public class NoEncryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.contentEquals(charSequence);
    }
}