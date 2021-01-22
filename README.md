# Асинхронные сервисы по работе с API Alfresco
### Используются библиотеки и зависимости:
1. OpenJDK version **1.8.0_275**
2. Apache Maven **3.6.3**
3. Spring boot **2.3.6**:
   a) spring-boot-starter-webflux;
   б) spring-boot-starter-validation;
   в) [springdoc-openapi-webflux-ui](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-webflux-ui);
   г) spring-boot-configuration-processor.
### Для работы нужно наличие 3-х конфигурационных файлов, которые прописаны в операционной системе как переменная "SETTING_ASYNCH_REST_FUL:"
1. #### alfresco.properties:
+ *alfresco.httpurl* = http://ip:port
+ *alfresco.username* = login
+ *alfresco.password* = pass
2. #### netty.properties:
+ *netty.port* = port
+ *netty.ipadress* = ip
3. #### codecs.properties:
+ *codecs.byteCount* = 2097152
### Документация по REST API:
http://ip:port/swagger-ui-custom.html

