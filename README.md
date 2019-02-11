# SEM RabbitMQ

Grails 2.* - 3.* RabbitMQ Plugin supported TLSv1.2

Hello there, 
### Clone a repository
``git clone https://github.com/semerps/sem-rabbitmq``
``grails compile && grails maven-install``

### Add The Plugin

In `grails-app/conf/BuildConfig.groovy`, under the `plugins` section, add:


    plugins {
        // ...
        compile name: "sem-rabbitmq", version: "1.1.0"

        // …
    }

This repo has been copied from rabbitmq-native (  [](https://github.com/budjb/grails-rabbitmq-native)[https://github.com/budjb/grails-rabbitmq-native](https://github.com/budjb/grails-rabbitmq-native)  ).

Configure your Grails project to use the TLSv1.2 protocol as follows.

application.groovy;

```
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

```

application.yml

```
rabbitmq:
    connections:
      - name: defaultConnection
        host: example.com
        username: foo
        password: bar
        ssl: true
        port: 5671
        sslProtocol: TLSv1.2
```