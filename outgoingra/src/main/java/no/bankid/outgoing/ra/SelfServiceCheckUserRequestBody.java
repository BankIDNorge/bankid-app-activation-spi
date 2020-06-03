package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Request body content for asking an RA about end user distribution methods")
public class SelfServiceCheckUserRequestBody extends AuthenticationBody {

    @Schema(description = "The id of this activation attempt, used for for logging")
    public UUID activation_id;
    public Msisdn msisdn;
}
