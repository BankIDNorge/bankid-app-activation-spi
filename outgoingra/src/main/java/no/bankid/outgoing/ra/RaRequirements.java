package no.bankid.outgoing.ra;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@OpenAPIDefinition(
        info = @Info(
                title = "Integration of BankID app with bank's BankID RA service",
                version = "1.2",
                description = "Defines methods needed to be implemented by Registration Authority service in banks " +
                        "wanting to add BankID app as an OTP mechanism for their BankID Netcentric users.\n\n" +
                        "If an RA service implements these methods, than the activation of an BankID app will use " +
                        "them to connect the BankID app with the endUser's BankID."
        //      ,contact =
        //      @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
        )
)

@Tag(name = "RaRequirements",
        description = "Administrate (BankID app OTP, Netcentric BankID) relation in endUser's bank's RA")
@Path("/external/ra/")
@Produces({MediaType.APPLICATION_JSON})

public interface RaRequirements {
    @Operation(description = "Adds BankID app to an endUser's BankID OTP mechanisms in a given bank")

    @ApiResponse(responseCode = "200", description = "If status returned is valid",
            content = @Content(schema = @Schema(implementation = OTPAddResponse.class))
    )
    @ApiResponse(responseCode = "400", description = "In case of error")
    @ApiResponse(responseCode = "500", description = "In case of error")
    @PUT
    Response addBappOtp(
            @Parameter(description = "The Signature element, as described " +
                    "in https://tools.ietf.org/html/draft-cavage-http-signatures-12",
                    example = "keyId=\"fa998090\",algorithm=\"rsa-sha256\"," +
                            "headers=\"(request-target) date x-client-clientname x-dataownerorgid " +
                            "x-client-requestid x-customerid\",signature=\"o7zK892....\"",
                    required = true)
            @HeaderParam("Signature") String httpSignature,
            @Parameter(description = "The date element, timezone GMT, locale english, " +
                    "Format description in Java is: 'EEE, dd MMM yyyy HH:mm:ss zzz'",
                    example = "Mon, 16 Sep 2019 12:12:21 GMT",
                    required = true)
            @HeaderParam("Date") String date,
            @Parameter(description = "Client calling this method, constant value",
                    example = "vipps-bapp-client",
                    required = true)
            @HeaderParam("X-CLIENT-CLIENTNAME") String clientName,
            @Parameter(description = "Originator/bank-number for endUser's bankID, valid BankID ODS number",
                    example = "3625",
                    required = true)
            @HeaderParam("X-DATAOWNERORGID") String odsBankNo,
            @Parameter(description = "EndUser's Norwegian national identification number, string of 11 digits",
                    example = "11111111016",
                    required = true)
            @HeaderParam("X-CUSTOMERID") String nnin
    );

    @Operation(description = "Checks whether an endUser has BankID app enabled as an OTP mechanism " +
            "for at least one of his BankIDs in a given bank")
    @ApiResponse(responseCode = "200", description = "If status returned is valid",
            content = @Content(schema = @Schema(implementation = OTPStatusResponse.class))
    )
    @ApiResponse(responseCode = "400", description = "In case of error")
    @ApiResponse(responseCode = "500", description = "In case of error")
    @GET
    Response getBappOtpStatus(
            @Parameter(description = "The Signature element, as described " +
                    "in https://tools.ietf.org/html/draft-cavage-http-signatures-12",
                    example = "keyId=\"fa998090\",algorithm=\"rsa-sha256\"," +
                            "headers=\"(request-target) date x-client-clientname x-dataownerorgid " +
                            "x-client-requestid x-customerid\",signature=\"o7zK892....\"",
                    required = true)
            @HeaderParam("Signature") String httpSignature,
            @Parameter(description = "The date element, timezone GMT, locale english, " +
                    "Format description in Java is: 'EEE, dd MMM yyyy HH:mm:ss zzz'",
                    example = "Mon, 16 Sep 2019 12:12:21 GMT",
                    required = true)
            @HeaderParam("Date") String date,
            @Parameter(description = "Client calling this method, constant value",
                    example = "vipps-bapp-client",
                    required = true)
            @HeaderParam("X-CLIENT-CLIENTNAME") String clientName,
            @Parameter(description = "Originator/bank-number for endUser's bankID, valid BankID ODS number",
                    example = "3625",
                    required = true)
            @HeaderParam("X-DATAOWNERORGID") String odsBankNo,
            @Parameter(description = "EndUser's Norwegian national identification number, string of 11 digits",
                    example = "11111111016",
                    required = true)
            @HeaderParam("X-CUSTOMERID") String nnin
    );

    @Operation(description = "Removes BankID app as an endUser's OTP mechanism for at least one of " +
            "his BankIDs in a given bank")
    @ApiResponse(responseCode = "200", description = "If status returned is valid",
            content = @Content(schema = @Schema(implementation = OTPDeleteResponse.class))
    )
    @ApiResponse(responseCode = "400", description = "In case of error")
    @ApiResponse(responseCode = "500", description = "In case of error")
    @DELETE
    Response removeBappOtp(
            @Parameter(description = "The Signature element, as described " +
                    "in https://tools.ietf.org/html/draft-cavage-http-signatures-12",
                    example = "keyId=\"fa998090\",algorithm=\"rsa-sha256\"," +
                            "headers=\"(request-target) date x-client-clientname x-dataownerorgid " +
                            "x-client-requestid x-customerid\",signature=\"o7zK892....\"",
                    required = true)
            @HeaderParam("Signature") String httpSignature,
            @Parameter(description = "The date element, timezone GMT, locale english, " +
                    "Format description in Java is: 'EEE, dd MMM yyyy HH:mm:ss zzz'",
                    example = "Mon, 16 Sep 2019 12:12:21 GMT",
                    required = true)
            @HeaderParam("Date") String date,
            @Parameter(description = "Client calling this method, constant value",
                    example = "vipps-bapp-client",
                    required = true)
            @HeaderParam("X-CLIENT-CLIENTNAME") String clientName,
            @Parameter(description = "Originator/bank-number for endUser's bankID, valid BankID ODS number",
                    example = "3625",
                    required = true)
            @HeaderParam("X-DATAOWNERORGID") String odsBankNo,
            @Parameter(description = "EndUser's Norwegian national identification number, string of 11 digits",
                    example = "11111111016",
                    required = true)
            @HeaderParam("X-CUSTOMERID") String nnin
    );
}
