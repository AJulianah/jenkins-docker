def gv

pipeline{
  agent any
  parameters{
    choice(name: 'VERSION', choices: ['1.1.0', '1.1.1'], description: '')
    booleanParam(name: 'executeTests', defaultValue: false, description: '')
  }
  stages{
    stage("Init"){
      steps{
        script{
          gv = load "script.groovy"
        }
      }
    }
    stage("Build"){
      when{
        expression{
          params.executeTests
        }
      }
      steps{
        gv.build()
      }
    }
    stage("Test"){
      steps{
        gv.test()
      }
    }
    stage("Deploy"){
      steps{
        gv.deploy()
      }
    }
  }
}
