package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Phone number to standard: <a href=\"https://www.itu.int/rec/T-REC-E.164-201011-I/en\">T-REC-E.164-201011-I</a>")
public class MsisdnDTO {
    @Schema(
            description = "Country code length, this is provided purely for convenience.",
            example = "2",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    public int cc_count;

    @Schema(
            description = "Phone number, always provided with country code and without leading zeroes or +.",
            example = "4793123456",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    public String e164_number;
}
