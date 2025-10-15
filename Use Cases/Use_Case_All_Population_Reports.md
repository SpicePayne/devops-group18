# USE CASE #23: View population data per continent (Population Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population, number of people living in cities, and number of people not living in cities per continent so that I can analyze and compare urbanization levels across continents for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* City and country tables are properly linked by continent.
* Population data for both cities and countries are available and up to date.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully generates and displays the total, urban, and non-urban population figures for each continent, along with corresponding percentages.

**Failed End Condition**
The report fails to generate due to missing data, incorrect SQL joins, invalid query execution, or database connection failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Population Report then by Continent from the dashboard.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with reporting categories.
3. The user selects Population Report.
4. The system presents available report types (by Continent, by Region, by Country).
5. The user selects by Continent.
6. The system executes SQL queries to calculate:
   * Total population per continent.
   * Total population living in cities.
   * Total population not living in cities (calculated as total - city population).
   * Percentage of urban vs. non-urban population.
7. The system retrieves and aggregates population data for all continents.
8. The system displays the formatted report with columns: **Continent Name, Total Population, Population in Cities, % in Cities, Population not in Cities, % not in Cities**
9. The user reviews, analyzes, or exports the report.

## EXTENSIONS
* **6a.** Missing or incomplete data, System displays: "Population data incomplete for one or more continents."
* **6b.** Database connection fails, System logs error and displays: "Unable to connect to database. Please retry."
* **8a.** No results returned; System displays: "No population data found."

## SUB-VARIATIONS
* The report may be exported in CSV, PDF, or viewed as a formatted table.
* The user can filter results by specific continent(s) or choose to include percentages only.

## SCHEDULE
**Due Date:** Release 7.0

---

# USE CASE #24: View population data per region (Population Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population, number of people living in cities, and number of people not living in cities per region so that I can analyze and compare regional differences in population distribution and urbanization for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* The region field in the country table is valid and populated.
* City and country tables are properly joined by region.
* Population data for countries and cities is accurate and current.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully generates and displays a list of regions showing the total, urban, and non-urban population counts with calculated percentages.

**Failed End Condition**
The system fails to produce the report due to invalid data, missing regional information, or database connection/query errors.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Population Report then by Region from the main dashboard.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with report categories.
3. The user selects Population Report.
4. The system displays available report types (by Continent, by Region, by Country).
5. The user selects by Region.
6. The system executes SQL queries to calculate:
   * Total population per region.
   * Total population living in cities.
   * Total population not living in cities (total - city population).
   * Percentage of population living and not living in cities.
7. The system aggregates and formats the results by region.
8. The system displays the report with the following columns: **Region Name, Total Population, Population in Cities, % in Cities, Population not in Cities, % not in Cities**
9. The user reviews, filters, or exports the report as needed.

## EXTENSIONS
* **6a.** Region data missing or invalid, System displays: "Incomplete or invalid region data found."
* **6b.** Database connection fails, System logs error and displays: "Error connecting to database. Please retry."
* **8a.** No data found for any region; System displays: "No population data available for the specified regions."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or viewed in an interactive table.
* The user may filter by specific region(s) or minimum population threshold.

## SCHEDULE
**Due Date:** Release 7.0

---

# USE CASE #25: View population data per country (Population Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population, number of people living in cities, and number of people not living in cities per country so that I can measure and compare levels of urbanization across different nations for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and operational.
* Each country in the database includes a valid population count and link to city data.
* City populations are accurately recorded and associated with their respective countries.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully generates and displays a report showing the total, urban, and non-urban population for each country, with calculated percentages.

**Failed End Condition**
The report fails to generate due to missing country or city data, incorrect SQL joins, invalid query parameters, or database connection errors.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Population Report then by Country from the main dashboard.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with available report categories.
3. The user selects Population Report.
4. The system displays report types (by Continent, by Region, by Country).
5. The user selects by Country.
6. The system executes SQL queries to calculate for each country:
   * Total population.
   * Total population living in cities.
   * Total population not living in cities (total - city population).
   * Percentage of people living in and outside of cities.
7. The system aggregates the data per country.
8. The system displays the formatted report with the following columns: **Country Name, Total Population, Population in Cities, % in Cities, Population not in Cities, % not in Cities**
9. The user views, analyzes, or exports the report.

