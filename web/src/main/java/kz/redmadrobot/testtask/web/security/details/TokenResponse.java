package kz.redmadrobot.testtask.web.security.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
}
