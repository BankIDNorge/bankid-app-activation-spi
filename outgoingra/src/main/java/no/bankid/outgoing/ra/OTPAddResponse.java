package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of trying to enable BankID app for an endUser's BankID")

public class OTPAddResponse {
    @Schema(description = "Status value for add operation" +
            "<ul>" +
            "<li>ENABLED - BAPP is enabled for the endUser</li>" +
            "<li>NOT_ENABLED - Failed to enable BAPP for the customer</li>" +
            "<li>ALREADY_ENABLED - BAPP was already enabled</li>" +
            "<li>NOT_AVAILABLE - BAPP is not available for the bank</li>" +
            "<li>BANK_ID_NOT_AVAILABLE - endUser doesn't have active BankID</li>" +
            "<li>BLOCKED_BY_BANK - endUser is not allowed to use BAPP</li>" +
            "<li>BLOCKED_IN_ODS - BAPP is connected to the BankID, but was blocked by ODS because of wrong attempts</li>" +
            "</ul>")
    public enum Result {
        ENABLED,
        NOT_ENABLED,
        ALREADY_ENABLED,
        NOT_AVAILABLE,
        BANK_ID_NOT_AVAILABLE,
        BLOCKED_BY_BANK,
        BLOCKED_IN_ODS
    }
    public Result status;
}