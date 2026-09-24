# British Spoken Time

A Java CLI application that converts a time provided in `HH:MM` format into its British spoken form.

The project was created as a coding challenge and focuses on clean Java design, readability, testability, and well-defined handling of input and time-conversion rules.

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/Subh-D/timeSpokenForm.git
cd timeSpokenForm
```

### 2. Build the project

```bash
mvn clean package
```

### 3. Run the application

```bash
java -jar target/<jar-name>.jar
```

Alternatively, if the project is configured with the Maven exec plugin, the application can be run using the corresponding Maven command.

### 4. Enter a time

For example:

```text
Enter time (HH:MM): 05:20
```

Output:

```text
twenty past five
```

## Running Tests

Run the complete test suite with:

```bash
mvn test
```

The tests cover input validation and British spoken-time conversion, including boundary cases and the examples provided in the challenge.

## Example

```text
Input:  05:20
Output: twenty past five
```

Other examples:

| Input   | Output                 |
| ------- | ---------------------- |
| `01:00` | `one o'clock`          |
| `04:15` | `quarter past four`    |
| `05:20` | `twenty past five`     |
| `07:30` | `half past seven`      |
| `06:32` | `six thirty-two`       |
| `07:35` | `twenty-five to eight` |
| `09:45` | `quarter to ten`       |
| `11:55` | `five to twelve`       |
| `00:00` | `midnight`             |
| `12:00` | `noon`                 |

## Requirements

* Java 21 or later
* Maven 3.9+ recommended

## Technology Stack

* **Java 21** — application language
* **Maven** — build and dependency management
* **JUnit 5** — unit testing
* **Java CLI** — user interaction
* No database
* No Spring Boot
* No external runtime framework

## Input Format

The application accepts time in the following format:

```text
HH:MM
```

### Valid examples

```text
00:00
01:05
09:30
12:00
23:59
```

### Invalid examples

```text
1:05
01:5
1:5
01-05
0105
01:05:00
```

Hours must be between `00` and `23`.

Minutes must be between `00` and `59`.

Leading and trailing whitespace is not accepted.

## Design

The application follows a simple separation of responsibilities:

```text
User Input
    |
    v
TimeInputValidator
    |
    v
Time
    |
    v
BritishTimeConverter
    |
    v
Spoken Time
```

### Main

Responsible for CLI interaction and displaying the result or error message.

### TimeInputValidator

Responsible for validating the `HH:MM` input format and creating a valid `Time` object.

### Time

Represents a valid time using an immutable Java record.

### BritishTimeConverter

Contains the business logic for converting a valid `Time` into its British spoken form.

### InvalidTimeException

Represents invalid user input or invalid time values.

## Java Features

The project uses modern Java features where they provide value, including:

* Java records for the immutable `Time` domain object
* Switch expressions
* Local variable type inference (`var`) where it improves readability
* Modern Java syntax and APIs

The implementation intentionally avoids unnecessary frameworks and abstractions because the problem is small and self-contained.

## Design Principles

The implementation aims to follow:

* **KISS** — Keep the solution simple and focused.
* **DRY** — Avoid unnecessary duplication, particularly in reusable conversion logic.
* **YAGNI** — Avoid introducing infrastructure or abstractions that are not required by the problem.
* **Single Responsibility Principle** — Keep input handling, domain representation, conversion logic, and CLI interaction separated.

Design patterns are used only where they provide a clear benefit rather than being introduced solely for the sake of using a pattern.

## Error Handling

Invalid input produces a meaningful error message.

Examples:

```text
Input is required.
```

```text
Invalid time format. Expected HH:MM.
```

```text
Invalid hour: 25. Hour must be between 00 and 23.
```

```text
Invalid minute: 60. Minute must be between 00 and 59.
```

## Future Improvements

Possible future enhancements include:

* Web-based UI
* Additional automated test coverage
* Further refactoring of number-to-word conversion
* Packaging improvements
* Containerized execution

These are intentionally kept outside the initial implementation to keep the core solution small and focused.
