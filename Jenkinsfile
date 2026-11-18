
pipeline {
    agent any
    environmnet{ APP_NAME = 'Jenkins-training-app'
                BUILD_ENV = 'development'
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
                sh 'git --version'
                sh 'java -version'
                sh 'pwd'
                sh 'ls -la'
            }
        }

        stage('Display configurations') {
            steps {
                echo 'Application: ${APP_NAME}'
                echo 'Environment: ${BUILD_ENV}
                sh 'echo "Running on : ${hostname}"'
            }
        }
      
        stage('Build simulation') {
        environment{
            BUILD_STAGE = 'simulation' }
        
            steps {
                echo 'Application: ${APP_NAME}'
                echo 'Current build stage: ${BUILD_STAGE}'
                echo 'Build stage going on ....'
            sh ' echo "Build simulation successful..."'
            }
        }

      stage('Build simulation') {
        environment{
            BUILD_STAGE = 'Test' }
        
            steps {
                echo 'Application: ${APP_NAME}'
                echo 'Current stage: ${BUILD_STAGE}'
                echo 'Preparing to test application....'
                sh ' echo "Test successful...."'
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
