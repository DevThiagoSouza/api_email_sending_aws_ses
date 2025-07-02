pipeline {
    agent any
environment {
    MAVEN_HOME = tool name: 'Maven 3.9.6'
}
...
stage('Build') {
    steps {
        sh "${MAVEN_HOME}/bin/mvn clean compile"
    }
}

    options {
        skipStagesAfterUnstable()
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Compilando o projeto..."
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Testes Unitários') {
            steps {
                echo "Executando testes unitários..."
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }

        stage('SonarQube Quality Gate') {
            when {
                branch 'develop'
            }
            steps {
                echo "Simulando análise de qualidade..."
                // Exemplo: sh "mvn sonar:sonar"
            }
        }

        stage('Empacotar') {
            steps {
                echo "Empacotando JAR..."
                sh "${MAVEN_HOME}/bin/mvn package -DskipTests"
            }
        }

        stage('Deploy Homologação') {
            when {
                branch 'develop'
            }
            steps {
                echo "Deploy para ambiente de homologação"
                // Simulado: sh './deploy-hml.sh'
            }
        }

        stage('Aprovação para Produção') {
            when {
                branch 'main'
            }
            steps {
                input message: "Aprovar deploy para produção?"
            }
        }

        stage('Deploy Produção') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploy para produção"
                // Simulado: sh './deploy-prod.sh'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizada.'
        }
        success {
            echo '✅ Sucesso!'
        }
        failure {
            echo '❌ Falhou.'
        }
    }
}
