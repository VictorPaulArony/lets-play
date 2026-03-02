# API Testing with curl

This document provides curl commands to test the User Registration API endpoints.

## Base URL
```
http://localhost:8080/api/users
```

## Endpoints

### 1. User Registration
**Endpoint:** `POST /api/users/register`

**Description:** Register a new user

**Request Body (JSON):**
```json
{
    "username": "john_doe",
    "email": "john.doe@example.com",
    "role": "USER",
    "password": "securepassword123"
}
```

**curl Command:**
```bash
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "email": "john.doe@example.com",
    "role": "USER",
    "password": "securepassword123"
  }'
```

**Expected Response:**
```
HTTP/1.1 200 OK
Content-Type: text/plain
user registrsition successful
```

### 2. User Login
**Endpoint:** `POST /api/users/login`

**Description:** Authenticate a user

**Request Body (JSON):**
```json
{
    "email": "john.doe@example.com",
    "password": "securepassword123"
}
```

**curl Command:**
```bash
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john.doe@example.com",
    "password": "securepassword123"
  }'
```

**Expected Response:**
```
HTTP/1.1 200 OK
Content-Type: text/plain
login successful
```

## Notes

1. **Server Configuration:**
   - The application runs on port 8080
   - MongoDB is configured to run on localhost:27017
   - Database name: `lets_play_db`

2. **Authentication Issues:**
   Fixed: The login endpoint now correctly uses a single User object for parameter binding instead of separate @RequestBody parameters.

3. **Required Setup:**
   - Ensure MongoDB is running on localhost:27017
   - Start the Spring Boot application before running these tests
   - The application will automatically create the `lets_play_db` database

4. **Response Format:**
   Both endpoints return plain text responses with HTTP 200 status codes.

## Troubleshooting

- **Connection refused:** Ensure the Spring Boot application is running
- **Database errors:** Verify MongoDB is accessible and running
- **JSON parsing errors:** Check that the request body is valid JSON
- **Authentication failures:** The login endpoint may not work correctly due to parameter binding issues