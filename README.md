# BFHL REST API - Acropolis Campus Hiring

A production-grade Spring Boot REST API that processes arrays of strings and returns categorized results.

## Project Description

This API exposes a single POST endpoint `/bfhl` that accepts an array of strings containing numbers, alphabets, and special characters, then processes and categorizes them according to specific business rules.

## Tech Stack

- Java 17+
- Spring Boot 3.x
- Maven
- Jakarta Bean Validation

## How to Build

```bash
mvn clean package
```

## How to Run Locally

```bash
java -jar target/bfhl-api-0.0.1-SNAPSHOT.jar
```

The application will start on port 8080.

## API Endpoint

### POST /bfhl

**Request Body:**
```json
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

**Response Body:**
```json
{
  "is_success": true,
  "user_id": "john_doe_17091999",
  "email": "john@xyz.com",
  "roll_number": "ABCD123",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

## Sample cURL Request

```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{
    "data": ["a", "1", "334", "4", "R", "$"]
  }'
```

**Expected Response:**
```json
{
  "is_success": true,
  "user_id": "john_doe_17091999",
  "email": "john@xyz.com",
  "roll_number": "ABCD123",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

## Deployment Instructions for Render

1. Connect your GitHub repository to Render
2. Create a new Web Service
3. Use the following settings:
   - **Build Command:** `mvn clean package`
   - **Start Command:** `java -jar target/bfhl-api-0.0.1-SNAPSHOT.jar`
   - **Environment:** Java 17

## Business Logic

- **Numbers:** Separated into odd and even arrays
- **Alphabets:** Converted to uppercase, used for concat_string calculation
- **Special Characters:** All non-numeric, non-alphabetic characters
- **Sum:** Total of all numeric values
- **Concat String:** Complex alternating case transformation of reversed alphabetic characters

## Configuration

Before deployment, update the constants in `BfhlServiceImpl.java`:
- `USER_ID`: Your name and DOB in format `firstname_lastname_ddmmyyyy`
- `EMAIL`: Your college email address
- `ROLL_NUMBER`: Your college roll number