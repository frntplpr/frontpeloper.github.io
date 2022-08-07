pipeline {
    agent any
    stages {
        stage('Install') {
            steps {
                sh 'whoami'
                sh 'yarn install'
            }
        }
        stage('Build') {
            steps {
                sh 'yarn build'
            }
        }
        stage('Deploy') {
            steps {
                sh 'USE_SSH=true DEPLOYMENT_BRANCH=gh-pages yarn deploy'
            }
        }
    }
}