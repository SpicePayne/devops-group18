# USE CASE: City Reports

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Data Analyst, I want to generate various city-level population reports including all cities in the world, cities within a specific continent, region, country, or district, and the top N most populated cities globally, by continent, region, country, or district so that I can analyze and compare urban population distribution across multiple geographic levels for the organization.

### Scope
World Population Reporting System

### Level
Primary task

## Preconditions
- The database (world.sql) is connected and loaded.
- The user is logged into the system interface (CLI or GUI).
- City data is properly linked to country, region, and continent data.
- Valid continent, region, country, and district names exist in the database.
- For "Top N" reports, a valid integer (N) is provided by the user.

### Success End Condition
The system successfully generates and displays a formatted list of cities meeting the user's selection criteria, sorted by population in descending order.

### Failed End Condition
Invalid input, no matching results, or a database connection/query failure prevents the report from being generated or displayed.

### Primary Actor
Data Analyst

### Trigger
The user selects a City Report option from the main Population Reports Menu:
- **7** - All cities in world
- **8** - All cities in a continent
- **9** - All cities in a region
- **10** - All cities in a country
- **11** - All cities in a district
- **12** - Top N cities in world
- **13** - Top N cities in a continent
- **14** - Top N cities in a region
- **15** - Top N cities in a country
- **16** - Top N cities in a district

## MAIN SUCCESS SCENARIO

1. The user opens the World Population Reporting System.
2. The system displays the main Population Reports Menu with numbered options (0-32).
3. The user selects a City Report option from the main menu (7-16).
4. Depending on the selection:
   - **Option 7**: System immediately generates and displays all cities report
   - **Option 8**: System displays continent submenu with numbered options (1-7) and prompts "Select Continent:"
   - **Option 9**: System displays region submenu with numbered options (1-25) and prompts "Select Region:"
   - **Option 10**: System displays country submenu with numbered options (1-259) and prompts "Select Country:"
   - **Option 11**: System displays district submenu with numbered options (1-1367) and prompts "Select District:"
   - **Option 12**: System prompts "Enter N:" for the top N value, then generates report
   - **Option 13**: System displays continent submenu, user selects continent, then system prompts "Enter N:"
   - **Option 14**: System displays region submenu, user selects region, then system prompts "Enter N:"
   - **Option 15**: System displays country submenu, user selects country, then system prompts "Enter N:"
   - **Option 16**: System displays district submenu, user selects district, then system prompts "Enter N:"
5. The user provides required inputs through numbered menu selections or numeric N values.
6. The system validates all inputs.
7. The system executes the relevant SQL query based on the selected report type.
8. The system retrieves the appropriate dataset from the database.
9. The system formats and displays the report in tabular format with columns: `Name | Country | District | Population`
10. The user reviews the report on-screen.
11. The system returns to the main menu for additional report selections.

## EXTENSIONS

### 6a. Invalid Input
- User enters an invalid menu option number, System displays:
  "Invalid entry. Please enter a correct report option number."

### 6b. Invalid N Value
- User enters a non-numeric, zero, or negative N, System displays:
  "Invalid value. Please enter a positive whole number."

### 8a. Database Connection Error
- If the database connection fails, System logs the error and displays:
  "Unable to retrieve data. Please check database connection."

### 8b. Query Returns No Results
- If no records match filters, System displays:
  "No data available for the selected criteria."

### 10a. Display Error
- If rendering fails, System displays:
  "Unable to display report. Please retry."

## SUB-VARIATIONS
- Reports may be exported as CSV or PDF, or viewed on-screen.
- "Top N" reports may support configurable sorting options (by population, name, or region).
- System may allow batch generation of multiple report types in a single session.
- Future versions may include advanced filters (e.g., "Top 10 cities in Asia within coastal regions").

## SCHEDULE
- **Due Date:** Release 3.0 (Base reports [User stories 7–11])
- **Due Date:** Release 4.0 (Top N and batch reports [User stories 12–16])
