pipeline {
    agent any
    stages {
        stage('Prepare') {
            sh "npm install -g yarn"
            sh "yarn install"
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
                sh 'GIT_USER=daemswibowo USE_SSH=true DEPLOYMENT_BRANCH=gh-pages yarn deploy'
            }
        }
    }
}