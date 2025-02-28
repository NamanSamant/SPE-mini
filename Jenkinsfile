pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "naman/calculator:latest"   // Your Docker Hub image
        CONTAINER_NAME = "calculator-app"         // Name of the running container
        PORT = "8080"                             // Port mapping
    }

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    echo "Checking out the repository..."
                    checkout scm
                }
            }
        }

        stage('Pull Latest Docker Image') {
            steps {
                script {
                    echo "Pulling the latest Docker image from Docker Hub..."
                    sh 'docker pull ${DOCKER_IMAGE}'
                }
            }
        }

        stage('Stop and Remove Existing Container') {
            steps {
                script {
                    echo "Checking if container is running..."
                    sh '''
                    if [ $(docker ps -q -f name=${CONTAINER_NAME}) ]; then
                        echo "Stopping existing container..."
                        docker stop ${CONTAINER_NAME}
                        echo "Removing existing container..."
                        docker rm ${CONTAINER_NAME}
                    else
                        echo "No existing container found."
                    fi
                    '''
                }
            }
        }

        stage('Run New Container') {
            steps {
                script {
                    echo "Starting a new container from the latest image..."
                    sh '''
                    docker run -d --name ${CONTAINER_NAME} -p ${PORT}:8080 ${DOCKER_IMAGE}
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "Deployment successful! 🎉"
        }
        failure {
            echo "Deployment failed! ❌"
        }
    }
}
