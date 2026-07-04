pipeline {
    agent any

    tools {
        jdk 'Java_22'
        maven 'Maven_3.9.9'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Liki-S/EMS.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Deploy to Nexus') {
            steps {
                bat 'mvn -s C:\\Users\\likit\\.m2\\settings.xml clean deploy'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQubeServer') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
    }

    post {
        success {
            echo '======================================='
            echo 'Build, Nexus Deployment and SonarQube Analysis Successful!'
            echo '======================================='
        }

        failure {
            echo '======================================='
            echo 'Pipeline Failed! Check the Console Output.'
            echo '======================================='
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}