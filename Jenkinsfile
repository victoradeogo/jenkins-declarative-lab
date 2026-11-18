
pipeline {
    agent any
   
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                
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

      post{
         success{echo 'congratulations, your pipeline was successful'
        } 
         failure{echo 'Your pipeline failed, check your pipeline script'}
         always{echo 'End of pipeline'
       }
     }

        
}
}
