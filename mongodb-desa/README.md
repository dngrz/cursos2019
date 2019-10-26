# Examen Practica 6 - MongoDB Desarrolladores:

# 1. 
    MongoDB Enterprise > db.people.insertMany([
    ... {name:"Mary",gender:"female",size:1.72,weight:54,phone:"+51 2345679", age:25 ,email:"mary.smith@gmail.com",company:"AWS",isActive:true,address:[{primary:"100 Boulevard Miami",secondary:"303 St. Geneva Rome"}]},
    ... {name:"Charles",gender:"male",size:1.86,weight:90,phone:"+86 7345674", age:35 ,email:"charles.slate@yahoo.com",company:"Redhat",isActive:true},
    ... {name:"Danny",gender:"male",size:1.91,weight:102,phone:"+1 8445663", age:25 ,email:"danny.lasalle@growing.com",company:"AWS",isActive:false,address:[{primary:"102 Bronco Texas",secondary:"404 Borbon Street Lousiana"}]},
    ... {name:"Richard",gender:"male",size:1.82,weight:83,phone:"+86 2545671", age:35 ,email:"richard.jhonson@gmail.com",company:"Open cloud",isActive:true},
    ... {name:"Yenny",gender:"female",size:1.75,weight:56,phone:"+51 2345459", age:29 ,email:"yenny.sullivan@gmail.com",company:"AWS",isActive:false,address:[{primary:"505 Renfer Madrid",secondary:"345 Republica Barcelona"}]},
    ... {name:"Rob",gender:"male",size:1.79,weight:85,phone:"+51 7145679", age:35 ,email:"rob.sax@mshaw.com",company:"Microsoft Inc",isActive:false},
    ... {name:"Brain",gender:"male",size:1.90,weight:92,phone:"+1 8947679", age:45 ,email:"brain.dawner@yahoo.com",company:"AWS",isActive:true} ,
    ... {name:"Jane",gender:"male",size:1.56,weight:55,phone:"+1 8345663", age:25 ,email:"jane.gross@growing.com",company:"MongoDB Inc",isActive:true}
    ... ]);
    {
            "acknowledged" : true,
            "insertedIds" : [
                    ObjectId("5db46b8f45d4d671d8a32b7f"),
                    ObjectId("5db46b8f45d4d671d8a32b80"),
                    ObjectId("5db46b8f45d4d671d8a32b81"),
                    ObjectId("5db46b8f45d4d671d8a32b82"),
                    ObjectId("5db46b8f45d4d671d8a32b83"),
                    ObjectId("5db46b8f45d4d671d8a32b84"),
                    ObjectId("5db46b8f45d4d671d8a32b85"),
                    ObjectId("5db46b8f45d4d671d8a32b86")
            ]
    }
    MongoDB Enterprise >

