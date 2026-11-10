
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
                sh 'git --version'
                sh 'java -version'
                sh 'pwd'
                sh 'ls -la'
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
