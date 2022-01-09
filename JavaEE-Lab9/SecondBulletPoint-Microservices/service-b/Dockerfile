
FROM payara/micro:5.2021.10

ADD target/JavaLab9EE.war $PAYARA_PATH
 
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/JavaLab9EE.war", "--port","8180"]