# 2. Creando el Microservicio con Maven.

    B:\fuentes\curso>mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=1.3.16 -DgroupId=com.example.helloworld -DartifactId=HelloworldService  -DinteractiveMode=false -Dname=HelloworldService
    [INFO] Scanning for projects...
    Downloading: http://localhost:8082/repository/maven-public/org/codehaus/mojo/maven-metadata.xml
    Downloading: http://localhost:8082/repository/maven-public/org/apache/maven/plugins/maven-metadata.xml
    Downloaded: http://localhost:8082/repository/maven-public/org/codehaus/mojo/maven-metadata.xml (21 KB at 32.5 KB/sec)
    Downloaded: http://localhost:8082/repository/maven-public/org/apache/maven/plugins/maven-metadata.xml (14 KB at 21.6 KB/sec)
    Downloading: http://localhost:8082/repository/maven-public/org/apache/maven/plugins/maven-archetype-plugin/maven-metadata.xml
    Downloaded: http://localhost:8082/repository/maven-public/org/apache/maven/plugins/maven-archetype-plugin/maven-metadata.xml (939 B at 3.8 KB/sec)
    [INFO]
    [INFO] ------------------------------------------------------------------------
    [INFO] Building Maven Stub Project (No POM) 1
    [INFO] ------------------------------------------------------------------------
    [INFO]
    [INFO] >>> maven-archetype-plugin:3.1.2:generate (default-cli) > generate-sources @ standalone-pom >>>
    [INFO]
    [INFO] <<< maven-archetype-plugin:3.1.2:generate (default-cli) < generate-sources @ standalone-pom <<<
    [INFO]
    [INFO] --- maven-archetype-plugin:3.1.2:generate (default-cli) @ standalone-pom ---
    [INFO] Generating project in Batch mode
    [INFO] Archetype repository not defined. Using the one from [io.dropwizard.archetypes:java-simple:0.8.0-rc2] found in catalog remote
    [INFO] ----------------------------------------------------------------------------
    [INFO] Using following parameters for creating project from Archetype: java-simple:1.3.16
    [INFO] ----------------------------------------------------------------------------
    [INFO] Parameter: groupId, Value: com.example.helloworld
    [INFO] Parameter: artifactId, Value: HelloworldService
    [INFO] Parameter: version, Value: 1.0-SNAPSHOT
    [INFO] Parameter: package, Value: com.example.helloworld
    [INFO] Parameter: packageInPathFormat, Value: com/example/helloworld
    [INFO] Parameter: version, Value: 1.0-SNAPSHOT
    [INFO] Parameter: package, Value: com.example.helloworld
    [INFO] Parameter: name, Value: HelloworldService
    [INFO] Parameter: groupId, Value: com.example.helloworld
    [INFO] Parameter: description, Value: null
    [INFO] Parameter: shaded, Value: true
    [INFO] Parameter: artifactId, Value: HelloworldService
    [INFO] Project created from Archetype in dir: B:\fuentes\curso\HelloworldService
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 2.775 s
    [INFO] Finished at: 2019-10-26T10:56:09-05:00
    [INFO] Final Memory: 15M/210M
    [INFO] ------------------------------------------------------------------------
    
    B:\fuentes\curso>dir
     El volumen de la unidad B es DATA
     El número de serie del volumen es: 7A1C-AE1C
    
     Directorio de B:\fuentes\curso
    
    26/10/2019  10:56 a. m.    <DIR>          .
    26/10/2019  10:56 a. m.    <DIR>          ..
    26/10/2019  10:56 a. m.    <DIR>          HelloworldService
                   0 archivos              0 bytes
                   4 dirs  272,764,542,976 bytes libres
                   
    # Se siguieron los pasos para la implementaciòn.

# 15. Iniciando el Microservicio

    INFO  [2019-10-26 13:20:56,551] io.dropwizard.server.ServerFactory: Starting HelloworldService
    ================================================================================
    
                                  HelloworldService
    
    ================================================================================
    
    
    INFO  [2019-10-26 13:20:56,992] io.dropwizard.jersey.DropwizardResourceConfig: The following paths were found for the configured resources:
    
        GET     /hello-world (com.example.helloworld.resources.HelloWorldResource)
        GET     /people/ (com.example.helloworld.resources.PeopleResource)
        GET     /people/age/{age} (com.example.helloworld.resources.PeopleResource)
        GET     /people/gender/{gender} (com.example.helloworld.resources.PeopleResource)
        GET     /people/name/{name} (com.example.helloworld.resources.PeopleResource)
    
    WARN  [2019-10-26 13:20:56,993] org.glassfish.jersey.internal.Errors: The following warnings have been detected: WARNING: The (sub)resource method obtainAll in com.example.helloworld.resources.PeopleResource contains empty path annotation.
    
    0:0:0:0:0:0:0:1 - - [26/oct/2019:18:20:58 +0000] "GET /people/age/40 HTTP/1.1" 200 2 "-" "PostmanRuntime/7.18.0" 67
    0:0:0:0:0:0:0:1 - - [26/oct/2019:18:21:02 +0000] "GET /people/age/20 HTTP/1.1" 200 145 "-" "PostmanRuntime/7.18.0" 25

16. Consultas
    http://localhost:7100/hello-world
    
    {
        "id": 1,
        "content": "Hola, Clodoaldo Sanchez!"
    }
    
    http://localhost:7100/hello-world?name=Successful+Dropwizard+User
    
    {
        "id": 2,
        "content": "Hola, Successful Dropwizard User!"
    }
    
    
    Consultas:
    
    Todas las personas: http://localhost:7100/people
    
    Todos los Varones: http://localhost:7100/people/gender/male
    
    Todas las Mujeres: http://localhost:7100/people/gender/female
    
    Consulta por Nombre: http://localhost:7100/people/name/Yenko
    
    Consulta por Edad: http://localhost:7100/people/age/20               