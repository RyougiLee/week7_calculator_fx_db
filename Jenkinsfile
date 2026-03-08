pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'JDK 25'
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
                sleep 15
                bat 'docker logs calculator-app'
                bat 'docker exec calculator-db mariadb -uroot -p114514 -e "USE calc_data; SELECT * FROM calc_results;"'
            }
        }
    }
}
