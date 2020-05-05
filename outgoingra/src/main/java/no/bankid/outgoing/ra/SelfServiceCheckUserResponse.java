package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "The result of querying RA about endUser distribution methods")
public class SelfServiceCheckUserResponse {
    @Schema(description = "Declaration for Methods for distribution and ")
    public static class DistributionMethod {
        @Schema(description = "Type of distribution" +
                "<ul>" +
                "<li> - email:  1-3 unmasked characters + \"(...)\" @ domain.topdomain, eg. dei(...)@gmail.com </li>" +
                "<li> - official_address: No hint, details on the address must not be exposed. </li>" +
                "</ul>", example = "email"
        )
        public enum DistributeBy {email, official_address}

        public DistributeBy type;
        @Schema(description = "An id for this distribution method, must be unique within this response")
        public String id;
        @Schema(description = "Hint to user, ex. \"que****@hotmail.com\" or empty string on official_address",
                example = "")
        public String hint;
        @Schema(description = "When was this contact information last verified by the user, ms since epoch, UTC")
        public long last_verified;
        @Schema(description = "When was this contact information last modified by the user, ms since epoch, UTC")
        public long last_modified;
    }

    @Schema(description = "Time when the user's password was last reset, ms since epoch, UTC")
    public long pw_reset_timestamp;
    @Schema(description = "True if the given phone number matches the what is registered for the given user")
    public boolean correct_msisdn;
    @Schema(description = "List of distribution methods")
    public List<DistributionMethod> distribution_methods;
}
