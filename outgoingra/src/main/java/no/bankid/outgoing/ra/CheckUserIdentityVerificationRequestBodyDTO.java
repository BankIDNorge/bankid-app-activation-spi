package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Request body content for asking an RA to validate end user activation attempt.")
public class CheckUserIdentityVerificationRequestBodyDTO extends AuthenticationBodyDTO {
    @Schema(
            description = "The id of this activation attempt, used for for logging",
            requiredMode = REQUIRED
    )
    public UUID activation_id;
}
