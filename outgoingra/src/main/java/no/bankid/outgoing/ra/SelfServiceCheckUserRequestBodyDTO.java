package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Request body content for asking an RA about end user distribution methods")
public class SelfServiceCheckUserRequestBodyDTO extends AuthenticationBodyDTO {

    @Schema(description = "The id of this activation attempt, used for for logging")
    public UUID activation_id;
    public MsisdnDTO msisdn;
}
