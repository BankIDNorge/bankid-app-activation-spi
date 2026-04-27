package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Response containing customer service information for the financial institution.")
public class CustomerServiceInfoResponseDTO {

    public enum VerificationMethod {
        MANUAL_CODE,
        QR_CODE
    }

    public static class CustomerServiceInfoDTO {

        @Schema(
                description = "Phone number (E.164) to the customer service of the financial institution. MUST be a Norwegian number associated with the financial institution",
                example = "+4712345678",
                requiredMode = REQUIRED
        )
        public String phone_number;

        @Schema(
                description = "Display name of the financial institution",
                example = "Bank of Norway",
                maxLength = 80,
                requiredMode = REQUIRED
        )
        public String display_name;

        @Schema(
                description = "The verification method the financial institution will use when the user visits the branch. MANUAL_CODE means the RA officer will verbally provide a code; QR_CODE means the user will scan a QR code.",
                requiredMode = REQUIRED
        )
        public VerificationMethod verification_method;

        @Schema(
                description = "Length of the verification code the RA system will generate.",
                example = "6",
                requiredMode = REQUIRED
        )
        public int code_length;

        @Schema(
                description = "Optional instructions from the financial institution to the user, for example directions or what to bring. Maximum 250 characters. Null when not set. " +
                        "When the request includes an Accept-Language header with a supported language tag (nb, nn, en), the RA SHOULD return this text in the requested language on a best-effort basis; otherwise it falls back to the RA's default language.",
                example = "Please bring a valid passport or national ID card to your appointment.",
                maxLength = 250,
                requiredMode = NOT_REQUIRED,
                nullable = true
        )
        public String instructions;

        @Schema(
                description = "Optional URL for booking an appointment at the financial institution's branch. Null when not set.",
                example = "https://www.bankofnorway.no/book-appointment",
                requiredMode = NOT_REQUIRED,
                nullable = true
        )
        public String booking_url;
    }

    @Schema(
            description = "Customer service information for the financial institution",
            requiredMode = REQUIRED
    )
    public CustomerServiceInfoDTO customer_service_info;
}
