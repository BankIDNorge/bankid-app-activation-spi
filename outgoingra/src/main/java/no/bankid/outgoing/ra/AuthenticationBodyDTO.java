package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Minimal body for authenticating and authorizing a request")
public class AuthenticationBodyDTO extends BaseRequestBodyDTO {
    @Schema(
            description = "End user's Norwegian national identification number, string of 11 digits",
            example = "11111111016",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    public String nnin;
}
