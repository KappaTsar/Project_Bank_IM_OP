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

2021-03-15 13:05:39.404 

 INFO 6604 --- [  restartedMain] pl.edu.wszib.bank.App                    : No active profile set, falling back to default profiles: default
 INFO 6604 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! 
Set 'spring.devtools.add-properties' to 'false' to disable
 INFO 6604 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting
 the 'logging.level.web' property to 'DEBUG'
 INFO 6604 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFERRED mode.
 INFO 6604 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 32ms. 
Found 0 JPA repository interfaces.
 INFO 6604 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
 INFO 6604 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
 INFO 6604 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.39]
 INFO 6604 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
 INFO 6604 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1784 ms
 INFO 6604 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.27.Final
 INFO 6604 --- [  restartedMain] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
 
 WARN 6604 --- [  restartedMain] org.hibernate.orm.connections.pooling    : HHH10001002: Using Hibernate built-in connection pool (not for production use!)
 
 INFO 6604 --- [  restartedMain] org.hibernate.orm.connections.pooling    : HHH10001005: using driver [com.mysql.cj.jdbc.Driver] 
at URL [jdbc:mysql://localhost:3306/bankapp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8]
 INFO 6604 --- [  restartedMain] org.hibernate.orm.connections.pooling    : HHH10001001: Connection properties: {user=root, password=****}
 INFO 6604 --- [  restartedMain] org.hibernate.orm.connections.pooling    : HHH10001003: Autocommit mode: false
 INFO 6604 --- [  restartedMain] .c.i.DriverManagerConnectionProviderImpl : HHH000115: Hibernate connection pool size: 20 (min=1)
 INFO 6604 --- [  restartedMain] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
 INFO 6604 --- [  restartedMain] org.hibernate.orm.connections.access     : HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@7070c508] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: alter table taccount add constraint FK2xs4mvvpi6c6ll3p6nuhswnge foreign key (userID_id) references tuser (id)
Hibernate: alter table taccount_ttransaction add constraint FKj6xpb0c7eq5qkxsuvk1fh3uhm foreign key (history_id) references ttransaction (id)
Hibernate: alter table taccount_ttransaction add constraint FKpb9civt5jukwbdsrfaslq7fmd foreign key (taccount_id) references taccount (id)
Hibernate: alter table ttransaction add constraint FKiqi5g3mnbmy97o2ffrf7bp8du foreign key (account_id) references taccount (id)
Hibernate: alter table tuser_taccount add constraint FKc4ff4c2h83qtwe1rxri28w32e foreign key (accountList_id) references taccount (id)
Hibernate: alter table tuser_taccount add constraint FK2twxly9u52jdi22hes60b3n0q foreign key (tuser_id) references tuser (id)
 INFO 6604 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation:
[org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
 
 WARN 6604 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. 
Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
 
 INFO 6604 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
 
 WARN 6604 --- [  restartedMain] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - 
cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'namedParameterJdbcTemplate' defined in class path resource 
[org/springframework/boot/autoconfigure/jdbc/NamedParameterJdbcTemplateConfiguration.class]: Bean instantiation via factory method failed;
 nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate 
[org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate]: Factory method 'namedParameterJdbcTemplate' threw exception;
 nested exception is java.lang.NoClassDefFoundError: org/springframework/util/ConcurrentLruCache
 
 INFO 6604 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
 INFO 6604 --- [  restartedMain] org.hibernate.orm.connections.pooling    : HHH10001008: Cleaning up connection pool 
[jdbc:mysql://localhost:3306/bankapp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8]
 INFO 6604 --- [  restartedMain] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
 INFO 6604 --- [  restartedMain] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.

 ERROR 6604 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'namedParameterJdbcTemplate' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/NamedParameterJdbcTemplateConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate]: Factory method 'namedParameterJdbcTemplate' threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/util/ConcurrentLruCache
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:655) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:635) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1336) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1176) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:556) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:897) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:879) ~[spring-context-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:551) ~[spring-context-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:143) ~[spring-boot-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758) [spring-boot-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750) [spring-boot-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:405) [spring-boot-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) [spring-boot-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1237) [spring-boot-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) [spring-boot-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at pl.edu.wszib.bank.App.main(App.java:10) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_282]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_282]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_282]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_282]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.3.5.RELEASE.jar:2.3.5.RELEASE]
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate]: Factory method 'namedParameterJdbcTemplate' threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/util/ConcurrentLruCache
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:650) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	... 25 common frames omitted
Caused by: java.lang.NoClassDefFoundError: org/springframework/util/ConcurrentLruCache
	at org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate.<init>(NamedParameterJdbcTemplate.java:80) ~[spring-jdbc-5.3.2.jar:5.3.2]
	at org.springframework.boot.autoconfigure.jdbc.NamedParameterJdbcTemplateConfiguration.namedParameterJdbcTemplate(NamedParameterJdbcTemplateConfiguration.java:41) ~[spring-boot-autoconfigure-2.3.5.RELEASE.jar:2.3.5.RELEASE]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_282]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_282]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_282]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_282]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154) ~[spring-beans-5.2.10.RELEASE.jar:5.2.10.RELEASE]
	... 26 common frames omitted
Caused by: java.lang.ClassNotFoundException: org.springframework.util.ConcurrentLruCache
	at java.net.URLClassLoader.findClass(URLClassLoader.java:382) ~[na:1.8.0_282]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:418) ~[na:1.8.0_282]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:352) ~[na:1.8.0_282]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:351) ~[na:1.8.0_282]
	... 33 common frames omitted


Process finished with exit code 0


