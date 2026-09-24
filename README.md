# British Spoken Time

A Java CLI application that converts a time provided in `HH:MM` format into its British spoken form.

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

