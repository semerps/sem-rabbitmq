# SEM RabbitMQ

Grails 2.* - 3.* RabbitMQ Plugin supported TLSv1.2

Hello there,

This repo has been copied from rabbitmq-native (  [https://github.com/budjb/grails-rabbitmq-native](https://github.com/budjb/grails-rabbitmq-native)  ).

Configure your Grails project to use the TLSv1.2 protocol as follows.

application.groovy; 
     
    rabbitmq {  
        connections = [  
            [  
		     name: "defaultConnection", 
		     host: "example.com", 
		     username: "foo", 
		     password: "bar", 
		     port: 5671, 
		     ssl:true, 
		     sslProtocol:"TLSv1.2" 
		    ]
		]  
    }  
      
    or  
      
    rabbitmq {  
        connection = {  
            connection host: "example.com", username: "foo", password: "bar", ssl: true, sslProtocol: "TLSv1.2", port: 5671  
        }  
    }


application.yml

    rabbitmq:
        connections:
          - name: defaultConnection
            host: example.com
            username: foo
            password: bar
            ssl: true
            port: 5671
            sslProtocol: TLSv1.2
