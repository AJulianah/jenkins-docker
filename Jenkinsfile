def groovy

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
          groovy = load "script.groovy"
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
        script{
          groovy.build()
        }
      }
    }
    stage("Test"){
      steps{
        script{
          groovy.test()
        }
      }
      post{
        success{
          echo "Test is success!"
          mail to: 'anjanirinajulie@gmail.com.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
          
          archiveArtifacts(artifacts: '**/*.txt', followSymlinks: false)
         // influxDbPublisher(selectedTarget: 'influxdb')
        }
        failure{
          echo "Test is failed!"
        }
      }
    }
    stage("Deploy"){
      steps{
        script{
          groovy.deploy()
        }
      }
      post{
        success{
          echo "Deploy is successful"
        }
        failure{
          echo "Deploy is failed"
        }
      }
    }
    stage("Publish data to influxdb"){
      steps{
        step([$class: 'InfluxDbPublisher', selectedTarget: 'influxdb'])
      }
    }
  }
}
