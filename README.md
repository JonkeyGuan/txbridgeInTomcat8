# txbridgeInTomcat8
setup txbridge under Tomcat out of JBoss
reproduce performance issue as below scenario 

         webpage
           |
           |
========================   
       ServiceA
======================== 
           |
        txbridge
           |
========================   
       ServiceB
======================== 
           |
        txbridge
           |
========================   
       ServiceC
======================== 


