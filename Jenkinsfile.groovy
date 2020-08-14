#!/usr/bin/groovy

branch_list = ['master']
if (env.BRANCH_NAME in branch_list){
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
