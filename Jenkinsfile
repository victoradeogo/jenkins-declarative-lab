
pipeline {
    agent any
   
    environment {
        APP_NAME = 'maven-demo'
        BUILD_TOOL = 'Maven'
        DEPLOY_ENV = 'testing'
    }

    options {
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Environment Check') {
            steps {
                 echo 'Checking the build environment...'
                 echo "Application: ${env.APP_NAME}"
                 echo "Build tool: ${env.BUILD_TOOL}"
                 echo "Deployment environment: ${env.DEPLOY_ENV}"
                 sh 'echo "Shell application: $APP_NAME"'
                 sh 'echo "Shell build tool: $BUILD_TOOL"'
                 sh 'echo "Shell deployment environment: $DEPLOY_ENV"'
                 sh 'git --version'
                 sh 'java -version'
                 sh 'pwd'
                 sh 'ls -la'
            }
        }







        stage('Build') {
             environment {
                 BUILD_MESSAGE = 'Building the application'
             }
            steps {
                echo 'Building Maven application...'
                echo "${env.BUILD_MESSAGE}"
                sh 'echo "Shell message: $BUILD_MESSAGE"'
                sh 'mvn -f maven-demo/pom.xml clean package'
             }
           }
        stage('Validation') {
            steps {
                echo 'Validating project files...'
                echo "Build message in Validation: ${env.BUILD_MESSAGE}"
                sh 'test -f README.md'
                echo 'README file found successfully!'
            }
        }
    }

    post {
        success {
            echo 'Congratulations! Pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }

        always {
            echo 'Pipeline execution has finished.'
        }
    }
}
