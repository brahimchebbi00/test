FROM openjdk:8
EXPOSE 8083
ADD target/InventoryService.jar InventoryService.jar
ENTRYPOINT ["java","-jar","/InventoryService.jar"]