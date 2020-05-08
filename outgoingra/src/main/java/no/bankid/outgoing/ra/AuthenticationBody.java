package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Minimal body for authenticating and authorizing a request")

public class AuthenticationBody {
    @Schema(description = "Name of client sending the request",
            example = "vipps-bapp-client")
    public String client_name;
    @Schema(description = "A unique identifier pr. request, used for log correlation",
            example = "e6dccaf0-c72f-48d9-9dc8-665e51e08e47")
    public String request_id;
    @Schema(description = "Originator/bank-number for end user's bankID, valid BankID ODS number",
            example = "9980")
    public String originator_id;
    @Schema(description = "End user's Norwegian national identification number, string of 11 digits",
            example = "11111111016")
    public String nnin;
}
