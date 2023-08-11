pipeline {
    agent any
    stages {
        stage('Fetch code from Github') {
            steps {
                echo '***************Fetching the code*********************'
                git branch: 'main', url: 'https://github.com/vinodkumar117/POM-selenium-webdriver.git'
            }
        }
        stage('Code Build with Maven') {
            steps {
                bat 'mvn clean -DskipTests'
            }
        }
        stage('Execute smoke tests') {
            steps {
                bat 'mvn test'
            }
        }
        stage('SonarQube analysis') {
            steps {
                    withSonarQubeEnv("Sonarqube-scan") {
                    bat "mvn sonar:sonar"
               }
                
            }
        }
        stage('SonarQube Quality Gate Check') {
            steps {
                script {
                    def qg = waitForQualityGate()
                    if (qg.status != 'OK') {
                        error 'Pipeline failed due to Quality Gate check!'
                    }
                }
            }
        }
        stage('Publish binaries to artifactory'){
            steps{
                rtMavenDeployer(
                    id: 'deployer',
                    serverId: 'jfroInstance',
                    releaseRepo: 'maven-repo-local',
                    snapshotRepo:'maven-repo-local'
                )
                rtMavenRun(
                    pom: 'pom.xml',
                    goals: 'clean install -DskipTests',
                    deployerId: 'deployer'
                )
                rtPublishBuildInfo(
                    serverId: 'jfroInstance'
                )
            }
        }
        
    }
    
}
