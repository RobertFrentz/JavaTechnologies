# JavaTechnologies

## Lab 1 - Work
  * Created the servlet in accordance with the first bullet point from the lab page.
  * Reconfigured response content(just text, no html) for requests from desktop applications.
  * Used JMeter for testing the performance and concurrency with different values for mock and sync parameters and saved results in csv files. (1000 http requests per scenario)
  * Create a python project that reads the csv files content and compute the average latency of the requests for all the different scenarios.
## Lab 2 - Work
  * Created the server-side components and jsp pages in accordance with the first bullet point from the lab page
    - Created the "ControllerServlet" component with the goal of managing the web-flow in the application (handling requests/responses, forwarding etc.)
    - Created the model class "Record"
    - Created the model class "Category"
    - Created the "RecordFileRepository" component with the goal of handling record model operations and file data access.
    - Created the "input" jsp file that contains a form for posting records.
    - Created the "result" jsp file that contains a table with the current records contained in the server data storage. The data is displayed using jstl core tags.
    
