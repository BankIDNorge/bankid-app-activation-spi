package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Request body content for asking an RA to validate end user activation attempt.")
public class CheckUserRequestBodyDTO extends AuthenticationBodyDTO {
    @Schema(description = "The id of this activation attempt, used for for logging")
    public UUID activation_id;

    @Schema(description = "Phone number")
    public MsisdnDTO msisdn;
}
