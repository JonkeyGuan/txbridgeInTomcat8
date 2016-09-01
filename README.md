# txbridgeInTomcat8
setup txbridge under Tomcat out of JBoss
reproduce performance issue as below scenario 

         webpage          
           |
-------------------------------------------------------------------
       ServiceA - localhost:8081/ServiceA/user?action=add         
-------------------------------------------------------------------
           |
        txbridge
           |
-------------------------------------------------------------------
       ServiceB - localhost:8082/ServiceA/user?action=add
-------------------------------------------------------------------
           |
        txbridge 
           |
-------------------------------------------------------------------
       ServiceC - localhost:8083/ServiceA/user?action=add
-------------------------------------------------------------------

 


