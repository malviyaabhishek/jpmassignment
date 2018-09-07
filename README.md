# jpmassignment

This application is responsible to process sales messages and generate periodic reports.

Instructions to run the application
1. clone the source code.
2. build the application.
3. Run the entry point class SalesAppRunner.
4. No need to pass any parameters while running the application as it takes input file salesData.txt from its 'resources' directory.
5. jUnit test MessageProcessingServiceTest perfroms e2e test with coverage of 80%


Input File Format:
For MessageType1 & MessageType2
MessageType1,SaleType,Quantity,Price

For MessageType3 [Adjustment details]
MessageType1,SaleType,Quantity,Price,AdjustmentType

Build Logs:

/usr/lib/jvm/java-8-oracle/bin/java -Dmaven.multiModuleProjectDirectory=/home/abhishek/IdeaProjects/processing -Dmaven.home=/snap/intellij-idea-community/77/plugins/maven/lib/maven3 -Dclassworlds.conf=/snap/intellij-idea-community/77/plugins/maven/lib/maven3/bin/m2.conf -javaagent:/snap/intellij-idea-community/77/lib/idea_rt.jar=34109:/snap/intellij-idea-community/77/bin -Dfile.encoding=UTF-8 -classpath /snap/intellij-idea-community/77/plugins/maven/lib/maven3/boot/plexus-classworlds-2.5.2.jar org.codehaus.classworlds.Launcher -Didea.version=2018.2.3 install
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building processing 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ processing ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ processing ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ processing ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/abhishek/IdeaProjects/processing/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ processing ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ processing ---
[INFO] Surefire report directory: /home/abhishek/IdeaProjects/processing/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.sale.MessageProcessingServiceTest
************************SalesReport**********************Generated After 10 Trades*******************
Jacket --> quantity: 2, price: 1
Shirt --> quantity: 2, price: 1
Phone --> quantity: 14, price: 7
Book --> quantity: 2, price: 1

-----------------------------
Total quantity: 20
Total Amount: 10
-----------------------------

************************SalesReport**********************Generated After 10 Trades*******************
Jacket --> quantity: 2, price: 1
Shirt --> quantity: 2, price: 1
Phone --> quantity: 26, price: 13
Book --> quantity: 2, price: 1

-----------------------------
Total quantity: 32
Total Amount: 16
-----------------------------

************************SalesReport**********************Generated After 10 Trades*******************
Jacket --> quantity: 4, price: 2
Shirt --> quantity: 4, price: 2
Phone --> quantity: 34, price: 17
Book --> quantity: 4, price: 2

-----------------------------
Total quantity: 46
Total Amount: 23
-----------------------------

************************SalesReport**********************Generated After 10 Trades*******************
Jacket --> quantity: 4, price: 2
Shirt --> quantity: 4, price: 2
Phone --> quantity: 54, price: 27
Book --> quantity: 4, price: 2

-----------------------------
Total quantity: 66
Total Amount: 33
-----------------------------

************************SalesReport**********************Generated After 10 Trades*******************
Jacket --> quantity: 4, price: 2
Shirt --> quantity: 4, price: 2
Phone --> quantity: 58, price: 29
Book --> quantity: 6, price: 3

-----------------------------
Total quantity: 72
Total Amount: 36
-----------------------------

********************Application is pausing for a moment until the report is generated************
************************AdjustmentReport****************Generated after 50 Trades****************
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=SUBTRACT, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Book', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=MULTIPLY, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Jacket', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=SUBTRACT, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Book', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=MULTIPLY, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Jacket', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}
SalesMessage{sale=Sale{productType='Phone', quantity=2, price=1}, messageType=Type3, adjustment=Adjustment{adjustmentType=ADD, price=1, quantity=2}, isAdjustment=true}

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.797 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ processing ---
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ processing ---
[INFO] Installing /home/abhishek/IdeaProjects/processing/target/processing-1.0-SNAPSHOT.jar to /home/abhishek/.m2/repository/com/sale/processing/1.0-SNAPSHOT/processing-1.0-SNAPSHOT.jar
[INFO] Installing /home/abhishek/IdeaProjects/processing/pom.xml to /home/abhishek/.m2/repository/com/sale/processing/1.0-SNAPSHOT/processing-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 17.829 s
[INFO] Finished at: 2018-09-07T13:34:31+05:30
[INFO] Final Memory: 14M/173M
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0

