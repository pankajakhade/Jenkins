#!/usr/bin/groovy

node{
    stage('SCM'){
        checkout scm
    }    
    stage('Read File'){
        def my_file = env.WORKSPACE + '/textfile'
        File file = new File(my_file)
        print file.text
    }
    stage('Get Buildcause'){
        def buildCauses = currentBuild.getBuildCauses()
        print buildCauses
    }
    stage('Get EC2 Instances'){
        withCredentials([string(credentialsId: 'aws-secret-id', variable: 'awsCredentialsId')]) {
            withCredentials([$class           : 'AmazonWebServicesCredentialsBinding',
                          accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                          credentialsId    : awsCredentialsId,
                          secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'])
                {
                  sh 'aws ec2 describe-instances --filters "Name=instance-type,Values=t2.micro" --query "Reservations[].Instances[].InstanceId"'
                }
      }
    }
}

