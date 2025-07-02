pipeline {
    agent any


    stages {
        stage('build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('test: integration & quality') {
            steps {
                sh 'mvn verify' // ou sonar, cobertura, etc
            }
        }

        stage('test: functional') {
            steps {
                sh './run-functional-tests.sh' // exemplo
            }
        }

        stage('test: load & security') {
            steps {
                sh './run-load-tests.sh' // exemplo
            }
        }

        stage('approval') {
            steps {
                input message: "Aprovar para produção?"
            }
        }

        stage('deploy: prod') {
            steps {
                sh './deploy-prod.sh' // exemplo
            }
        }
    }
}
