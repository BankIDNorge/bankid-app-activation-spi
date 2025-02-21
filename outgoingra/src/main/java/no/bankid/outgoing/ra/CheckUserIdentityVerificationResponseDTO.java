package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The result of querying RA about last end user identity verification")
public class CheckUserIdentityVerificationResponseDTO {

    public static class LastVerifiedDTO {
        @Schema(
                description = "Timestamp (ISO-8601 date-time in UTC) when the end user was verified",
                example = "2025-01-01T12:00:00Z",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        public String timestamp;

        @Schema(
                description = "Originator ID of the financial institution. Also known as the bank identifier part of IBAN/BBAN",
                example = "9980",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        public String originator_id;

        @Schema(
                description = "Any value that can be used to identify the RA officer internally. Can and should be opaque to the caller",
                example = "123456",
                maxLength = 80,
                pattern = "^[a-zA-Z0-9@_\\-]+$",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        public String ra_officer_id;
    }

    public static class CustomerServiceContactDetailsDTO {

        @Schema(
                description = "Phone number (E.164) to the customer service of the financial institution. MUST be a Norwegian number associated with the financial institution",
                example = "+4712345678",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        public String phone_number;

        @Schema(
                description = "Display name of the financial institution",
                example = "Bank of Norway",
                maxLength = 80,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        public String display_name;
    }

    @Schema(
            description = "The last time the end user was verified by an RA officer. Only included in the response if the end user has been verified",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    public LastVerifiedDTO last_verified;

    @Schema(
            description = "Contact details for the customer service of the financial institution",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    public CustomerServiceContactDetailsDTO customer_service_contact_details;
}
