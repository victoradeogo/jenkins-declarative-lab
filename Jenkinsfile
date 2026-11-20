
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
                        '''
              
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
      
       
         always {junit 'maven-demo/target/surefire-reports/TEST-*.xml'
         archiveArtifacts artifacts: 'maven-demo/target/*.jar', fingerprint: true 
         echo 'End of pipeline'
               }
            
         success {echo 'congratulations, your pipeline was successful'
        } 
         failure{echo 'Your pipeline failed, check your pipeline script'
            }
                
                
              
         
     

 }     
 
}
