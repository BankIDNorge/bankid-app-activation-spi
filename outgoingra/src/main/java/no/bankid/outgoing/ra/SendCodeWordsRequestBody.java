package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Request body content for asking an RA to send code words to an endUser")
public class SendCodeWordsRequestBody {
    @Schema(description = "The id of this activation attempt, used for for logging, will be the same for both codes")
    public UUID activation_id;
    @Schema(description = "One of the method identifiers returned from selfservice/check_user call")
    public String distribution_method;
    public AppClientLocale locale;
    @Schema(description = "The two code words to distribute")
    public String code_words;
    @Schema(description = "Time when code expire, ms since epoch, UTC")
    public long exp;
}
