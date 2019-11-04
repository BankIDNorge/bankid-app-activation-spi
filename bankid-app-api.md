# BankID app API guide

The BankID app is a HA2-mechanism in the BankID infrastructure. This implies that the RA-system of the bank issuing the users 
BankID must support the HA2-mechanism _bapp_. When a user downloads and activates the BankID app, Vipps will send 
a request to the issuing bank to add the _bapp_ HA2 mechanism (OTP) to the users BankID. Please see the 
BankID Core (COI) documentation for more information on the BankID HA2 mechanism.

## BankID app API
Vipps offers an administration API allowing the bank issuing BankIDs to query if a user has activated BankID app, and to enable/disable the app for a given user. Security is provided by OpenID connect (OIDC) access tokens, issued by BankID OIDC.

## API endpoints required by Vipps from the bank
In order for Vipps to request BankID app to be added as HA2 mechanism for a users BankID, the bank must implement the API 
described here. 

### Request endpoints
In order for Vipps to request BankID app to be added as OTP mechanism for a users BankID, the servcie described in the list below must be offered by the bank. 
The endpoints must accept signed HTTP messages according to the 
[Signing HTTP Messages](https://tools.ietf.org/html/draft-cavage-http-signatures-12) protocol. The requests sent by Vipps contains 
a Signature header as described in the protocol. The signature algorithm used is rsa-sha256. All the request headers listed below 
are included in the signature. The receiver must verify the signature using the certificate acquired 
from Vipps as described in [Getting Started](https://github.com/vippsas/bankid-app-api/blob/master/bankid-app-getting-started.md). 

| Service | Verb | Response Schema: application/json | Description |
| ----------- | ----------- | ----------- | ----------- |
| BankID app Status | `GET` | status: ENABLED / NOT_ENABLED / NOT_AVAILABLE / BANK_ID_NOT_AVAILABLE / BLOCKED_BY_BANK / BLOCKED_IN_ODS |  Request the status of the _bapp_ HA2 service of the BankID of the given user |
| Add BankID app | `PUT` | status: ENABLED / NOT_ENABLED / ALREADY_ENABLED / NOT_AVAILABLE / BANK_ID_NOT_AVAILABLE / BLOCKED_BY_BANK / BLOCKED_IN_ODS | Request the _bapp_ HA2 service to be added to the BankID of the given user |
| Delete BankID app | `DELETE` | status: DELETED / NOT_ENABLED / BLOCKED_IN_ODS | Request the _bapp_ HA2 service to be removed from the BankID of the given user |

The requests sent by Vipps includes the following headers:

| Header | Description | Example value |
| ----------- | ----------- | ----------- |
| Signature | The signature produced with Vipps private key | - |
| Date | Standard http date header | Mon, 16 Sep 2019 12:12:21 GMT |
| X-CLIENT-CLIENTNAME | The BankDI app client name | vipps-bapp-client |
| X-DATAOWNERORGID | BankID originator ID | 2811 |
| X-CLIENT-REQUESTID-HEADER | Unique identifier of the request (e.g. used as log reference) | 90921bc0-3550-47ec-ada5-f79ae86bad95 |
| X-CUSTOMERID | Norwegian National identity number | 12063035716 |

**Successful responses** should be returned with HTTP status code 200 and contain a JSON body with a _status_ value.
Response example:  
`{
  "status": "ENABLED"    
}`
The following statuses may be returned in the response messages:
 
| Status | Description |
| ----------- | ----------- |
| ENABLED | OTP BankID app is enabled for the customer |
| NOT_ENABLED | OTP BankID app is not enabled, but could be |
| ALREADY_ENABLED | OTP BankID app  was already enabled |
| NOT_AVAILABLE | OTP BankID app is not available for the bank |
| BANK_ID_NOT_AVAILABLE | Customer doesn't have an active BankID |
| BLOCKED_BY_BANK | Customer is not allowed to use BankID app |
| BLOCKED_IN_ODS | OTP BankID app is connected to the BankID, but was blocked by ODS because of to many failed attempts |
| DELETED | OTP BankID app was successfully deleted | 

**Error responses** from  should be returned with HTTP status code 401 or code 500.

# Questions?

We're always happy to help with code or other questions you might have!
Please create an [issue](https://github.com/vippsas/bankid-app-api/issues),
a [pull request](https://github.com/vippsas/bankid-app-api/pulls),
or [contact us](https://github.com/vippsas/vipps-developers/blob/master/contact.md).
