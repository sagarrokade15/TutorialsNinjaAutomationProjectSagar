package com.tutoninja.qa.testcases;

public class Information {
	
	
/*1------Run POM>.XML
 * 
 * After completion of test cases and reports part We have to  run project through POM.XML for that 
          1st time we  get lombok error --Add LMMBOK Dep-Seach mvn repository  on chrome - search lombok  
          Also change the name of Test classes as Login to LoginTest
	      but here problem is we are running TC'S through POM so TextNg is not invoked and Report and Screenshots is not captured
	      For  overcome above problem just replaced mvn surefire pulgin to new pulgin in POM.XML(Search on chrome mvn surefire testng pulgin)
	      
	      old -- 
	      <artifactId>maven-surefire-plugin</artifactId>
          <version>3.3.0</version>
	      
	     new ----- 
	      
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.5.0</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
        </configuration>
        
     Next step ----
     Replace testng.xml  in above plugin to test/resources/testng.xml --since our testng file present under test/resources folder
     
     then change the name of Test classes as Login to LoginTest in Testng xml
	 
	 /* ARUN VIDEO 8.55 video time...
 2..Run TC'S using POM Using CMD prompt	
	     mvn test
	...  ...................
3	.. Run using Jenkins 9.12 video time..     
	     
	     
	
	/*4	..GIT  and GIT HUB  10. 30 video time..     
    s
    */


}
