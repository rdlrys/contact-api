# MS3 Contact API

Contact Management API that will take Address, Identification and Communication data model and store it to database. This service will support full CRUD operations.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on your local machine.

### Prerequisites

 - Java 1.8
 - Maven
 - Git Bash


### Running

1. Open Git Bash in the Project's root directory
2. Build Spring Boot Project with Maven maven package.
		: mvn clean install
3. Run Spring Boot app using Maven.
		: mvn spring-boot:run

### Testing

1. Create contact details using POST /contacts
	sample payload:
	{
    "identification": {
        "firstName": "Juan",
        "lastName": "Dela Cruz",
        "dateOfBirth": "01/01/2000",
        "gender": "M",
        "title": "Mr"
    },
    "address": [
        {
            "type": "home",
            "number": "1234",
            "street": "blah blah updated street",
            "unit": "1 a",
            "city": "somewhere",
            "state": "wv",
            "zipCode": "12345"
        }
    ],
    "communication": [
        {
            "type": "email",
            "value": "test@test.com",
            "preferred": "true"
        },
        {
            "type": "cell",
            "value": "091234567"
        }]
	}

2. Retrieve contact details using GET /contacts/{id}. 
3. Update contact details using PUT /contacts/{id}. 
	sample payload please refer to payload above.
4. Delete contact details using DELETE /contacts/{id}.

### Database
Please see src/main/resources/schema/database_schema.sql
Please see src/main/resources/templates/ERD_Template.png


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

 
## Authors

* **Rodel Reyes** - *Initial work* - 

