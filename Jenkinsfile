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

        stage("Publish to artifactory"){
            steps{
                echo "Publish to artifactory"
            }
        }
        






    }
 
}