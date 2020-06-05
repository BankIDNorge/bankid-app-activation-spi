package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;
import java.util.UUID;

@Schema(description = "Request body content for asking an RA to send a notification to an end user")
public class NotifyUserOfActivationRequestBodyDTO extends AuthenticationBodyDTO {

    @Schema(description = "Information about the activation")
    public static class ActivationMetadataDTO {

        @Schema(description = "Details of one distribution method used during activation.")
        public static class ViaDistributionMethodDTO {
            @Schema(description = "Type of distribution", example = "email")
            public enum DistributeBy {
                sms, email, postal
            }

            public DistributeBy type;
            @Schema(description = "A censored representation of the user's contact information." +
                    "<ul>" +
                    "<li> - type sms: 6 X's followed by two unmasked digits XXX XX X42" +
                    "<li> - type email:  1-3 unmasked characters + \"(...)\" @ domain.topdomain, eg. dei(...)@gmail.com </li>" +
                    "<li> - type official_address: No hint, details on the address must not be exposed. </li>" +
                    "</ul>", example = "dei(...)@gmail.com"
            )
            public String hint;
            @Schema(description = "An RA-specific ID which can be used to track the specific distribution method all " +
                    "the way back to the issuing RA.", example = "9980@1234-2f44-123456-12")
            public String originator_ref;
        }

        @Schema(description = "The flow used for activation, meanings:" +
                "<ul>" +
                "<li> - activation_code: A single activation code provided over a secure channel. </li>" +
                "<li> - selfservice: Activation codes provided over two insecure channels. </li>" +
                "<li> - bankid_auth: Activation through a BankID authentication. </li>" +
                "</ul>", example = "selfservice"
        )
        public enum FlowType {
            activation_code, selfservice, bankid_auth
        }

        public FlowType flow;
        @Schema(description = "The distribution methods (if any) used during activation.")
        public ViaDistributionMethodDTO[] via_distribution_methods;

        public AppClientLocaleDTO locale;
        @Schema(description = "Map of localized strings explaining how the device was activated",
                example = "{" +
                        "\"no\": \"med aktiveringskoder gitt på email til que***@xyz.no og på sms til XXX XX X42\"," +
                        "\"en\": \"using activation codes by email to que***@xyz.no and sms to XXX XX X42\"" +
                        "}")
        public Map<AppClientLocaleDTO, String> human_readable;
    }

    @Schema(description = "The id of this activation attempt, used for for logging")
    public UUID activation_id;
    public ActivationMetadataDTO activationMetadata;
}
