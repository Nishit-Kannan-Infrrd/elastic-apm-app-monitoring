# elastic-apm-app-monitoring
App monitoring using elastic APM

## Steps to build
* Clone the project
* Navigate to elastic-apm-app-monitoring/docker folder
* If building for the first time, then run `docker-compose up -d --build`, otherwise run `docker-compose up -d`.
* The following stack will be deployed
  * Postgres
  * [PGAdmin](http://localhost:5430/login) User id and password configured in docker compose under pgadmin service
  * Elastic Search
  * [Kibana](http://localhost:5601/)
  * Elastic APM
  * Sample Library Application
* Click on APM menu option in Kibana and set up APM
* Hit the following API to add a book
`curl --location --request POST 'http://localhost:8080/library/books/book' \
--header 'Content-Type: application/json' \
--data-raw '{
    "author": "Mr. B",
    "title": "Mr. B book"
}'`
* Navigate to [Kibana APM](http://localhost:5601/app/apm#/) and click on the library service. The transaction should be present.
