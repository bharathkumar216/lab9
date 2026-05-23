pipeline {
 agent any

 stages {

  stage('Trigger Freestyle Project') {
   steps {

    script {

     def buildInfo = build job: 'qwertyu', wait: true

     echo "Build Number: ${buildInfo.number}"
     echo "Build Status: ${buildInfo.result}"

     if (buildInfo.result != 'SUCCESS') {
      error "Freestyle project failed!"
     }
    }
   }
  }

  stage('Result') {
   steps {
    echo "Build and Test executed successfully!"
   }
  }
 }
}
