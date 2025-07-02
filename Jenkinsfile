pipeline {
    agent any



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
                // Exemplo real: sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
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
                // sh './deploy-hml.sh'
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
                // sh './deploy-prod.sh'
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
