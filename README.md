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
    - Created the "result" jsp file that contains a table with the current records contained in the server data storage. The data is displayed using jstl core tags
## Lab 3 - Work
  * Created the jsf pages, beans, jdbc connection and other server-side components in accordance with the first bullet point from the lab page.
    - Created the "exam.xhtml" jsf page with the purpose of displaying the existing exams using the jsf core and html library. The information is displayed in a data table.
    - Created the "students.xhtml" jsf page with the purpose of displaying the existing students using the jsf core and html library. The information is displayed in a data table.
    - Created the model class "Exam" and annotated it with "@Named" and "@SessionScoped" with the purpose of being viewed as a bean.
    - Created the model class "Student" and annotated it with "@Named" and "@SessionScoped" with the purpose of being viewed as a bean.
    - Created the model class "Session" and annotated it with "@Named" (with a custom name) and "@SessionScoped" with the purpose of being viewed as a bean. Specific for this class are the services that are injected using the @Injected annotation and the "init()" method annotated with @PostConstruct. The main purpose for this additional functionality is to provide the bean a safe use of depedencies (ExamService, StudentService) only after the bean is initialiazed. The "init()" method is called only once when the bean is first referenced in a page.
    - Created the SingletonRepository class that is designed using the Singleton pattern and contains functionality for retrieving information from a PostgreSQL database. The connection is established using PostgreSQL jdbc driver.
    - Created the ExamService class with the purpose of creating an intermediary between the data acces repository and the model class removing the unwanted depedency between a model class and external details like database access service. Exams information is obtained through the SingletonRepository instance.
    - Created the StudentService class with the purpose of creating an intermediary between the data acces repository and the model class removing the unwanted depedency between a model class and external details like database access service. Students information is obtained through the SingletonRepository instance.
   (Side note: Unfortunately, I encountered several configuration problems when using the frameworks Primefaces and Bootsfaces but I hope to find a solution for the next laboratory.)
