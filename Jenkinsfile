pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'jdk-21', type: 'jdk'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean compile'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Package') {
            steps {
                sh './mvnw package -DskipTests'
            }
        }

        stage('Deploy Simulado') {
            steps {
                echo 'Deploy fictício realizado com sucesso!'
            }
        }
    }
}
