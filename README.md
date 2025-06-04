# BankID app integration
This guide describes how to integrate the BankID App as an HA2 mechanism for a BankID issuing bank.

### Preconditions
End users having one or more NetCentric BankIDs may use BankID App as an HA2 mechanism.

Controlling OTP mechanisms is the bank's RA responsibility. BankID does not access the BankID ODS system.

If the bank opens its RA for calls from BankID, then end users may activate and connect BankID App 
to their Netcentric BankID with no manual interaction from the bank. 

### BankID using RA

Activating the BankID APP requires that the end user authenticates using BankID or BankID on Mobile, then BankID 
will call the BankID issuing RA to enable BankID App as an additional OTP mechanism.

#### Deprecated: Activation without Code Device

Previously there was provided a set of apis allowing the user to activate BankID app without using code device - _Activation without Code Device_ aka _Self Service Activation_. This api is now considered deprecated and shall not be considered by new implementors.

### Links
  
For information about API keys, product activation, etc see [Getting Started](../main/bankid-app-getting-started.md).

For API documentation and development guidelines please see our [BankID app API guide](../main/bankid-app-api.md).

You can peruse the SPI reference documentation as [Swagger](https://bankidnorge.github.io/bankid-app-activation-spi/) or [ReDoc](https://bankidnorge.github.io/bankid-app-activation-spi/redoc.html).
