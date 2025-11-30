# USE CASE: Population Reports

## CHARACTERISTIC INFORMATION

### Goal in Context
As a Data Analyst, I want to generate various population and urbanization reports, including total, urban, and non-urban populations by continent, region, and country, as well as overall world and localized summaries (district and city), so that I can analyze demographic trends, measure urbanization rates, and compare population distribution across different geographic levels for the organization.

### Scope
World Population Reporting System

### Level
Primary task

## Preconditions
- The database (world.sql) is connected and accessible.
- The user is logged into the system interface (CLI or GUI).
- Country and city population data exist and are up to date.
- City and country tables are properly linked by continent, region, and country.
- Valid continent, region, country, district, and city names exist in the database.

### Success End Condition
The system successfully generates and displays aggregated or individual population data — including total, urban, and non-urban populations — in a clear, formatted report for the selected geographic level.

### Failed End Condition
The system fails to produce or display the report due to invalid input, missing or incomplete data, SQL query failure, or database connection errors.

### Primary Actor
Data Analyst

### Trigger
The user selects a Population Report option from the main Population Reports Menu:

**Population Reports:**
- **23** - Population by continent
- **24** - Population by region
- **25** - Population by country

**Population Lookups:**
- **26** - World population
- **27** - Population of a continent
- **28** - Population of a region
- **29** - Population of a country
- **30** - Population of a district
- **31** - Population of a city

## MAIN SUCCESS SCENARIO

1. The user opens the World Population Reporting System.
2. The system displays the main Population Reports Menu with numbered options (0-32).
3. The user selects a Population Report option from the main menu (23-31).
4. Depending on the selection:

   **Population Reports (23-25):**
   - **Option 23**: System immediately generates population by continent report
   - **Option 24**: System immediately generates population by region report
   - **Option 25**: System immediately generates population by country report

   **Population Lookups (26-31):**
   - **Option 26**: System immediately displays world population total
   - **Option 27**: System displays continent submenu (1-7) and prompts "Select Continent:"
   - **Option 28**: System displays region submenu (1-25) and prompts "Select Region:"
   - **Option 29**: System displays country submenu (1-239) and prompts "Select Country:"
   - **Option 30**: System displays district submenu (1-1367) and prompts "Select District:"
   - **Option 31**: System prompts "Enter city name:" for direct city input

5. The user provides required inputs through numbered menu selections or text input.
6. The system validates all inputs.
7. The system executes the relevant SQL query based on the selected report type.
8. The system retrieves the appropriate dataset from the database.
9. The system formats and displays the report:

   **For Population Reports (23-25):**
   - Columns: `Name | Total | CityPop | %City | NonCity | %Non`

   **For Population Lookups (26-31):**
   - Single value display: "[Area] population: [number]"
   - For districts/cities: Additional context (country name for districts)

10. The user reviews the report on-screen.
11. The system returns to the main menu for additional report selections.

## EXTENSIONS

### 6a. Invalid Menu Selection
- User enters an invalid menu option number, System displays:
  "Invalid entry. Please enter a correct report option number."

### 6b. Invalid Text Input
- User enters invalid city name or text, System displays:
  "Invalid entry. Please check the spelling or try again."

### 8a. Database Connection Error
- If database connection fails, System logs the error and displays:
  "Unable to retrieve data. Please check database connection."

### 8b. Query Returns No Results
- If no records match filters, System displays:
  "No population data found for the selected criteria."

### 10a. Display Error
- If rendering fails, System displays:
  "Unable to display report. Please retry."

## SUB-VARIATIONS
- Population reports (continent, region, country) include both numeric and percentage breakdowns.
- Population lookups provide single-value summaries for quick reference.
- Reports may be exported as CSV, PDF, or viewed on-screen.
- Future versions may include data visualization (charts, maps, dashboards).

## SCHEDULE
- **Due Date:** Release 7.0 (Continent, Region, Country population reports [Use Cases #23–25])
- **Due Date:** Release 9.0 (World, District, and City population summaries [Use Cases #26–31])
