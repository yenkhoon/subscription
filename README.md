# subscription
Subscription Service

# Pre-requisite
- [Java SE 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
# Details
- 1. Feel free to edit the ports which exposed for rest service in application.properties

# To TEST
- 1. Use [POSTMAN](https://www.postman.com/downloads/)
- 2. Open postman and put in the url `localhost:26657/subscribe/`
- 3. Set it to post request and put this json into the request body `{"amount":19,"subType" : "DAILY","subDate" : "2020-12-16"}`, then press send.
