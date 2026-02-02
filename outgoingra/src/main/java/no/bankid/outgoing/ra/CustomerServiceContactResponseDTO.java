package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Response containing customer service contact details for booking an appointment.")
public class CustomerServiceContactResponseDTO {

    public static class CustomerServiceContactDetailsDTO {

        @Schema(
                description = "Phone number (E.164) to the customer service of the financial institution. MUST be a Norwegian number associated with the financial institution. Provided with country code and without leading zeroes or +.",
                example = "4712345678",
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
    }

    @Schema(
            description = "Contact details for the customer service of the financial institution",
            requiredMode = REQUIRED
    )
    public CustomerServiceContactDetailsDTO customer_service_contact_details;
}
