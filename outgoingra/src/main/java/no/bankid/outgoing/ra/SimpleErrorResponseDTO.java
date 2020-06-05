package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Result when there is only an error code in return")
public class SimpleErrorResponseDTO {

    public String error;
}
