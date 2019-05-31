# myRetailStoreSample
Technology stack used:
1.spring boot
2.cassandra
3.spring rest template
4.apache-tomcat-7.0.85 

installation needed:
1.apache-cassandra-3.11.4
2. python2.7 (optional, you can use any client (eg:datastax) to talk to cassandra)
 
 Data set Up steps:
  after installing cassandra, please create the following table 
  
  1.create keyspace target with replication={'class':'SimpleStrategy', 'replication_factor':1};
  2. 	 insert into Price (product_id, value, currency_code) values (13860428, 80, 'USD');
		 insert into Price (product_id, value, currency_code) values (15117729, 10, 'USD');
		 insert into Price (product_id, value, currency_code) values (16483589, 20, 'USD');
		 insert into Price (product_id, value, currency_code) values (16696652, 30, 'USD');
		 insert into Price (product_id, value, currency_code) values (16752456, 40, 'USD');
		 insert into Price (product_id, value, currency_code) values (15643793, 50, 'USD');
		 
 3.now do a maven build in the downloaded location(example: mvn spring-boot:run)
 4.it will generate my-retail-store-0.0.1-SNAPSHOT.war (for example :C:\springBoot\target\myReailStore\target)
 5. deploy the war file in tomcat (copy to %TOMCATINSTALLDIR%\webapps)
 6.start/restart tomcat server.
 
 Accesing Application:
  1.hit the following url
	GET : http://localhost:8080/myretail/product/13860428
	
	Response:
			{
				"product_id": 13860428,
				"name": "The Big Lebowski (Blu-ray)",
				"price": {
							"product_id": 13860428,
							"value": 200,
							"currency_code": "USD"
						}
			}
			
	2. updating price from 200 USD to 100 USD:	
		PUT: http://localhost:8080/myretail/product/13860428   set Content-Type:application/json
				Request body:
				{
					"product_id":"13860428",
					"value":"100",
					"currency_code":"USD"
				}
				
				Response: 
								
				{
					"product_id": 13860428,
					"name": "The Big Lebowski (Blu-ray)",
					"price": {
								"product_id": 13860428,
								"value": 100,
								"currency_code": "USD"
							 }
				}
		