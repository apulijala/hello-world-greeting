pipeline{
    agent{
        label "master"
    }

    stages{
        
        stage("Poll"){
            steps{
              
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github_with_user_and_password', url: 'https://github.com/apulijala/hello-world-greeting.git']]])
                echo "Poll source code repository"
            }
        }

        stage("Build and Unit Test"){
            steps{
                echo "Build and Unit Test"
                sh 'mvn clean install'
            }
        }

        stage("Static code analysis"){
            steps{
                echo "Build and Unit Test"
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