package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Request body for checking user identity verification from RA officer.")
public class CheckUserIdentityVerificationRequestBodyDTO extends AuthenticationBodyDTO {
    @Schema(
            description = "The id of this activation attempt, used for logging",
            requiredMode = REQUIRED
    )
    public UUID activation_id;

    @Schema(
            description = "Short verification code provided by RA Officer to user during physical presence verification. Validation is case-insensitive for easier input. Maximum length is 64 characters.",
            example = "MOUNTAIN RIVER",
            requiredMode = REQUIRED,
            maxLength = 64
    )
    public String verification_code;
}
