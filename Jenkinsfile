pipeline {
    agent any

    tools {
        maven 'Maven 3'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t ryougilee/sum-product_fx:latest .'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker compose down'
                bat 'docker compose up -d'
            }
        }

        stage('Verify') {
            steps {
                sleep 10
                bat 'docker exec calculator-db mariadb -uroot -p114514 -e "USE calc_data; SHOW TABLES;"'
            }
        }
    }
}
