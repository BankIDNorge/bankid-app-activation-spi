# BankID app integration getting started
This guide covers what you need to get started with integrating BankID app infrastructure with your BankID RA.

The following information must be provided to BankID support when requesting integration with BankID app:
* Bank register number, i.e. BankID originator ID as found in Norwegian IBAN-BIC Table
* Bank name
* Endpoint for RA resource providing OTP activation service as described in [BankID app API guide](https://github.com/vippsas/bankid-app-api/blob/master/bankid-app-api.md).
* keyId to identify certificate used against this endpoint 

In return we will provide 
* Address of the Vipps server sending the request to the BankID RA 
* Certificate for verifying the requests sent by this server
* Administration url, client_id and client_secret to control endusers' BankID app activation status in Vipps 
* Description of the administration api

Please make sure that the requests from the Vipps server are allowed through firewalls etc. 

The certificate must be assigned a keyId which identifies this certificate in _your_ system. This keyId must be returned to Vipps.


[comment]: # (Heter det vipps support eller BankID support ?? )
 
[comment]: # (Lage sak for generelle header navn ?? )

[comment]: # (url for bapp admin snitt og client id+secret ?? )
