pipeline{
    agent{
        label "master"
    }

    stages{
        
        stage("Poll"){
            steps{
                
                echo "Poll source code repository"
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github_with_user_and_password', url: 'https://github.com/apulijala/hello-world-greeting.git']]])
               
            }
        }

        stage("Build and Unit Test"){
            steps{
                echo "Build and Unit Test"
                sh 'mvn clean verify -DskipITs=true'
                junit 'target/surefire-reports/TEST-*.xml'
                archive 'target/*.jar'

            }
        }

        stage("Static code analysis"){
            steps{
                echo "Build and Unit Test"
                sh 'mvn clean verify sonar:sonar -Dsonar.projectName=example-project -Dsonar.projectKey=example-project -Dsonar.host.url=http://ec2-18-133-184-193.eu-west-2.compute.amazonaws.com:9000'
            }
        }

        stage("Integration testing"){
            steps{
                echo "Integration testing"
            }
        }

       stage ('Publish'){

            steps {
                rtUpload (
                    serverId: 'andrew-artifactory',
                    spec: '''{
                        "files": [
                            {
                            "pattern": "target/hello-0.0.1.war",
                            "target": "example-project/froggy-files/"
                            
                            }
                        ]
                    }''',
                    buildName: 'holyFrog',
                    buildNumber: '42'
                )        
            }
        }
    }
 
}