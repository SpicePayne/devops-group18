# USE CASE: Capital City Reports

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Data Analyst, I want to generate various capital city population reports including all capital cities in the world, capital cities within a specific continent or region, and the top N most populated capital cities globally, by continent, or by region so that I can analyze and compare administrative population distributions across different geographic levels for the organization.

### Scope
World Population Reporting System

### Level
Primary task

## Preconditions
- The database (world.sql) is connected and operational.
- The user is logged into the system interface (CLI or GUI).
- Country records correctly identify their respective capital cities.
- City and country tables are properly joined using the capital field or capital city ID.
- Valid continent and region names exist in the dataset.
- For "Top N" reports, the user provides a valid integer (N).

### Success End Condition
The system successfully generates and displays a formatted list of capital cities meeting the user's selected criteria, sorted by population in descending order.

### Failed End Condition
The system fails to generate or display the report due to invalid input, missing data, query failure, or a database connection error.

### Primary Actor
Data Analyst

### Trigger
The user selects a Capital City Report option from the main Population Reports Menu:
- **17** - All capitals in world
- **18** - All capitals in a continent
- **19** - All capitals in a region
- **20** - Top N capitals in world
- **21** - Top N capitals in continent
- **22** - Top N capitals in region

## MAIN SUCCESS SCENARIO

1. The user opens the World Population Reporting System.
2. The system displays the main Population Reports Menu with numbered options (0-32).
3. The user selects a Capital City Report option from the main menu (17-22).
4. Depending on the selection:
   - **Option 17**: System immediately generates and displays all capital cities report
   - **Option 18**: System displays continent submenu with numbered options (1-7) and prompts "Select Continent:"
   - **Option 19**: System displays region submenu with numbered options (1-25) and prompts "Select Region:"
   - **Option 20**: System prompts "Enter N:" for the top N value, then generates report
   - **Option 21**: System displays continent submenu, user selects continent, then system prompts "Enter N:"
   - **Option 22**: System displays region submenu, user selects region, then system prompts "Enter N:"
5. The user provides required inputs through numbered menu selections or numeric N values.
6. The system validates all inputs.
7. The system executes the relevant SQL query based on the selected report type.
8. The system retrieves the appropriate dataset from the database.
9. The system formats and displays the report in tabular format with columns: `Capital | Country | Population`
10. The user reviews the report on-screen.
11. The system returns to the main menu for additional report selections.

## EXTENSIONS

### 6a. Invalid Menu Selection
- User enters an invalid menu option number, System displays:
  "Invalid entry. Please enter a correct report option number."

### 6b. Invalid N Value
- User enters a non-numeric, zero, or negative N, System displays:
  "Invalid value. Please enter a positive whole number."

### 8a. Database Connection Error
- If database connection fails, System logs the error and displays:
  "Unable to retrieve data. Please check database connection."

### 8b. Query Returns No Results
- If no records match filters, System displays:
  "No capital city data available for the selected criteria."

### 10a. Display Error
- If rendering fails, System displays:
  "Unable to display report. Please retry."

## SUB-VARIATIONS
- Reports may be exported as CSV or PDF, or viewed on-screen.
- "Top N" reports may support configurable sorting options (by population, country name, or region).
- Users may apply optional filters such as minimum population thresholds.
- System may support dynamic adjustment of N to regenerate the report.
- Future versions may include cross-analysis features (e.g., comparing capital cities by GDP or density).

## SCHEDULE
- **Due Date:** Release 5.0 (Base reports [User stories 17–19])
- **Due Date:** Release 6.0 (Top N reports [User stories 20–22])
