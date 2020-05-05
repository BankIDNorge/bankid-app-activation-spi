# BankID app integration
This guide describes how to integrate the BankID App as an HA2 mechanism for a BankID issuing bank.

The bank needs to open it's BankID RA for calls from Vipps, so that Vipps can connect the BankID App with a BankID.
  
For information about API keys, product activation, etc see [Getting Started](https://github.com/vippsas/bankid-app-api/blob/master/bankid-app-getting-started.md).

For API documentation and development guidelines please see our [BankID app API guide](https://github.com/vippsas/bankid-app-api/blob/master/bankid-app-api.md).

You can peruse the API reference documentation as [Swagger](https://vippsas.github.io/bankid-app-api/) or [ReDoc](https://vippsas.github.io/bankid-app-api/redoc.html).

Building this documentation, run 

`mvn clean compile -f outgoingra`

the result will be placed in docs catalogue 
