package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of trying to remove BankID app from an endUser's BankID ")

public class OTPDeleteResponse {
    public Result status;

    @Schema(description = "Status value for the delete operation " +
            "<ul>" +
            "<li>DELETED - BAPP was successfully deleted</li>" +
            "<li>NOT_ENABLED - BAPP hasn't been enabled for the endUser, nothing to delete.</li>" +
            "<li>BLOCKED_IN_ODS - BAPP wasn't deleted, since it is present and blocked by ODS because of wrong attempts</li>" +
            "</ul>")

    public enum Result {
        DELETED, NOT_ENABLED, BLOCKED_IN_ODS
    }
}