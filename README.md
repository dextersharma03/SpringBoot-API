# SpringBoot-API
Java Spring Boot API

Using this API, user can request, make, delete or update the information of books stored in the JSON file.

To perform the CRUD operations:

To Install, follow below steps:
### Clone the repo
### Go to InMemoryBookDAO class, go into the parse method and change the location of the json file to match with your directory
### Run the program

Using Postman, perform the below operations:
### POST request:
  ### http://localhost:8080/api/books/
    # Body: {
              "title":"Any",
              "author":"Test",
              "publisher":"AnyTest"
            }
            
### GET request:
  ### http://localhost:8080/api/books/
  
### DELETE request:
  ### http://localhost:8080/api/books/1
  
### PUT request:
  ### http://localhost:8080/api/books/2/
    # Body: {
              "title":"PutAny",
              "author":"Test2",
              "publisher":"PutAnyTest"
            }
