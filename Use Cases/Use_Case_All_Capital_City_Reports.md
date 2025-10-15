# USE CASE #17: View all capital cities in the world by population (Capital City Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view all capital cities in the world ordered by population so that I can identify the largest global capitals and analyze how populations are distributed among them for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and loaded.
* Each country record correctly identifies its capital city.
* The user is logged into the system interface (CLI or GUI).
* City and country tables are properly joined on the capital field.

**Success End Condition**
The system successfully generates and displays a list of all capital cities in the world, sorted from largest to smallest population.

**Failed End Condition**
The system fails to produce the report due to missing capital data, invalid joins, or database query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects the Capital City Report then All (World) option from the main dashboard.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with available report categories.
3. The user selects Capital City Report.
4. The system displays options for Report Type (All, Continent, Region, Top N).
5. The user selects All (World).
6. The system executes a SQL query joining the city and country tables using the capital city ID to retrieve all capitals.
7. The system sorts results by population in descending order.
8. The system displays the formatted report with the following columns: **City Name, Country Name, Population**
9. The user reviews or exports the report as needed.

## EXTENSIONS
* **6a.** Missing capital entries in the database, System displays: "Some countries have no registered capital city."
* **6b.** Database query fails, System logs the error and displays: "Unable to retrieve capital city data. Please check database connection."
* **7a.** No capital data available, System displays: "No capital city information found."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or displayed in a pop-up table.
* The user may filter by population threshold (e.g., capitals over 1 million).

## SCHEDULE
**Due Date:** Release 5.0

---

# USE CASE #18: View all capital cities in a continent by population (Capital City Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view all capital cities within a selected continent ordered by population so that I can compare and analyze capitals across different continents for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* Each country has a valid capital city ID linked in the database.
* Valid continent names exist in the dataset.
* The user is logged into the system (CLI or GUI).

**Success End Condition**
The system successfully generates and displays a list of all capital cities within the specified continent, ordered from largest to smallest population.

**Failed End Condition**
The report fails to generate due to an invalid continent input, missing capital data, or database query error.

**Primary Actor**
Data Analyst

**Trigger**
The user selects the Capital City Report then by Continent option and provides a continent name.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with reporting options.
3. The user selects Capital City Report from the list.
4. The system shows report types (All, Continent, Region, Top N).
5. The user selects by Continent.
6. The system prompts the user to enter a continent name (e.g., "Asia").
7. The user enters a valid continent name.
8. The system executes a SQL query joining the city and country tables, filtering by the specified continent.
9. The system retrieves all capital cities linked to countries in that continent.
10. The system sorts the results by population in descending order.
11. The system displays the formatted report with the following columns: **City Name, Country Name, Population**
12. The user views or exports the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled continent name, System displays: "Invalid continent name. Please re-enter."
* **8a.** Database connection fails, System logs error and displays: "Database connection error. Please retry."
* **10a.** No capital cities found for the selected continent; System displays: "No data available for this continent."

## SUB-VARIATIONS
* The report may be exported in CSV, PDF, or displayed in an interactive table.
* The user may sort by country name instead of population.

## SCHEDULE
**Due Date:** Release 5.0

---

# USE CASE #19: View all capital cities in a region by population (Capital City Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view all capital cities within a specific region ordered by population so that I can identify and analyze major administrative centers within that region for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and operational.
* Valid region names exist within the database.
* Each country has an assigned capital city and region recorded.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully generates and displays a list of all capital cities located within the selected region, ordered from largest to smallest population.

**Failed End Condition**
The report fails due to an invalid or missing region input, missing capital data, or database query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Capital City Report then by Region from the dashboard and inputs a valid region name.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with reporting categories.
3. The user selects Capital City Report from the available options.
4. The system presents report type options (All, Continent, Region, Top N).
5. The user selects by Region.
6. The system prompts for a region name (e.g., "Caribbean").
7. The user enters a valid region name.
8. The system executes a SQL query joining the city and country tables, filtering by the specified region.
9. The system retrieves all capital cities associated with that region.
10. The system sorts the retrieved data by population in descending order.
11. The system displays the formatted report showing columns: **City Name, Country Name, Population**
12. The user views, analyzes, or exports the results.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled region name, System displays: "Invalid region name. Please try again."
* **8a.** Database query or join error occurs, System logs the error and displays: "Error retrieving capital city data. Please check database connection."
* **10a.** No capital cities found for the specified region; System displays: "No capital city data available for this region."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or viewed interactively on-screen.
* The user can optionally filter by minimum population threshold.

## SCHEDULE
**Due Date:** Release 5.0

---

# USE CASE #20: View top N capital cities in the world by population (Capital City Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the top N most populated capital cities in the world so that I can easily identify and compare the largest global administrative centers for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* Capital city and population data are complete and accurate.
* The user is logged into the system interface (CLI or GUI).
* The user knows the number N they wish to query (e.g., top 5, top 10).

**Success End Condition**
The system successfully generates and displays a list of the top N capital cities in the world, sorted from largest to smallest population.

