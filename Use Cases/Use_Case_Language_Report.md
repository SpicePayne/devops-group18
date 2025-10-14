# USE CASE #32: View number of people by language (and percentage of world) (Language Report)

## CHARACTERISTIC INFORMATION
**Goal in Context**
As a Data Analyst, I want to view how many people speak specific languages (Chinese, English, Hindi, Spanish, Arabic) and what percentage of the world population they represent so that I can understand global language distribution and present comparative statistics for the organization.

**Scope**
World Population Reporting System

**Level**
Primary task

**Preconditions**
* The database (world.sql) is connected and accessible.
* Language speaker data (or a mapping of languages to population via country-language relationships) is available and up to date.
* World population total can be calculated or is available.
* The user is logged into the system interface (CLI or GUI).

**Success End Condition**
The system successfully computes and displays, for each requested language, the total number of speakers and the percentage that number represents of the world population, sorted from greatest to smallest number of speakers.

**Failed End Condition**
The report fails to generate because of missing language data, incorrect mappings, division-by-zero (no world total), invalid input, or a database query/connection error.

**Primary Actor**
Data Analyst

**Trigger**
The user selects Language Report then All Key Languages and confirms the list of languages (default: Chinese, English, Hindi, Spanish, Arabic).

## MAIN SUCCESS SCENARIO
1. The user opens the World Population Reporting System.
2. The system displays the main dashboard with report categories.
3. The user selects Language Report.
4. The system prompts the user to choose languages to include (prepopulated: Chinese, English, Hindi, Spanish, Arabic) or to add custom languages.
5. The user confirms the language list.
6. The system executes SQL queries (or aggregated calculations) to determine total speakers per selected language.
   * If the database stores direct language-speaker counts, the system sums them.
   * If speaker counts are derived (e.g., percent of a country's population), the system applies the appropriate calculation across countries and sums results.
7. The system retrieves or computes the world total population (for percentage calculations).
8. For each language, the system calculates the percentage = (number of speakers / world population) * 100.
9. The system sorts languages by number of speakers in descending order.
10. The system displays the formatted report with the following columns: **Language, Number of Speakers, Percentage of World Population**
11. The user reviews and optionally exports the report (CSV, PDF) or copies data for further analysis.

## EXTENSIONS
* **6a.** Selected language not present in dataset, System displays: "Language data not available for: <language>" and excludes it from calculation.
* **6b.** User adds custom language mapping but provides insufficient mapping rules, System requests clarification or rejects the addition.
* **7a.** World population total missing or zero, System displays: "Unable to compute percentages: world population unavailable."
* **6c / 8a.** Database connection or query error, System logs the error and displays: "Unable to retrieve language/population data. Please check database connection."
* **9a.** Rounding or precision concerns, System displays percentages rounded to two decimal places and indicates rounding in a footnote.

## SUB-VARIATIONS
* The report can be exported as CSV, PDF, or Excel.
* The user can request additional languages beyond the default five.

## SCHEDULE
**Due Date:** Release 8.0
