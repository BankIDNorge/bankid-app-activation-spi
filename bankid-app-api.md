# BankID app API guide

The BankID app is an HA2-mechanism (OTP) in the BankID infrastructure. The name of this HA2-mechanism is _bapp_.
The RA-system of the bank issuing the enduser's BankID must support the _bapp_ HA2-mechanism. 

When an enduser downloads and activates the BankID app, Vipps will send one or more requests to the end user's 
BankID issuing RA to add the _bapp_ HA2 mechanism to the end user's NetCentric BankID. 
RA should then issue an OTPAdd against BankID ODS. 
Please see the BankID Core (COI) documentation for more information regarding the BankID HA2 mechanism.

## BankID app API endpoints offered by Vipps
Vipps offers an administration API allowing the bank issuing BankIDs to query if an end user has activated BankID app, and to enable/disable the app for a given end user.
Security is provided by OpenID connect (OIDC) access tokens, issued by BankID OIDC.

## BankID RA SPI endpoints required by Vipps
In order for Vipps to request BankID app to be added as an HA2-mechanism to an enduser's BankID, the bank must implement the SPI 
described here. 

### Security measures
The endpoints must be secured using signed HTTP messages according to the 
[Signing HTTP Messages](https://tools.ietf.org/html/draft-cavage-http-signatures-12) protocol. The requests sent by Vipps contains 
a Signature header as described in this protocol. The signature algorithm used is rsa-sha256. 
The receiver must verify the signature using the certificate received 
from Vipps as described in [Getting Started](https://github.com/vippsas/bankid-app-api/blob/master/bankid-app-getting-started.md). 

Implementation notes:
* The protocol defines two ways of sending the Signature, either in the _Authorization_ header or as a headervalue named _Signature_. 
Vipps uses the header _Signature_ variant.
* For source code generation based on this SPI the .json file seems less errorprone. The locale constant _no_ is 
translated into _FALSE_ when using the .yaml file and that causes errors. 
* [HTTP signature implementations](https://github.com/w3c-ccg/http-signatures/issues/1) offers a list of implementations for the protocol.
* The maven plugin _io.swagger.codegen.v3:swagger-codegen-maven-plugin:3.0.19_ may be used for code generation

### Request endpoints

Detailed description of the request endpoints are found in the SPI reference documentation as [Swagger](https://vippsas.github.io/bankid-app-api/) or [ReDoc](https://vippsas.github.io/bankid-app-api/redoc.html).

Endpoints are grouped by functionality. RA may implement all or some of these groups, depending on the functionality the RA supports. 

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/bankid-app-api/issues),
a [pull request](https://github.com/vippsas/bankid-app-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
