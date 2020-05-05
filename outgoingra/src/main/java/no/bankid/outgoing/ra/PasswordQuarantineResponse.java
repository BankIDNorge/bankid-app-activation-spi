package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Response when quarantining an endUser password")
public class PasswordQuarantineResponse {
    @Schema(description = "Time when user's password was last reset, ms since epoch, UTC")
    public long pw_reset_timestamp;
}
