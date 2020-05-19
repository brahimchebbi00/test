FROM openjdk:8
EXPOSE 8082
ADD target/InventoryService.jar InventoryService.jar
ENTRYPOINT ["java","-jar","/InventoryService.jar"]