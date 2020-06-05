package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of asking an ra to notify a user of activation, used in case of some error")
public class NotifyUserOfActivationErrorResponseDTO extends SimpleErrorResponseDTO {
    public enum Status {
        unknown_subject,
        internal_error,
    }

    public Status status;
}
