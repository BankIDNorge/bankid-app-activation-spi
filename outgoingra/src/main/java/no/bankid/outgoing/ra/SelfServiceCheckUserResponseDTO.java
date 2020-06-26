package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "The result of querying RA about end user distribution methods")
public class SelfServiceCheckUserResponseDTO {
    @Schema(description = "Declaration for Methods for distribution and ")
    public static class DistributionMethodDTO {
        @Schema(description = "Type of distribution" +
                "<ul>" +
                "<li> - email:  1-3 unmasked characters + \"(...)\" @ domain.topdomain, eg. dei(...)@gmail.com </li>" +
                "<li> - postal: No hint, details on the address must not be exposed. </li>" +
                "</ul>", example = "email"
        )
        public enum DistributeBy {
            email, postal
        }

        public DistributeBy type;
        @Schema(description = "An id for this distribution method, must be unique within this response")
        public String id;
        @Schema(description = "Hint to user, ex. \"que****@hotmail.com\" or empty string on official_address")
        public String hint;
        @Schema(description = "When was this contact information last confirmed to be correct by the user, ms since epoch, UTC")
        public long last_confirmed_by_user;
        @Schema(description = "When was this contact information last modified, ms since epoch, UTC")
        public long last_modified;
    }

    public static class MsisdnReferenceDTO {
        @Schema(description = "An opaque reference which will be used as an alias for the msisdn.")
        public String id;
        @Schema(description = "When was msisdn last confirmed to be correct by the user, ms since epoch, UTC")
        public long last_confirmed_by_user;
        @Schema(description = "When was msisdn last modified, ms since epoch, UTC")
        public long last_modified;
    }


    @Schema(description = "Time when the user's password was last reset, ms since epoch, UTC")
    public long pw_reset_timestamp;
    @Schema(description = "If the msisdn given in the request is correct, return a MsisdnReference object otherwise msisdn_reference=null.")
    public MsisdnReferenceDTO msisdn_reference;
    @Schema(description = "List of distribution methods")
    public List<DistributionMethodDTO> distribution_methods;
    public StatusBappResponseDTO.Result status;
}
