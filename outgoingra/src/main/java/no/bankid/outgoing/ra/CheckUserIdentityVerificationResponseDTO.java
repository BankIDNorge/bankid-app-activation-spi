package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Response from identity verification check. The code is consumed only upon successful verification. Failed " +
        "attempts (INVALID) do not consume the code, allowing the user to retry.")
public class CheckUserIdentityVerificationResponseDTO {

    @Schema(
            description = "True when the provided code matches; false if there is an error, i.e. INVALID, EXPIRED, or CONSUMED.",
            example = "false",
            requiredMode = REQUIRED
    )
    public boolean verified;
    @Schema(
            description = "Error code if verification failed. " +
                    "Possible values: " +
                    "- INVALID (verification code does not match, user may retry), " +
                    "- EXPIRED (verification code has expired, RA System needs to handle expiration time), " +
                    "- CONSUMED (verification code has already been successfully used). " +
                    "This field MUST be present when `verified=false` and MUST be absent when `verified=true`.",
            example = "INVALID",
            requiredMode = NOT_REQUIRED
    )
    public ErrorCode error;

    public enum ErrorCode {
        INVALID,
        EXPIRED,
        CONSUMED
    }
}
