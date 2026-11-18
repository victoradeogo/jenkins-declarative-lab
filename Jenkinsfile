
pipeline {
    agent any
    
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

        stage('Build') {
            steps {
                echo 'this is the build stage'
                
            }
        }
      
        stage('Test') {
        
            steps {
                echo 'This is the test stage'
                
            }
        }

      stage('Package') {
        
            steps {
                echo 'This is the package stage'
            
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
