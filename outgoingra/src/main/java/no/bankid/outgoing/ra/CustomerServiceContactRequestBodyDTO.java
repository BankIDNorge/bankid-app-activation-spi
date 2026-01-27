package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body for getting customer service contact details.")
public class CustomerServiceContactRequestBodyDTO extends AuthenticationBodyDTO {
    // No additional fields - uses base AuthenticationBodyDTO fields:
    // client_name, request_id, originator_id, nnin
}
