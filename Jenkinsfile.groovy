pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps: {
                sh 'whoami'
            }
        }
        stage('Install') {
            steps {
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
                sh 'GIT_USER=root USE_SSH=true DEPLOYMENT_BRANCH=gh-pages yarn deploy'
            }
        }
    }
}