def call(){
    stage("Compile"){        
        dir('src'){
            sh './${env.JOB_NOME}/mvnw clean compile -e'
        }            
    }
    stage("Test"){        
        dir('src'){
            sh './mvnw clean test -e'
        }            
    } 
    stage("Jar"){
        dir('src'){
            sh './mvnw clean package -e'
        }            
    }
    stage("Run"){
        dir('src'){
            sh 'nohup bash mvnw spring-boot:run &'
            sleep(30)
        }
    }
    stage("Curl API"){
        sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
    }
}
return thiss