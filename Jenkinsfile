
pipeline {
    agent any
   
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('checkout') {
            steps {
                 echo 'Checking out from scm'
              
            }
        }


        stage('Build') {
         
            steps {
                echo 'Building Maven application...'
              
             }
           }
        stage('Test') {
            steps {
                echo 'Testing the application...'
            
            }
         }

       stage('Package') {
            steps {
                echo 'packaging the application...'
            
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
}
