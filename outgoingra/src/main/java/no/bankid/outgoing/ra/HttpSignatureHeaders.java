package no.bankid.outgoing.ra;

import javax.ws.rs.core.HttpHeaders;

public interface HttpSignatureHeaders {
    String SIGNATURE = "Signature";
    String DATE = HttpHeaders.DATE;
    String DIGEST = "Digest";
}
