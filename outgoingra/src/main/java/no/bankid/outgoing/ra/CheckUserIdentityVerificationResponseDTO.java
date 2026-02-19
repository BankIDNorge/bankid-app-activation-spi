package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Response from identity verification check. The code is consumed only upon successful verification. Failed attempts (INVALID) do not consume the code, allowing the user to retry.")
public class CheckUserIdentityVerificationResponseDTO {

    public enum ErrorCode {
        INVALID,
        EXPIRED,
        CONSUMED
    }

    @Schema(
            description = "Whether the verification code was valid and has been consumed. When true, the error field will be absent. When false, the error field MUST be present.",
            requiredMode = REQUIRED
    )
    public boolean verified;

    @Schema(
            description = "Error code if verification failed (only present when verified=false). Possible values: INVALID (verification code does not match, user may retry), EXPIRED (verification code has expired, codes expire after 15 minutes), CONSUMED (verification code has already been successfully used). This field MUST be present when verified=false and MUST be absent when verified=true.",
            requiredMode = NOT_REQUIRED
    )
    public ErrorCode error;
}
