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
          slackSend color: 'good',
                    message: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
          
          archiveArtifacts(artifacts: '**/*.txt', followSymlinks: false)
         // influxDbPublisher(selectedTarget: 'influxdb')
        }
        failure{
          slackSend color: 'danger',
                    message: "The pipeline ${currentBuild.fullDisplayName} is failed."
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
