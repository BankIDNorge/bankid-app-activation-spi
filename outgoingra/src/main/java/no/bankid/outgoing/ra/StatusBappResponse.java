package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of asking if BankID app is enabled for an end user's BankID")
public class StatusBappResponse {
    @Schema(description = "Status value for end user's BAPP " +
            "<ul>" +
            "<li>NOT_ENABLED - BAPP is not enabled, but could be</li>" +
            "<li>ENABLED - BAPP is enabled for the end user</li>" +
            "<li>NOT_AVAILABLE - BAPP is not available for the bank</li>" +
            "<li>BANK_ID_NOT_AVAILABLE - end user doesn't have active BankID</li>" +
            "<li>BLOCKED_BY_BANK - end user is not allowed to use BAPP</li>" +
            "<li>BLOCKED_IN_ODS - BAPP is connected to the BankID, but was blocked by ODS because of wrong attempts</li>" +
            "</ul>")
    public enum Result {
        NOT_ENABLED,
        ENABLED,
        NOT_AVAILABLE,
        BANK_ID_NOT_AVAILABLE,
        BLOCKED_BY_BANK,
        BLOCKED_IN_ODS,
    }

    public Result status;
}