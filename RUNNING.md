# db-code-interview

RUNNING INSTRUCTIONS

It is the Spring Boot Application exposing a Rest API to perform basic database operations on files in a file system.

After running the service, the port is 8021 and context path is db-code-interview as configured in the application.yml
config file and could be customized; that is, the app url will be set to the following:

http://localhost:8021/db-code-interview

API endpoints that should be tested are as shown below:
/insert   -   to insert a new row to a table (file)
/update   -   to update previously inserted row of a specified table with new values
/select   -   to retrieve values of a specified row in a table

Complete link:
http://localhost:8021/db-code-interview/{operation} - where {operation} is one of the API methods mentioned above,
i.e., insert, update, select

http://localhost:8021/db-code-interview/insert [POST]   (to test inserting)
http://localhost:8021/db-code-interview/update [POST]   (to test updating)
http://localhost:8021/db-code-interview/select [POST]   (to test retrieval)

Swagger API is also connected to the service. To test using Swagger, browse the link below:

http://localhost:8021/db-code-interview/swagger-ui/index.html

That's all, enjoy testing.
