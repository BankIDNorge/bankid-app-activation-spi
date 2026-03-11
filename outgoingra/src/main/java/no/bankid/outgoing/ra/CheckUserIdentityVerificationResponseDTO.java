package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Response from identity verification check. When verified=true, the verification code was valid and has been consumed (single-use) and the error field will be absent. When verified=false, the error field will be present indicating the reason for failure. If the error field is present, verified will always be false. The code is consumed only upon successful verification. Failed attempts (INVALID) do not consume the code, allowing the user to retry.")
public class CheckUserIdentityVerificationResponseDTO {

    public enum ErrorCode {
        INVALID,
        EXPIRED,
        CONSUMED
    }

    @Schema(
            description = "Whether the verification code was valid and has been consumed. true means the code matched and the identity verification is successful — the error field will be absent. false means verification failed — the error field will be present indicating the reason. Any error condition (mismatched code, expired code, already consumed code) will always result in verified=false.",
            example = "false",
            requiredMode = REQUIRED
    )
    public boolean verified;

    @Schema(
            description = "Error code indicating why verification failed. Only present when verified=false. If this field is present, verified will always be false. Possible values: INVALID (the submitted verification code does not match the expected code — the user may retry with the correct code), EXPIRED (the verification code has expired because it exceeded the time limit since its creation — a new code must be generated), CONSUMED (the verification code has already been successfully verified once and cannot be reused — a new code must be generated). This field MUST be present when verified=false and MUST be absent when verified=true.",
            example = "INVALID",
            requiredMode = NOT_REQUIRED
    )
    public ErrorCode error;
}
