pipeline {
    agent any

    tools {
        jdk 'Java_22'
        maven 'Maven_3.9.9'
    }

    environment {
        IMAGE_NAME = "likith3/employee-management-system:1.0"
    }

    stages {

        stage('Checkout Source Code') {
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

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package Application') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Deploy Artifact to Nexus') {
            steps {
                bat 'mvn -s C:\\Users\\likit\\.m2\\settings.xml deploy'
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

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t employee-management-system:1.0 .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'likith3',
                    passwordVariable: 'Liki@0105'
                )]) {
                    bat '''
                    docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                    docker push %IMAGE_NAME%
                    docker logout
                    '''
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                bat '''
                docker rm -f ems-app || exit /b 0
                docker run -d --name ems-app -p 9090:8080 likith3/employee-management-system:1.0
                '''
            }
        }
    }

    post {

        success {
            echo '==========================================='
            echo ' Build Successful'
            echo ' Source Code Checked Out'
            echo ' Maven Build Completed'
            echo ' Unit Tests Passed'
            echo ' JAR Packaged'
            echo ' Artifact Deployed to Nexus'
            echo ' SonarQube Analysis Completed'
            echo ' Docker Image Built'
            echo ' Docker Image Pushed to Docker Hub'
            echo ' Docker Container Started'
            echo '==========================================='
        }

        failure {
            echo '==========================================='
            echo ' Pipeline Failed'
            echo ' Check Jenkins Console Output'
            echo '==========================================='
        }

        always {
            cleanWs()
        }
    }
}