package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Request body for checking user identity verification as part of the catch all activation method.")
public class CheckUserIdentityVerificationRequestBodyDTO extends AuthenticationBodyDTO {
    @Schema(
            description = "The id of this activation attempt, used for logging",
            requiredMode = REQUIRED
    )
    public UUID activation_id;

    @Schema(
            description = "Verification code provided to the user by the RA officer as part of the catch all activation method. Currently the code MUST be a string of 6 digits. In the future, it may be changed to a string with a length of 6-1024 characters.",
            example = "123456",
            requiredMode = REQUIRED,
            minLength = 6,
            maxLength = 1024
    )
    public String verification_code;
}
