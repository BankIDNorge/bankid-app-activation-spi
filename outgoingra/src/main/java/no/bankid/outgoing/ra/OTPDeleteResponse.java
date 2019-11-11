package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of trying to remove BankID app from an endUser's BankID ")

public class OTPDeleteResponse {
    public enum Result {
        DELETED, NOT_ENABLED, BLOCKED_IN_ODS
    }

    public Result status;
}