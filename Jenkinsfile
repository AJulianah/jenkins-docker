pipeline{
  agent any
  parameters{
    choice(name: 'VERSION', choices: ['1.1.0', '1.1.1'], description: '')
    booleanParam(name: 'executeTests', defaultValue: true, description: '')
  }
  stages{
    stage("Build"){
      when{
        expression{
          params.executeTests
        }
      }
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
