package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Request body content for quarantining the user password")
public class PasswordQuarantineRequestBody extends AuthenticationBody {

    @Schema(description = "The id of this activation attempt, used for for logging")
    public UUID activation_id;
    @Schema(description = "Time when quarantine expire, ms since epoch, UTC")
    public long quarantine_until;
}
