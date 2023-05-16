package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "The result of querying RA about validity of end user phone number")
public class CheckUserResponseDTO {
    @Schema(
            description =
                "<b>Note:</b> Only required for Self Service activation." +
                "<p>Declaration for Methods for distribution</p>",
            deprecated = true
    )
    public static class DistributionMethodDTO {
        @Schema(
                description = "<b>Note:</b> Only required for Self Service activation. " +
                    "<p>Type of distribution</p>" +
                    "<ul>" +
                    "<li> - email:  1-3 unmasked characters + \"(...)\" @ domain.topdomain, eg. dei(...)@gmail.com </li>" +
                    "<li> - postal: No hint, details on the address must not be exposed. </li>" +
                    "</ul>",
                example = "email",
                deprecated = true
        )
        public enum DistributeBy {
            email, postal
        }

        @Schema(
                description = "<b>Note:</b> Only required for Self Service activation.",
                deprecated = true
        )
        public DistributeBy type;

        @Schema(
                description = "<b>Note:</b> Only required for Self Service activation." +
                    "<p>An id for this distribution method, must be unique within this response</p>",
                deprecated = true
        )
        public String id;

        @Schema(
                description = "<b>Note:</b> Only required for Self Service activation." +
                    "<p>Hint to user, ex. \"que****@hotmail.com\" or empty string on official_address</p>",
                deprecated = true
        )
        public String hint;

        @Schema(
                description = "<b>Note:</b> Only required for Self Service activation." +
                    "<p>When was this contact information last confirmed to be correct by the user, ms since epoch, UTC</p>",
                deprecated = true
        )
        public long last_confirmed_by_user;

        @Schema(
                description = "<b>Note:</b> Only required for Self Service activation." +
                    "<p>When was this contact information last modified, ms since epoch, UTC</p>",
                deprecated = true
        )
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


    @Schema(
            description = "<b>Note:</b> Only required for Self Service activation." +
            "<p>Time when the user's password was last reset, ms since epoch, UTC</p>",
            deprecated = true
    )
    public long pw_reset_timestamp;

    @Schema(description = "If the msisdn given in the request is correct, return a MsisdnReference object otherwise msisdn_reference=null.")
    public MsisdnReferenceDTO msisdn_reference;

    @Schema(
            description = "<b>Note:</b> Only required for Self Service activation." +
                    "<p>List of distribution methods.</p>",
            deprecated = true
    )
    public List<DistributionMethodDTO> distribution_methods;

    @Schema(description = "Status of the users' BankID App OTP method")
    public StatusBappResponseDTO.Result status;
}
