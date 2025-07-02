pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'jdk-17', type: 'jdk'
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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy Simulado') {
            steps {
                echo 'Simulando deploy do JAR gerado...'
            }
        }
    }
}
