package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Locale of initiating app, either \"no\" for Norwegian and Norwegian dialects, otherwise \"en\"" +
        "<h5>(the 'no' value is shown as 'false', openapi nuisance)</h5>", example = "en")
public enum AppClientLocaleDTO {
    no, en
}
