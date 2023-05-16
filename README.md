# BankID app integration
This guide describes how to integrate the BankID App as an HA2 mechanism for a BankID issuing bank.

### Preconditions
End users having one or more NetCentric BankIDs may use BankID App as an HA2 mechanism.

Controlling OTP mechanisms is the bank's RA responsibility. BankID does not access the BankID ODS system.

If the bank opens its RA for calls from BankID, then end users may activate and connect BankID APP 
to their Netcentric BankID with no manual interaction from the bank. 

### BankID using RA

Activating the BankID APP requires that the end user authenticates using BankID or BankID on Mobile, then BankID 
will call the BankID issuing RA to enable BankID App as an additional OTP mechanism.

The RA may implement different degrees of functionality  
* _OTP Administration_ which is the basic operations used by BankID to enable or disable BankID App as an OTP mechanism.
* _Activation without Code Device_ which enables use cases where the end user does not have another code device.   

Supporting the basic _OTP administration_ SPI is sufficient to add BankID App to end users already having a Netcentric BankID.

Supporting the _Activation without Code Device_ SPI will in addition make it possible for BankID to enable BankID App 
in use cases where the end user does not have a way to authenticate, for example no other code device.

### RA using Vipps 

BankID offers an API to inspect and modify the bank's end users BankID App relation.     
  
### Links
  
For information about API keys, product activation, etc see [Getting Started](../main/bankid-app-getting-started.md).

For API documentation and development guidelines please see our [BankID app API guide](../main/bankid-app-api.md).

You can peruse the SPI reference documentation as [Swagger](https://bankidnorge.github.io/bankid-app-activation-spi/) or [ReDoc](https://bankidnorge.github.io/bankid-app-activation-spi/redoc.html).

Building this documentation, run 

`mvn clean compile -f outgoingra`

the result will be placed in docs catalogue 
