# BankID app getting started
This guide covers what you need to get started with BankID app development for a BankID issuing bank.

The following information must be provided to BankID support when requesting access to BankID app:
* Bank register number, i.e. BankID originator ID
* Bank name
* URL to RA resource providing OTP activation service as described in API documentation

In return we will provide you the address of the Vipps server sending the BankID app request. Please make sure that requests from 
these server are allowed through firewalls, etc. In addition we will provide the certificate for verifying the signed requests sent
by BankID app. Please return the keyID assigned to the key in your system.
