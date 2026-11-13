
pipeline {
    agent any

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
            steps {
                echo 'Building Maven application...'
                sh 'mvn -f maven-demo/pom.xml clean package'
             }
           }
        stage('Validation') {
            steps {
                echo 'Validating project files...'
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
