# txbridgeInTomcat8
setup txbridge under Tomcat out of JBoss
reproduce performance issue as below scenario 

     servlet client - localhost:8081/ServiceA/user?action=add 
          |
--------------------------------------------------------------
    ServiceA Tomcat
    Narayana JTA 
    Webservie - localhost:8082/ServiceA/user?action=add
--------------------------------------------------------------
          |
       txbridge
          |
--------------------------------------------------------------
    ServiceB Tomcat
    Narayana JTA 
    Webservie - localhost:8083/ServiceA/user?action=add
--------------------------------------------------------------
          |
       txbridge 
          |
--------------------------------------------------------------
    ServiceB Tomcat
    Narayana JTA 
--------------------------------------------------------------

 


