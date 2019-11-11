package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of trying to enable BankID app for an endUser's BankID")

public class OTPAddResponse {
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