pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean test -DskipTests=true'
            }
        }
        stage('Test running') {
            steps {
                bat 'mvn clean test -DsuiteXml="DDTest"'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/logs/*', allowEmptyArchive: true
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}