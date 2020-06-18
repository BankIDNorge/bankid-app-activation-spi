# BankID app integration getting started
This guide covers what you need to get started with integrating BankID app infrastructure with your BankID RA.

The following information must be provided to BankID support when requesting integration with BankID app:
* Bank register number, i.e. BankID originator ID as found in Norwegian IBAN-BIC Table
* Bank name
* Endpoint for RA resource providing OTP activation service as described in [BankID app API guide](https://github.com/vippsas/bankid-app-api/blob/master/bankid-app-api.md).

In return we will provide 
* Address of the Vipps server sending the request to the BankID RA 
* Certificate for verifying the requests sent by this server
* A keyid naming the certificate used for the requests sent by this server
* Administration url, client_id and client_secret to control endusers' BankID app activation status in Vipps 
* Description of the administration api
* Signed example request and the public certificate used in preproduction  

Please make sure that the requests from the Vipps server are allowed through firewalls etc. 

