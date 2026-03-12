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
            description = "Verification code provided by RA Officer to user. Currently expected to be a 6-digit numeric string, " +
                    "but the schema accepts strings between 6 and 1024 characters for forward-compatibility.",
            example = "123456",
            requiredMode = REQUIRED,
            minLength = 6,
            maxLength = 1024
    )
    public String verification_code;
}