**Failed End Condition**
The report fails to generate due to invalid input (non-numeric N), missing data, or database query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Capital City Report then Top N (World) and enters a numeric value for N.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with reporting categories.
3. The user selects Capital City Report.
4. The system displays available report types (All, Continent, Region, Top N).
5. The user selects Top N (World).
6. The system prompts the user to enter a numeric value for N (e.g., 10).
7. The user enters a valid positive integer.
8. The system executes a SQL query joining the city and country tables, filtering for all capital cities and ordering by population descending.
9. The system limits the results to the top N records.
10. The system displays the formatted report with the following columns: **City Name, Country Name, Population**
11. The user views, analyzes, or exports the report.

## EXTENSIONS
* **6a.** User enters a non-numeric or invalid N, System displays: "Invalid input. Please enter a whole number."
* **8a.** Database query fails, System logs error and displays: "Error retrieving capital city data. Please check the connection."
* **9a.** Fewer than N records available, System displays the available results and notes: "Only X capital cities found in the dataset."

## SUB-VARIATIONS
* The report can be exported in CSV, PDF, or viewed in a table format.
* The user may choose to include or exclude cities with missing population data.

## SCHEDULE
**Due Date:** Release 6.0

---

# USE CASE #21: View top N capital cities in a continent by population (Capital City Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the top N most populated capital cities within a selected continent so that I can compare the largest administrative centers across that continent for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and available.
* Valid continent names exist in the dataset.
* Each country record correctly identifies its capital city.
* The user is logged into the system (CLI or GUI).
* The user knows the number N (e.g., 5 or 10) to query.

**Success End Condition**
The system successfully generates and displays a list of the top N capital cities within the specified continent, ordered from largest to smallest population.

**Failed End Condition**
The system fails to generate the report due to an invalid continent name, invalid N value, missing capital data, or database query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Capital City Report then Top N by Continent from the main dashboard and provides both a continent name and a numeric value for N.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with report categories.
3. The user selects Capital City Report.
4. The system displays the available report types (All, Continent, Region, Top N).
5. The user selects Top N by Continent.
6. The system prompts the user to enter a continent name (e.g., "Europe").
7. The user enters a valid continent name.
8. The system prompts the user to enter a numeric value for N.
9. The user enters a valid integer (e.g., 10).
10. The system executes a SQL query joining the city and country tables, filtering for the selected continent's capital cities.
11. The query sorts the results by population in descending order and limits them to the top N records.
12. The system displays the formatted report with columns: **City Name, Country Name, Population**
13. The user views, analyzes, or exports the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled continent name, System displays: "Invalid continent name. Please re-enter."
* **8a.** User enters a non-numeric or invalid N value, System displays: "Invalid input. Please enter a valid whole number."
* **10a.** Database query fails, System logs the error and displays: "Unable to retrieve data. Please check connection."
* **11a.** Fewer than N capital cities exist for the selected continent, System displays: "Only X capital cities found for this continent."

## SUB-VARIATIONS
* The report may be exported as CSV, PDF, or viewed as an on-screen table.
* The user can adjust N dynamically to regenerate the report.

## SCHEDULE
**Due Date:** Release 6.0

---

# USE CASE #22: View top N capital cities in a region by population (Capital City Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the top N most populated capital cities within a selected region so that I can understand and compare the largest regional administrative centers for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and functioning properly.
* Valid region names exist in the database.
* Each country has an assigned capital city and region recorded.
* The user is logged into the system interface (CLI or GUI).
* The user knows the number N (e.g., 5, 10, 20) to query.

**Success End Condition**
The system successfully generates and displays a list of the top N capital cities in the specified region, ordered by descending population.

**Failed End Condition**
The report fails to generate due to an invalid region name, invalid N value, missing capital data, or a database query error.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Capital City Report then Top N by Region and inputs both the desired region name and numeric value for N.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with available report categories.
3. The user selects Capital City Report.
4. The system presents report type options (All, Continent, Region, Top N).
5. The user selects Top N by Region.
6. The system prompts the user to enter a region name (e.g., "Caribbean").
7. The user provides a valid region name.
8. The system prompts the user to enter a numeric value for N.
9. The user provides a valid integer (e.g., 10).
10. The system executes a SQL query joining the city and country tables, filtering by the specified region and identifying capital cities.
11. The query sorts results by population in descending order and limits to N results.
12. The system displays the formatted report with columns: **City Name, Country Name, Population**
13. The user views, saves, or exports the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled region name, System displays: "Invalid region name. Please re-enter."
* **8a.** User provides non-numeric N value, System displays: "Invalid input. Please enter a valid whole number."
* **10a.** Database query fails, System logs error and displays: "Error retrieving data. Please check database connection."
* **11a.** Fewer than N capital cities exist, System displays: "Only X capital cities found for the specified region."

## SUB-VARIATIONS
* The report may be exported as CSV, PDF, or viewed on-screen.
* The user may filter by alphabetical order.

## SCHEDULE
**Due Date:** Release 6.0
