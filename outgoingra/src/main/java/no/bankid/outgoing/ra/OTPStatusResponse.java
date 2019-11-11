package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of asking if BankID app is enabled for an enddUser's BankID")
public class OTPStatusResponse {
    public enum Result {
        NOT_ENABLED,
        ENABLED,
        NOT_AVAILABLE,
        BANK_ID_NOT_AVAILABLE,
        BLOCKED_BY_BANK,
        BLOCKED_IN_ODS
    }

    public Result status;
}