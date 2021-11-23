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
    - Created the "students.xhtml" jsf page with the purpose of displaying the existing students using the jsf core,html and facelets library. The information is displayed in a data table.
    - Created the model class "Exam" and annotated it with "@Named" and "@SessionScoped" with the purpose of being viewed as a bean.
    - Created the model class "Student" and annotated it with "@Named" and "@SessionScoped" with the purpose of being viewed as a bean.
    - Created the model class "Session" and annotated it with "@Named" (with a custom name) and "@SessionScoped" with the purpose of being viewed as a bean. Specific for this class are the services that are injected using the @Injected annotation and the "init()" method annotated with @PostConstruct. The main purpose for this additional functionality is to provide the bean a safe use of depedencies (ExamService, StudentService) only after the bean is initialiazed. The "init()" method is called only once when the bean is first referenced in a page.
    - Created the SingletonRepository class that is designed using the Singleton pattern and contains functionality for retrieving information from a PostgreSQL database. The connection is established using PostgreSQL jdbc driver.
    - Created the ExamService class with the purpose of creating an intermediary between the data acces repository and the model class removing the unwanted depedency between a model class and external details like database access service. Exams information is obtained through the SingletonRepository instance.
    - Created the StudentService class with the purpose of creating an intermediary between the data acces repository and the model class removing the unwanted depedency between a model class and external details like database access service. Students information is obtained through the SingletonRepository instance.
    - (Side note: Unfortunately, I encountered several configuration problems when using the frameworks Primefaces and Bootsfaces but I hope to find a solution for the next laboratory.)
  
Note: I don't know what happened, but somehow the explanations for Lab 4 and Lab 5 vanished from the readme.md file. I will try to recover it, but this was an unexpected behaviour.

Another note: I managed to find the issue for the database exceptions when I presented the work for lab 5. The "META-INF" folder with the persistence.xml file was not in the right location. Relocated it to src/main/resources and now the jda data source togheter with the declared entities are now successfully identified.

## Lab 6 - Work
 - Created the jsf reservation.xhtml file that shows the resources and their quantities registered in the database. Using this page, the user can select one of the exams registered in the database using "<p:selecteOneMenu>" tag and assign the number of resources required for a exam. The desired quantity for a certain resource can be typed in that resource input text. If a resource quantity is not available (i.e. the quantity is lower than or equal to 0) that resource group tags will not be rendered.
 - Refactored the ExamsRepository and StudentsRepository to be EJBs by adding the @Stateless annotation and injecting them in their respective services(ExamService, StudentService) using the @EJB annotation.
 - Created the ResourceRepositoryStateless class and annotated it with @Stateless in order to be considered an ejb. Declared an EntityManager object annotated with the @PersistenceContext followed by the name of the PersistenceUnit declared in persistence.xml. Implemented the "isResourceAvailable" method that checks if the quantity for a given paramater of type Entity.Resource is greater than 0; if that's the case, the method returns true. Also implemented the method getResources in order to initialiaze the reservation page with the resources name registered in the database, togheter with their quantities.
 - Created the ResourceRepositoryStateful class and annotated it with @Stateful in order to be considered an ejb. Declared an EntityManager object annotated with the @PersistenceContext followed by the name of the PersistenceUnit declared in persistence.xml. Implemented the "assignResources" method that receives as parameters a list of objects of type Entity.Resources, the exam that will the resources be allocated to, and a list of quantities that represents each resources selected quantities for that exam. In the method body, the exam is assigned to every resource in the list, followed by the new quantities. The newly quantities are computed by substracting from the database registered quantity for that resource the selected quantity by the user. For both ResourceRepositoryStateful and ResourceRepositoryStateless, because there was not specificed, the default container-managed transaction is used and all the methods, by default, have transaction type required attribute.
 - Created the SingletonResourceLog class and annotated it with @Singleton in order to be considered an ejb. Followed by the @Singleton annotation is the @Startup annotation that forces the initialization the singleton bean upon application startup. The initialization is done in the "init" method annotated with @PostConstruct. The body of the method uses the injected ResourceService instance using the @Inject annotation to get the resources registered in the database. Then, the Map<String, String> resourceMap declared, stores as keys the resources names and as values the exams names. Another two methods were implemented and those are "updateMap" and "updateMapList". Their functional purpose is the same but they have different parameters types(Resource vs List<Resource>). In order for the methods to be concurrently accesed, the @Lock(LockType.WRITE) annotation was added. Given the default context regarding concurrency, the container-managed concurrency is the container default and the locks annotations are properly used.
    
