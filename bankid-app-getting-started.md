# BankID app getting started
This guide covers what you need to get started with BankID app development for a BankID issuing bank.

The request from Vipps are made from the server https://toba.bankidapis.no/. Please make sure that requests from these servers are allowed through firewalls, etc.

The following information must be provided BankID support when requesting access to BankID app:
* Bank register number, i.e. BankID originator ID
* Bank name
* url to RA resource providing OTP activation service as described in API documentation

Request the certificate for verifying the signed requests sent by BankID app. Return the keyID assigned in RA system
