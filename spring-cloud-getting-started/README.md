# Spring Cloud - Getting Started Example


Issue: TypeNotPresentExceptionProxy


Resolve: Check in pom.xml that correct Release train Spring Boot compatibility

Release Train	 |  Boot Version
-------------  |  -------------  
Hoxton         |     2.2.x
Greenwich      |     2.1.x
Finchley       |     2.0.x
Edgware        |     1.5.x
Dalston        |     1.5.x

For adding application in Eureka Server you have to follow these steps.

Step 1: Add "netflix-eureka-client" dependencies
     <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
    </dependencies>
    
     <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Hoxton.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
