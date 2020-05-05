package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Request body content for asking an RA to send verification code to enduser")
public class SendVerificationCodeRequestBody extends AuthenticationBody {

    @Schema(description = "The id of this activation attempt, used for for logging, will be the same for both codes")
    public UUID activation_id;
    public Msisdn msisdn;
    public AppClientLocale locale;
    @Schema(description = "Four digit code")
    public String verification_code;
    @Schema(description = "Time when code expire, ms since epoch, UTC")
    public long exp;
}
