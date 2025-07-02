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
                sh "./mvnw clean compile"
            }
        }

        stage('Testes Unitários') {
            steps {
                echo "Executando testes unitários..."
                sh "./mvnw test"
            }
        }

    

        stage('Empacotar') {
            steps {
                echo "Empacotando JAR..."
                sh "./mvnw clean package -DskipTests"
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
