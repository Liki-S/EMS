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
                bat '''
                mvn sonar:sonar ^
                -Dsonar.host.url=http://localhost:9000 ^
                -Dsonar.token=squ_60465b9e88d2745b8c9d443c43c3a7ba80ac835f
                '''
            }
        }
    }

    post {
        success {
            echo '======================================='
            echo 'Build Successful!'
            echo 'Tests Executed Successfully!'
            echo 'Application Packaged Successfully!'
            echo 'Artifacts Deployed to Nexus Successfully!'
            echo 'SonarQube Analysis Completed Successfully!'
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