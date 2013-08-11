CoherenceJPA
============

Coherence JPA demo project, deployed on a managed Coherece Server, Build with Eclipse OEPE 12.1.2 

Contains Workspace an EAR project with

Coherence application which produce a GAR    
JPA project with the Department & Employee entities based on the HR Oracle schema  
Web Project with Coherence REST services and CoherenceServlet which fills the cache 


Example of Coherence REST with direct queries and named queries



REST definition

     <?xml version="1.0"?>
     <rest xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns="http://xmlns.oracle.com/coherence/coherence-rest-config"
           xsi:schemaLocation=
              "http://xmlns.oracle.com/coherence/coherence-rest-config
           coherence-rest-config.xsd">
       <resources>
         <resource>
           <cache-name>Department</cache-name>
           <key-class>java.lang.Integer</key-class>
           <value-class>nl.amis.model.hr.Department</value-class>
           <query>
             <name>location1700</name>
             <expression>locationId is 1700</expression>
           </query>
           <query>
             <name>location</name>
             <expression>locationId is (:locationId;int)</expression>
           </query>
           <direct-query enabled="true"/>
         </resource>
         <resource>
           <cache-name>Employee</cache-name>
           <key-class>java.lang.Integer</key-class>
           <value-class>nl.amis.model.hr.Employee</value-class>
           <direct-query enabled="true"/>
         </resource>
       </resources>
     </rest>   


HTTP demo urls   
see this for more information http://docs.oracle.com/middleware/1212/coherence/COHCG/rest_api.htm   

Run the servlet to fill the cache  
http://wls12:7201/CoherenceJPAWeb/CoherenceServlet

The JPA persisentence located in the META-INF of the HrJPA project contains the connection to the hr oracle schema  

Accept: application/xml  or Accept: application/json  

GET http://wls12:7201/CoherenceJPAWeb/rest/Department    
GET http://wls12:7201/CoherenceJPAWeb/rest/Department/100  

PUT http://wls12:7201/CoherenceJPAWeb/rest/Department/290  
Accept: application/xml  

    <Department>
      <departmentId>290</departmentId>
      <departmentName>Edwin</departmentName>
      <locationId>1700</locationId>
      <managerId>108</managerId>
    </Department>

DELETE http://wls12:7201/CoherenceJPAWeb/rest/Department/290  

GET http://wls12:7201/CoherenceJPAWeb/rest/Department/100;p= departmentId, departmentName    
GET http://wls12:7201/CoherenceJPAWeb/rest/Department?q=departmentName='Finance'  
GET http://wls12:7201/CoherenceJPAWeb/rest/Department/location1700  
GET http://wls12:7201/CoherenceJPAWeb/rest/Department/location?locationId=1700  

