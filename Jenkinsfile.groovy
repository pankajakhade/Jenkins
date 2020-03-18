#!/usr/bin/groovy

def x = 1
stage('Print x'){
    print x
}
node{
    stage('SCM'){
        checkout scm
    }    
    stage('Read File'){
        File file = new File('textfile')
        print file.exists()
    }
}
