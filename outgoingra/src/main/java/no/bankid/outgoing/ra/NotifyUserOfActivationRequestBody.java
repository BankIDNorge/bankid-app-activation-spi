package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;
import java.util.UUID;

@Schema(description = "Request body content for asking an RA to send a notification to an end user")
public class NotifyUserOfActivationRequestBody extends AuthenticationBody {
    @Schema(description = "Information about the activation")
    public static class ActivationMetadata {
        @Schema(description = "The flow used for activation, meanings:" +
                "<ul>" +
                "<li> - single_activation_code: A single activation code provided over a secure channel. </li>" +
                "<li> - activation_codes: Activation codes provided over two insecure channels. </li>" +
                "<li> - bankid_auth: Activation through a BankID authentication. </li>" +
                "</ul>", example = "activation_codes"
        )
        public enum FlowType {
            single_activation_code, activation_codes, bankid_auth
        }

        public FlowType flow;
        @Schema(description = "The distribution methods used during activation." +
                "<p>If flow is <i>single_activation_code</i> or <i>bankid_auth<i/>, " +
                "this will be an empty array.</p>" +
                "<p>Otherwise it will contain all the distribution method hints used to send a code, " +
                "including the phone-number which will be masked as follows: <i>+CCC ******DD</i>, " +
                "where CCC is the country code and DD is the last two digits of the phone-number.</p>" +
                "<p>The length will either be 0 or &ge; 2.</p>")
        public String[] via_distribution_methods;

        public AppClientLocale locale;
        @Schema(description = "Map of localized strings explaining how the device was activated",
                example = "{" +
                        "\"no\": \"med aktiveringskoder gitt på email til que***@xyz.no og på sms til XXX XX X42\"," +
                        "\"en\": \"using activation codes by email to que***@xyz.no and sms to XXX XX X42\"" +
                        "}")
        public Map<AppClientLocale, String> human_readable;


    }

    @Schema(description = "The id of this activation attempt, used for for logging")
    public UUID activation_id;
    public ActivationMetadata activationMetadata;
}
