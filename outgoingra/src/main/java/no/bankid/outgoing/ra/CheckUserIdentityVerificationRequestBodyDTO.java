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
            description = "Verification code provided by RA Officer to user. Currently the code MUST be a string of 6 digits. In the " +
                    "future, it may be changed to a string with a length between 6 and 1024 characters.",
            example = "123456",
            requiredMode = REQUIRED,
            minLength = 6,
            maxLength = 1024
    )
    public String verification_code;
}
