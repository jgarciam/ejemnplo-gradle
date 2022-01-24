def call(){
    stage("Compile"){        
        sh './mvnw clean compile -e'   
    }
    stage("Test"){        
        sh './mvnw clean test -e'
    } 
    stage("Jar"){
        sh './mvnw clean package -e'    
    }
    stage("Run"){
        sh 'nohup bash mvnw spring-boot:run &'
        sleep(30)
    }
    stage("Curl API"){
        sh "curl -X GET 'http://localhost:8082/rest/mscovid/test?msg=testing'"
    }
}
return this