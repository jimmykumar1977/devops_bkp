pipeline {
    agent any 
    stages {
        stage('Compile') { 
            steps {
                sh "./gradle test"
            }
        }
    }
}