## EXTENSIONS
* **6a.** Missing or invalid country data, System displays: "Incomplete or missing country data detected."
* **6b.** Database connection fails, System logs error and displays: "Unable to connect to the database. Please try again later."
* **8a.** No data found; System displays: "No population data available for the specified countries."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or displayed as a table.
* The user can sort or filter by continent, region, or population range.

## SCHEDULE
**Due Date:** Release 7.0

---

# USE CASE #26: View world population (Overall Population Summary)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population of the world so that I can use it as a reference point for analyzing other demographic statistics and percentages for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and functioning correctly.
* Global population data is complete and up to date.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully calculates and displays the total population of the world based on the aggregated population of all countries in the database.

**Failed End Condition**
The report fails to generate due to missing country data, SQL query error, or loss of database connection.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Overall Population Summary then World Population from the dashboard.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with reporting options.
3. The user selects Overall Population Summary.
4. The system displays available summary types (World, Continent, Region, Country, District, City).
5. The user selects World Population.
6. The system executes an SQL query aggregating the population column from all countries in the database.
7. The system retrieves and sums all population values to calculate the global total.
8. The system displays the result in a clear, formatted report with the following columns: **Description, Total Population**
9. The user views or exports the result for analysis.

## EXTENSIONS
* **6a.** Database query fails, System logs the error and displays: "Unable to retrieve global population data. Please check the database connection."
* **7a.** Missing or corrupted data for one or more countries, System displays: "Incomplete data detected. Total may be approximate."

## SUB-VARIATIONS
* The report may be exported as CSV, PDF, or displayed as a summary widget.
* The user may optionally request percentage breakdowns by continent.

## SCHEDULE
**Due Date:** Release 9.0

---

# USE CASE #27: View population of a continent (Overall Population Summary)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population for a specific continent so that I can compare population sizes across continents and analyze demographic trends for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* Each country record contains a valid continent name and population value.
* The user is logged into the system interface (CLI or GUI).
* The requested continent name exists in the database.

**Success End Condition**
The system successfully calculates and displays the total population of the specified continent by aggregating the populations of all countries within it.

**Failed End Condition**
The report fails due to an invalid or missing continent name, incomplete country data, or a database query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Overall Population Summary then by Continent and provides the name of the continent.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with reporting options.
3. The user selects Overall Population Summary.
4. The system shows available summary types (World, Continent, Region, Country, District, City).
5. The user selects by Continent.
6. The system prompts the user to enter a continent name (e.g., "Africa").
7. The user enters a valid continent name.
8. The system executes an SQL query aggregating the population of all countries belonging to that continent.
9. The system calculates the total population for the selected continent.
10. The system displays the formatted report with the following columns: **Continent Name, Total Population**
11. The user views or exports the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled continent name, System displays: "Invalid continent name. Please try again."
* **8a.** Database query fails, System logs the error and displays: "Unable to retrieve data. Please check database connection."
* **9a.** No population data available, System displays: "No data found for the specified continent."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or viewed as a summary table.
* The user may select multiple continents to compare total populations.

## SCHEDULE
**Due Date:** Release 9.0

---

# USE CASE #28: View population of a region (Overall Population Summary)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population of a specific region so that I can study regional population sizes and compare demographic data across different parts of the world for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* Each country record contains a valid region name and population value.
* The user is logged into the system interface (CLI or GUI).
* The requested region name exists in the database.

**Success End Condition**
The system successfully generates and displays the total population of the specified region by summing the populations of all countries within that region.

**Failed End Condition**
The report fails to generate due to an invalid or missing region name, missing or incomplete population data, or a database connection/query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Overall Population Summary then by Region and enters the name of the desired region.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with available report categories.
3. The user selects Overall Population Summary.
4. The system presents available summary options (World, Continent, Region, Country, District, City).
5. The user selects by Region.
6. The system prompts the user to enter a region name (e.g., "Caribbean").
7. The user provides a valid region name.
8. The system executes a SQL query aggregating the populations of all countries within that region.
9. The system calculates and formats the total regional population.
10. The system displays the report with the following columns: **Region Name, Total Population**
11. The user views, compares, or exports the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled region name, System displays: "Invalid region name. Please re-enter."
* **8a.** Database query fails, System logs error and displays: "Unable to retrieve region population data. Please check database connection."
* **9a.** No matching data found; System displays: "No population data available for this region."

