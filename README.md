## Article/Personal Notes Recorder

- SPRING Security is used to safeguard user data and prevent data breach

## Endpoints are :


### 1. POST /user/register

The request body should be in JSON format with the following structure:

```json
{
  "username": "exampleUser",
  "password": "examplePassword",
}
```
**RESPONSE** -> Response
                A 200 OK status is returned if the user is successfully created. The response contains the registered user object:
```json
  {
  "username": "exampleUser",
  "password": "hashedPassword",
  "id":"Long value",
  "articles":"List<Articles>"
   }
```

### 2. POST /user/login

The request body should be in JSON format with the following structure:

```json
{
  "username": "exampleUser",
  "password": "examplePassword"
}

```
**RESPONSE** -> Response
                On successful login, a 200 OK status is returned with JWT Token

> jwtToken


### 3. GET /user/current-user-name



**RESPONSE** -> Response
                A 200 OK status is returned if the user is successfully created. The response contains the registered user object:
> "exampleUserName"



# Articles API

This API allows users to create and retrieve articles using RESTful endpoints. The application is built using Spring Boot and exposes the following endpoints.

## Endpoints

### 1. Create a New Article
Create a new article by sending a POST request with article details.

- **URL**: `/articles/new-article`
- **Method**: `POST`
- **Request Body**: JSON representing the new article.
- **Response**: Returns the created article as a JSON object.

#### Request:

```json
{
  "articleTitle": "The Future of Technology",
  "article": "In this article, we explore upcoming tech trends...",
}
```

#### Response:

```json
{
  "articleTitle": "The Future of Technology",
  "article": "In this article, we explore upcoming tech trends...",
  "articleID":"Long value"
}
```
### 2. Get all articles of `a Person`
Create a new article by sending a POST request with article details.

- **URL**: `/get-all-articles`
- **Method**: `GET`
- **Request Body**: `NO REQUEST BODY`
- **Response**: Returns the created article as a JSON object.

#### Response:

```json
{
    {
        "articleTitle": "The Future of Technology",
        "article": "In this article, we explore upcoming tech trends...",
        "articleID":"Long value"
    },
    {
        "articleTitle": "The Future of Technology",
        "article": "In this article, we explore upcoming tech trends...",
        "articleID":"Long value"
    },
}
```


