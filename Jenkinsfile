pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'naman906/calculator:latest'
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
        stage('Login to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                    }
                }
            }
        }
        stage('Pull Latest Docker Image') {
            steps {
                script {
                    echo "Pulling the latest Docker image from Docker Hub..."
                    sh "docker pull ${DOCKER_IMAGE}"
                }
            }
        }
        stage('Stop and Remove Existing Container') {
            steps {
                script {
                    sh "docker stop mini || true && docker rm mini || true"
                }
            }
        }
        stage('Run New Container') {
            steps {
                script {
                    sh 'docker run -it --name mini -p 9090:8080 naman906/calculator:latest'
                }
            }
        }
        stage('Deploy with Ansible') {
            steps {
                script {
                    echo "Running Ansible Playbook for deployment..."
                    sh "export LC_ALL=en_US.UTF-8 && export LANG=en_US.UTF-8 && ansible-playbook -i hosts deploy.yml"
                }
            }
        }
    }
    post {
        failure {
            echo "Deployment failed! ❌"
        }
    }
}

