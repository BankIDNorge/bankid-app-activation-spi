# BankID app API guide

The BankID app is an HA2-mechanism (OTP) in the BankID infrastructure. The name of this HA2-mechanism is _bapp_.
The RA-system of the bank issuing the enduser's BankID must support the _bapp_ HA2-mechanism. 

When an enduser downloads and activates the BankID app, Vipps will send 
a request to the enduser's BankID issuing bank to add the _bapp_ HA2 mechanism to the BankID. Please see the 
BankID Core (COI) documentation for more information regarding the BankID HA2 mechanism.

## BankID app API endpoints offered by Vipps
Vipps offers an administration API allowing the bank issuing BankIDs to query if an enduser has activated BankID app, and to enable/disable the app for a given enduser.
Security is provided by OpenID connect (OIDC) access tokens, issued by BankID OIDC.

[comment]: # (TODO: should be described)

## BankID RA API endpoints required by Vipps
In order for Vipps to request BankID app to be added as an HA2-mechanism to an enduser's BankID, the bank must implement the API 
described here. 

### Security measures
The endpoints must be secured using signed HTTP messages according to the 
[Signing HTTP Messages](https://tools.ietf.org/html/draft-cavage-http-signatures-12) protocol. The requests sent by Vipps contains 
a Signature header as described in this protocol. The signature algorithm used is rsa-sha256. All the request headers listed below 
are included in the signature. The receiver must verify the signature using the certificate received 
from Vipps as described in [Getting Started](https://github.com/vippsas/bankid-app-api/blob/master/bankid-app-getting-started.md). 

Note that the protocol defines two ways of sending the Signature, either in the _Authorization_ header or as a headervalue named _Signature_. 
Vipps uses the header _Signature_ variant.

### Request endpoints

| Service | Verb | Response Schema: application/json | Description |
| ----------- | ----------- | ----------- | ----------- |
| Status of BankID app | `GET` | status: ENABLED / NOT_ENABLED / NOT_AVAILABLE / BANK_ID_NOT_AVAILABLE / BLOCKED_BY_BANK / BLOCKED_IN_ODS |  Request the status of the _bapp_ HA2 service of the BankID of the given user |
| Add BankID app | `PUT` | status: ENABLED / NOT_ENABLED / ALREADY_ENABLED / NOT_AVAILABLE / BANK_ID_NOT_AVAILABLE / BLOCKED_BY_BANK / BLOCKED_IN_ODS | Request the _bapp_ HA2 service to be added to the BankID of the given user |
| Delete BankID app | `DELETE` | status: DELETED / NOT_ENABLED / BLOCKED_IN_ODS | Request the _bapp_ HA2 service to be removed from the BankID of the given user |

The requests sent by Vipps requires the following headers. None of the requests have a body. 

| Header | Description | Example value |
| ----------- | ----------- | ----------- |
| Signature | The signature produced with Vipps private key | _keyId="fa998090",algorithm="rsa-sha256",headers="(request-target) date x-client-clientname x-dataownerorgid x-client-requestid x-customerid",signature="o7zK892...."_ |
| (request-target) | Standard Http signature protocol header | _/api/enduser/bankid/netcentric/otp/bapp_
| Date | Standard http date header, GMT and english locale | _Mon, 16 Sep 2019 12:12:21 GMT_ |
| X-CLIENT-CLIENTNAME | The BankID app client name | always _vipps-bapp-client_ |
| X-DATAOWNERORGID | BankID originator ID | _2811_ |
| X-CLIENT-REQUESTID-HEADER | Unique identifier of the request (e.g. used as log reference) | _90921bc0-3550-47ec-ada5-f79ae86bad95_ |
| X-CUSTOMERID | Norwegian National identity number | _11111111016_ |

**Successful responses** should be returned with HTTP status code 200 and contain a JSON body with a _status_ value. 
Response example:  
`{
  "status": "BANK_ID_NOT_AVAILABLE"    
}`
The meaning of the following statuses are:
 
| Status | Description |
| ----------- | ----------- |
| ENABLED | OTP BankID app is enabled for the enduser |
| NOT_ENABLED | OTP BankID app is not enabled, but could be |
| ALREADY_ENABLED | OTP BankID app was already enabled |
| NOT_AVAILABLE | OTP BankID app is not available for the bank |
| BANK_ID_NOT_AVAILABLE | Enduser doesn't have an active Netcentric BankID |
| BLOCKED_BY_BANK | Enduser is not allowed to use OTP BankID app |
| BLOCKED_IN_ODS | OTP BankID app is connected to the BankID, but was blocked by ODS because of too many failed attempts |
| DELETED | OTP BankID app was successfully deleted | 

**Error responses** from Ra should be returned with HTTP status code 401. An non-200 status will stop BankID app 
activation for the enduser and require that the end user reactivates the BankID app.

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/bankid-app-api/issues),
a [pull request](https://github.com/vippsas/bankid-app-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
