pipeline{
  agent any
  stages{
    stage("Build"){
      steps{
        echo 'Building'
      }
    }
    stage("Test"){
      steps{
        sh '''
          cd "/var/lib/jenkins/ivehte-web-test-api"
          npx playwright test
        '''
      }
    }
    stage("Deploy"){
      steps{
        echo 'Deploy'
      }
    }
  }
}
