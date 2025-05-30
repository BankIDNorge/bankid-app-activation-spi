# Build SPI Documentation

This guide describes how to build the SPI documentation for the BankID App activation.


To build a new version of the documentation, 
1. Change the java code and create a PR.
2. The pipeline builds the documentation automatically and places it in the `docs` directory on deploy.
3. If you want to see the generated files locally, run the following command in the root directory of the project:

`mvn clean compile -f outgoingra`

The result will be placed in docs catalogue.



