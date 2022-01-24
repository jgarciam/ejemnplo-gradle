
pipeline {
    agent any
    options {
        timestamps()
    }
    stages {
        stage("SCM"){
            steps {
                cleanWs()
                script {
                    dir('src'){                    
                        sh 'git clone https://github.com/jgarciam/ejemnplo-gradle.git/ .'
                        sh 'git checkout -b maven-gradle'
                    }
                }
            }
        }
        stage("Maven/Gradle"){
            steps {
                cleanWs()
                script {
                    dir('src'){                    
                        input id: 'Mg'
                        , message: 'Seleccione Maven o Gradle'
                        , ok: 'Ok'
                        , parameters: [
                                choice(choices: ['Maven', 'Gradle']
                                , description: 'Herramienta de construccion'
                                , name: 'MAVEN_GRADLE_OPTION')
                            ]
                        if(${env.MAVEN_GRADLE_OPTION} == "Maven"){
                            def ejecucion = load 'maven.groovy'
                            ejecucion.mavenPipeline()
                        } else {
                            def ejecucion = load 'gradle.groovy'
                            ejecucion.mavenPipeline()                            
                        }
                    }
                }
            }
        }
    }
}
