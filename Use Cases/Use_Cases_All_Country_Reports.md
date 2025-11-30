# USE CASE: Country Reports

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Data Analyst, I want to generate various country-level population reports including all countries, countries within a specific continent, region, and the top N most populated countries globally, within a specific continent and region so that I can analyze and compare population distribution across different geographic levels for the organization.

### Scope
World Population Reporting System

### Level
Primary task

## Preconditions
- The database (world.sql) is connected and loaded.
- The user is logged into the system interface (CLI or GUI).
- Country data (code, name, continent, region, population, capital) is present in the database.
- For continent- or region-based reports, valid names exist in the database.
- For "Top N" reports, a valid integer (N) is provided by the user.

### Success End Condition
The system successfully generates and displays a formatted list of countries meeting the user's selection criteria, sorted by population in descending order.

### Failed End Condition
Invalid input, no matching results, or a database connection/query failure prevents the report from being generated or displayed.

### Primary Actor
Data Analyst

### Trigger
The user selects a Country Report option from the main Population Reports Menu:
- **1** - All countries in world
- **2** - All countries in a continent
- **3** - All countries in a region
- **4** - Top N countries in world
- **5** - Top N countries in a continent
- **6** - Top N countries in a region

## MAIN SUCCESS SCENARIO

1. The user opens the World Population Reporting System.
2. The system displays the main Population Reports Menu with numbered options (0-32) organized by categories (Countries, Cities, Capitals, etc.)
3. The user selects a Country Report option from the main menu (1-6).
4. Depending on the selection:
   - **Option 1**: System immediately generates and displays all countries report
   - **Option 2**: System displays continent submenu with numbered options (1-7) and prompts "Select Continent:"
   - **Option 3**: System displays region submenu with numbered options (1-25) and prompts "Select Region:"
   - **Option 4**: System prompts "Enter N:" for the top N value, then generates report
   - **Option 5**: System displays continent submenu, user selects continent, then system prompts "Enter N:"
   - **Option 6**: System displays region submenu, user selects region, then system prompts "Enter N:"
5. The user provides required inputs through numbered menu selections or numeric N values.
6. The system validates all inputs.
7. The system executes the relevant SQL query based on the selected report type.
8. The system retrieves the appropriate dataset from the database.
9. The system formats and displays the report in tabular format with columns: `Code | Name | Continent | Region | Population | Capital`
10. The user reviews the report on-screen.
11. The system returns to the main menu for additional report selections.

## EXTENSIONS

### 6a. Invalid Input
- User enters an invalid menu option number or sub menu option number. System displays:
  "Invalid entry. Please enter a correct report option number."

### 6b. Invalid N Value
- User enters a non-numeric, zero, or negative N, System displays:
  "Invalid value. Please enter a positive whole number."

### 8a. Database Connection Error
- If database connection fails, System logs the error and displays:
  "Unable to retrieve data. Please check database connection."

### 10a. Display Error
- If rendering fails, System displays:
  "Unable to display report. Please retry."

## SUB-VARIATIONS
- Reports may be exported as CSV or PDF, or viewed on-screen.
- "Top N" reports may support configurable sorting options (by population, name, or region).
- System may allow batch generation of multiple report types in a single session.
- Future versions (Release 2.0+) may include filter chaining (e.g., "Top 10 countries in Africa by region").

## SCHEDULE
- **Due Date:** Release 1.0 (base reports [users story 1-3])
- **Due Date:** Release 2.0 (Top N and batch reports user [user story 4-6])
