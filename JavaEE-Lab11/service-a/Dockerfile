FROM payara/micro:5.2021.10

ADD target/JavaLab9EE.war $PAYARA_PATH
ADD post-boot-commands.txt $PAYARA_PATH

ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/JavaLab9EE.war", "--postbootcommandfile", "/opt/payara/post-boot-commands.txt"]

