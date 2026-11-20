
pipeline {
    agent any
     parameters {
        choice(
            name: 'APP_ENV',
            choices: ['development', 'testing', 'production'],
            description: 'Select the deployment environment'
        )
      }
    environment {
        APP_NAME = 'maven-demo'
        APP_VERSION = '1.0-SNAPSHOT'
        BUILD_TOOL = 'Maven'
       }
    options {
    skipStagesAfterUnstable()
       }
   
    stages {
        stage('Show Configuration') {
          steps {
           echo "Selected deployment environment: ${params.APP_ENV}"
             }
           }
        stage('Show Environment Variables') {
          steps {
           echo "Application Name: ${env.APP_NAME}"
           echo "Application Version: ${env.APP_VERSION}"
           echo "Build Tool: ${env.BUILD_TOOL}"
             }
           }

        stage('Error Handling Demo') {
          steps {
            script {
              try {
                echo 'Starting operation...'
                error 'Simulated application error!'
                 } catch (err) {
                echo "An error was caught: ${err}"
                }
             }
            }
          }
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
              catchError(buildResult: 'UNSTABLE', stageResult: 'UNSTABLE') {
            sh ''' cd maven-demo
                   mvn test '''
        }
            
            }
         }

       stage('Package') {
            steps {
                echo 'packaging the application...'
                sh ''' cd maven-demo
                   mvn package -DskipTests '''
            
            }
        }

        stage('Deploy to Development') {
          when {
            expression {
            params.APP_ENV == 'development'
           }
        }
          steps {
           echo 'Deploying application to development environment...'
       }
      }
        stage('Deploy to Production') {
            when {
              expression {
              params.APP_ENV == 'production'
             }
          }
        steps {
          echo 'Deploying application to production environment...'
        }
       }
      }
   
    post{
      
       
         always {junit 'maven-demo/target/surefire-reports/TEST-*.xml'
        
         echo 'End of pipeline'
               }
            
         success {
             archiveArtifacts artifacts: 'maven-demo/target/*.jar', fingerprint: true 
             echo 'congratulations, your pipeline was successful'
        } 
         failure{echo 'Your pipeline failed, check your pipeline script'
            }
          unstable {
          echo 'WARNING: Your pipeline is unstable. Please investigate.'
           }      
                
         }     
 
}
