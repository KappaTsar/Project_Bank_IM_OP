# Project_Bank_IM_OP
Final_Project for Java simple BANK App.  


Frorlduk's Holding Union

Project:

 Front-end(okej, mozna ciangac) Hajbernejta
 
 Controlery(samemu)
 
 Testowanie*
 
 Web service

" 13 5674 667# cccc cccc cccc cccc    2 + 8 + 16 = 26 NUM_code "

Prosta aplikacja bankowa - administratorzy tworzą konta bankowe wraz z userami 
(loginy sa x-cyfrowymi numerami, 
hasła startowe które potem user może zmienić),
 user loguje się na swoje konto bankowe, każde konto ma unikalny numer, 
 user moze wykonywać przelewy na inne konta bankowe 
(zakładamy że istnieje tylko jeden bank i numer musi być w systemie)


2021-03-14 22:49:52.951  WARN 1596 --- [  restartedMain] ConfigServletWebServerApplicationContext : 
Exception encountered during context initialization - cancelling refresh attempt: 
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 
'inMemoryDatabaseShutdownExecutor' defined in class path resource 
[org/springframework/boot/devtools/autoconfigure/DevToolsDataSourceAutoConfiguration.class]:
 Unsatisfied dependency expressed through method 'inMemoryDatabaseShutdownExecutor' parameter 0;
 nested exception is org.springframework.beans.factory.BeanCreationException: 
 Error creating bean with name 'dataSource' defined in class path resource
 [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$Hikari.class]: 
 Bean instantiation via factory method failed; nested exception is 
 org.springframework.beans.BeanInstantiationException: Failed to instantiate 
 [com.zaxxer.hikari.HikariDataSource]: Factory method 'dataSource' threw exception; nested exception is 
 org.springframework.boot.autoconfigure.jdbc.DataSourceProperties$DataSourceBeanCreationException:
 Failed to determine a suitable driver class
