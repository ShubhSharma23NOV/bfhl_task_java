# BFHL REST API - Acropolis Campus Hiring

**Student:** Shubh Sharma  
**Roll Number:** 0827CY231066  
**Email:** shubhsharma231358@acropolis.in  
**College:** Acropolis Institute of Technology and Research

A production-grade Spring Boot REST API that processes arrays of strings and returns categorized results for the Acropolis Campus Hiring challenge.

## 🎯 Project Description

This API exposes a single POST endpoint `/bfhl` that accepts an array of strings containing numbers, alphabets, and special characters, then processes and categorizes them according to specific business rules including a complex string concatenation algorithm.

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3.2.0**
- **Maven** (Build Tool)
- **Jakarta Bean Validation** (Input Validation)
- **Lombok** (Code Generation)

## 🏗️ Project Structure

```
bfhl-api/
├── src/main/java/com/acropolis/bfhl/
│   ├── BfhlApplication.java              # Main Spring Boot Application
│   ├── controller/
│   │   └── BfhlController.java           # REST Controller
│   ├── dto/
│   │   ├── BfhlRequest.java              # Request DTO
│   │   └── BfhlResponse.java             # Response DTO
│   ├── service/
│   │   ├── BfhlService.java              # Service Interface
│   │   └── BfhlServiceImpl.java          # Business Logic Implementation
│   └── exception/
│       ├── GlobalExceptionHandler.java   # Global Error Handler
│       └── InvalidInputException.java    # Custom Exception
├── src/main/resources/
│   └── application.properties            # Application Configuration
├── pom.xml                               # Maven Dependencies
├── Procfile                              # Deployment Configuration
└── README.md                             # Documentation
```

## 🚀 How to Build

```bash
mvn clean package
```

## ▶️ How to Run Locally

```bash
java -jar target/bfhl-api-0.0.1-SNAPSHOT.jar
```

The application will start on **port 8080**.

## 📡 API Endpoint

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
  "user_id": "shubh_sharma_23112005",
  "email": "shubhsharma231358@acropolis.in",
  "roll_number": "0827CY231066",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

## 🧪 Test Cases & Examples

### Example 1: Mixed Input
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["a", "1", "334", "4", "R", "$"]}'
```

**Response:**
```json
{
  "is_success": true,
  "user_id": "shubh_sharma_23112005",
  "email": "shubhsharma231358@acropolis.in",
  "roll_number": "0827CY231066",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

### Example 2: Larger Mixed Input
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["2", "a", "y", "4", "&", "-", "*", "5", "92", "b"]}'
```

### Example 3: Letters Only
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["A", "ABCD", "DOE"]}'
```

### Example 4: Validation Error (Empty Array)
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": []}'
```

**Error Response:**
```json
{
  "is_success": false,
  "message": "data array must not be empty",
  "user_id": null,
  "email": null,
  "roll_number": null,
  "odd_numbers": [],
  "even_numbers": [],
  "alphabets": [],
  "special_characters": [],
  "sum": "0",
  "concat_string": ""
}
```

## 🧠 Business Logic Explained

### Field Processing Rules:

1. **Numbers (odd_numbers, even_numbers):**
   - Parse strings that are purely numeric
   - Separate into odd and even arrays
   - Keep as strings in response

2. **Alphabets:**
   - Identify strings containing only alphabetic characters (a-z, A-Z)
   - Convert to uppercase for response
   - Multi-character strings like "ABCD" are treated as single elements

3. **Special Characters:**
   - All elements that are neither purely numeric nor purely alphabetic
   - Includes symbols, mixed strings, etc.

4. **Sum:**
   - Add all numeric values together
   - Return as string

5. **Concat String (Complex Algorithm):**
   - **Step 1:** Extract all individual characters from alphabetic elements
   - **Step 2:** Concatenate into single string
   - **Step 3:** Reverse the concatenated string
   - **Step 4:** Apply alternating case (index 0=upper, 1=lower, 2=upper, etc.)

### Concat String Example:
Input: `["a", "R"]`
- Step 1: Extract chars → `a, R`
- Step 2: Concatenate → `"aR"`
- Step 3: Reverse → `"Ra"`
- Step 4: Alternating case → `"Ra"` (R=upper, a=lower)

## 🔒 Input Validation

- **Required Field:** `data` array must not be null
- **Non-Empty:** `data` array must contain at least one element
- **JSON Format:** Request must be valid JSON
- **Error Responses:** All validation errors return HTTP 400 with `is_success: false`

## 🚀 Deployment Instructions

### For Render:
1. Connect this GitHub repository to Render
2. Create a new Web Service
3. Configure:
   - **Build Command:** `mvn clean package`
   - **Start Command:** `java -jar target/bfhl-api-0.0.1-SNAPSHOT.jar`
   - **Environment:** Java 17

### For Railway:
1. Connect repository to Railway
2. Railway will auto-detect the Java application
3. Uses the included `Procfile` for deployment

## 👨‍💻 Student Information

- **Name:** Shubh Sharma
- **Date of Birth:** 23/11/2005
- **Roll Number:** 0827CY231066
- **Email:** shubhsharma231358@acropolis.in
- **College:** Acropolis Institute of Technology and Research
- **Course:** Computer Science Engineering

## 📋 Features Implemented

✅ **Complete REST API** with POST /bfhl endpoint  
✅ **Input Validation** using Jakarta Bean Validation  
✅ **Error Handling** with proper HTTP status codes  
✅ **Complex Business Logic** including concat_string algorithm  
✅ **Production Ready** with proper logging and exception handling  
✅ **Deployment Configuration** for cloud platforms  
✅ **Comprehensive Documentation** with examples  

## 🧪 Testing Status

All test cases have been verified and are working correctly:
- ✅ Mixed input processing
- ✅ Numbers-only input
- ✅ Alphabets-only input  
- ✅ Special characters-only input
- ✅ Empty array validation
- ✅ Null data validation
- ✅ Malformed JSON handling

---

**Repository:** https://github.com/ShubhSharma23NOV/bfhl_task_java  
**Created for:** Acropolis Campus Hiring Challenge  
**Date:** May 2026