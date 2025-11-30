# USE CASE: Language Reports

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Data Analyst, I want to view how many people speak specific languages (Chinese, English, Hindi, Spanish, Arabic) and what percentage of the world population they represent so that I can understand global language distribution and present comparative statistics for the organization.

### Scope
World Population Reporting System

### Level
Primary task

## Preconditions
- The database (world.sql) is connected and accessible.
- Language speaker data (or mappings between countries and languages) exist and are up to date.
- World population total can be calculated or retrieved from the system.
- The user is logged into the system interface (CLI or GUI).

### Success End Condition
The system successfully displays for each selected language the total number of speakers and their percentage of the world population, sorted from largest to smallest.

### Failed End Condition
The report fails to generate due to missing language data, incorrect mappings, invalid world population value, or database/query errors.

### Primary Actor
Data Analyst

### Trigger
The user selects Language Report option **32** from the main Population Reports Menu.

## MAIN SUCCESS SCENARIO

1. The user opens the World Population Reporting System.
2. The system displays the main Population Reports Menu with numbered options (0-32).
3. The user selects **Option 32** - Language population report from the main menu.
4. The system immediately executes SQL queries to calculate:
   - Total speakers for each key language (Chinese, Hindi, Spanish, English, Arabic)
   - World total population
   - Percentage of world population for each language
5. The system retrieves the dataset from the database.
6. The system formats and displays the report in tabular format with columns: `Language | Speakers | %World`
7. The system sorts results by number of speakers in descending order.
8. The user reviews the report on-screen.
9. The system returns to the main menu for additional report selections.

## EXTENSIONS

### 4a. Database Connection Error
- If database connection fails, System logs the error and displays:
  "Unable to retrieve language data. Please check database connection."

### 4b. Missing Language Data
- If language data is incomplete, System displays:
  "Language data not available for some languages."

### 4c. World Population Calculation Error
- If world population cannot be calculated, System displays:
  "Unable to compute percentages: world population unavailable."

### 6a. Display Error
- If rendering fails, System displays:
  "Unable to display report. Please retry."

## SUB-VARIATIONS
- The report can be exported as CSV, PDF, or Excel.
- Future enhancement may include graphical visualization (e.g., pie or bar chart showing global language distribution).
- Additional languages beyond the default five may be added in future versions.

## SCHEDULE
- **Due Date:** Release 5.0 (Base reports – User stories 17–19)
- **Due Date:** Release 6.0 (Top N reports – User stories 20–22)
