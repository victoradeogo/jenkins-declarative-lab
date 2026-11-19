
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
                sh ''' cd maven-demo
                       mvn clean compile
                       ls -lh target/*.jar '''
              
             }
           }
        stage('Test') {
            steps {
                echo 'Testing the application...'
                sh ''' cd maven-demo
                       mvn test '''
            
            }
         }

       stage('Package') {
            steps {
                echo 'packaging the application...'
                sh ''' cd maven-demo
                   mvn package -DskipTests '''
            
            }
        }
    }
   
    post{
         success{echo 'congratulations, your pipeline was successful'
        } 
         failure{echo 'Your pipeline failed, check your pipeline script'}
       
         always{echo 'End of pipeline'
         junit 'maven-demo/target/surefire-reports/TEST-*.xml'
     }

 }     
 
}
