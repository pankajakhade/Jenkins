#!/usr/bin/groovy

list = ['master', 'new']
if (env.BRANCH_NAME in list)
{
    node{
        stage('SCM'){
            checkout scm
        }    
        /*stage('Read File'){
            def my_file = env.WORKSPACE + '/textfile'
            File file = new File(my_file)
            print file.text
        }*/
        stage('Get Buildcause'){
            def buildCauses = currentBuild.getBuildCauses()
            print buildCauses
        }
    }   
}
