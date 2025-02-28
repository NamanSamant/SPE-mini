pipeline {
    agent any

    environment {
        LANG = "C.UTF-8"
        LC_ALL = "C.UTF-8"
    }

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    echo 'Checking out the repository...'
                    checkout scm
                }
            }
        }

        stage('Login to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'docker-hub-password', variable: 'DOCKER_PASS')]) {
                    sh '''
                    echo $DOCKER_PASS | docker login -u naman906 --password-stdin
                    '''
                }
            }
        }

        stage('Pull Latest Docker Image') {
            steps {
                script {
                    echo 'Pulling the latest Docker image from Docker Hub...'
                    sh 'docker pull naman906/calculator:latest'
                }
            }
        }

        stage('Stop and Remove Existing Container') {
            steps {
                script {
                    sh '''
                    docker stop mini || true
                    docker rm mini || true
                    '''
                }
            }
        }

        stage('Run New Container') {
            steps {
                script {
                    sh 'docker run -d --name mini -p 9090:8080 naman906/calculator:latest'
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                script {
                    echo 'Deploying with Ansible...'
                    sh '''
                    export LANG=C.UTF-8
                    export LC_ALL=C.UTF-8
                    ansible-playbook -i hosts deploy.yml
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment successful! ✅'
        }
        failure {
            echo 'Deployment failed! ❌'
        }
    }
}

