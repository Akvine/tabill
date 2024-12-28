# Tabill

## Overview
This application is built with **Java 21** and **Spring Boot** to convert tabular files (e.g., Excel, CSV) into SQL files

---

## Features
- **Supports multiple input formats:** CSV, XLSX.
- **Customizable SQL script generation:** Choose table name and column mappings.
- **Batch processing:** Handle large datasets efficiently.
- **REST API integration:** Simple HTTP endpoints for file upload and conversion.

---

## Requirements
- **Java:** 21 or higher
- **Maven:** 3.8+ (for building the project)
- **Database Compatibility:** SQL scripts generated are compatible with most relational databases like MySQL, PostgreSQL, and SQLite.

---

## Installation

### Clone the repository:
```bash
$ git clone https://github.com/Akvine/tabill.git
$ cd tabill
```

### Build the project:
```bash
$ mvn clean install
```

### Run the application:
```bash
$ java -jar target/tabill-0.0.1.jar
```

---

## Usage

### REST API Endpoints

#### 1. Upload a file for conversion:
**Endpoint:**
```
POST /tabill/convert
```
**Parameters:**
- `file` (MultipartFile): The tabular file to be converted.
- `tableName` (String): Name of the table in the SQL script.
- `separator` (String): Separator for csv file parsing.
- `skipLinesCount` (Integer): Count lines to skip before convert.

**Example cURL Command:**
```bash
curl -X POST -F "file=@example.xlsx" -F "tableName=my_table" http://localhost:8080/tabill/convert
```

**Response:**
- Returns the generated SQL script as a downloadable file.

---

## Configuration
The application uses a `application.properties` file for configuration

---

## Example Output
Input File (`example.csv`):
```
ID,Name,Age
1,Alice,25
2,Bob,30
```
Generated SQL File (`output.sql`):
```sql
INSERT INTO my_table (ID, Name, Age) VALUES (1, 'Alice', 25);
INSERT INTO my_table (ID, Name, Age) VALUES (2, 'Bob', 30);
```

---

## Development

### Prerequisites
- Ensure Java 21 is installed.
- Use your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

### Running in Development Mode
```bash
$ mvn spring-boot:run
```

---

## Testing
Run unit tests with:
```bash
$ mvn test
```
Test coverage reports are generated using JaCoCo and can be found in `target/site/jacoco/index.html`.

---

## Contribution
- Fork the repository.
- Create a new branch for your feature or bugfix.
- Submit a pull request with detailed information about your changes.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