## SUB-VARIATIONS
* The report may be exported as CSV, PDF, or displayed in a summary table.
* The user may choose to compare multiple regions in a single query.

## SCHEDULE
**Due Date:** Release 9.0

---

# USE CASE #29: View population of a country (Overall Population Summary)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population for a specific country so that I can confirm national demographic data and use it as a basis for further analysis or reporting for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* Each country in the database includes a valid population figure.
* The user is logged into the system interface (CLI or GUI).
* The requested country name exists in the database.

**Success End Condition**
The system successfully retrieves and displays the total population for the specified country.

**Failed End Condition**
The system fails to generate the report due to an invalid or misspelled country name, missing population data, or a database query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Overall Population Summary then by Country and enters the name of the desired country.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with reporting options.
3. The user selects Overall Population Summary.
4. The system shows available summary report types (World, Continent, Region, Country, District, City).
5. The user selects by Country.
6. The system prompts the user to enter a country name (e.g., "Japan").
7. The user provides a valid country name.
8. The system executes a SQL query to retrieve the population value from the country table for the specified country.
9. The system displays the formatted report with the following columns: **Country Name, Total Population**
10. The user views, saves, or exports the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled country name, System displays: "Invalid country name. Please re-enter."
* **8a.** Database query fails, System logs error and displays: "Error retrieving country data. Please check the database connection."
* **9a.** No data found for the selected country; System displays: "No population data available for this country."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or displayed as a simple text or table output.
* The user may select multiple countries to compare populations.

## SCHEDULE
**Due Date:** Release 9.0

---

# USE CASE #30: View population of a district (Overall Population Summary)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the total population of a specific district so that I can assess and compare demographic distribution within a country for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and operational.
* Districts are correctly associated with their respective countries in the database.
* Each district entry contains valid population data.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully retrieves and displays the total population for the specified district.

**Failed End Condition**
The system cannot produce the report due to an invalid district name, missing population data, or a database query failure.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Overall Population Summary then by District and enters the desired district name.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with available reporting options.
3. The user selects Overall Population Summary.
4. The system presents report type options: World, Continent, Region, Country, District, City.
5. The user selects by District.
6. The system prompts the user to enter a district name.
7. The user enters a valid district name (e.g., "California").
8. The system executes a SQL query to retrieve the total population for the specified district from the database.
9. The system displays the formatted report with columns: **District Name, Country, Population**
10. The user reviews or exports the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled district name, System displays: "Invalid district name. Please try again."
* **8a.** Database query fails, System logs the error and displays: "Unable to retrieve district data. Please check the database connection."
* **9a.** No records found for the entered district; System displays: "No population data available for this district."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or displayed on-screen.
* Users can select multiple districts for side-by-side comparison.

## SCHEDULE
**Due Date:** Release 9.0

---

# USE CASE #31: View population of a city (Overall Population Summary)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view the population of a specific city so that I can analyze urban population distribution within a country or region for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* Valid city data, including name, country, and population, exist in the database.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully retrieves and displays the population of the specified city.

**Failed End Condition**
The system fails to display results because of an invalid city name, missing population data, or database query error.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Overall Population Summary then by City and provides the city name to generate a population report.

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with available report options.
3. The user selects Overall Population Summary.
4. The system presents report type options: World, Continent, Region, Country, District, City.
5. The user selects by City.
6. The system prompts the user to enter a city name.
7. The user provides a valid city name (e.g., "Tokyo").
8. The system executes a SQL query to retrieve the city's population and associated details.
9. The system displays the formatted report with columns: **City Name, Country, District, Population**
10. The user reviews the results and optionally exports or saves the report.

## EXTENSIONS
* **6a.** User enters an invalid or misspelled city name, System displays: "Invalid city name. Please re-enter a valid name."
* **8a.** Database query fails or connection error occurs, System logs the issue and displays: "Unable to retrieve data. Please check the database connection."
* **9a.** No population data found for the entered city; System displays: "No records available for this city."

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or Excel.
* Users can search multiple cities at once for comparison.

## SCHEDULE
**Due Date:** Release 9.0
