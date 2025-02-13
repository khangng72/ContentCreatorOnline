package hcmut.contentCreatorOnline.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil implements PasswordEncoder {
    private final PasswordEncoder passwordEncoder;

    public PasswordUtil() {
        this.passwordEncoder = new BCryptPasswordEncoder(5);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword.toString(), encodedPassword);
    }
}
