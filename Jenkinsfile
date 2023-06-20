pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your repository
                git branch: 'master', url: 'https://github.com/Vihanga22365/springboot-assignment.git'
            }
        }

        stage('Build and Deploy Configuration Service') {
            steps {
                dir('configuaration-server') {
                    // Build the configuration-service using Maven
                    sh 'mvn clean package'

                    // Deploy the configuration-service WAR file to Tomcat
                    sh 'curl --upload-file target/configuration-server.war "http://localhost:8080/manager/text/deploy?path=/configuration-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Department Service') {
            steps {
                dir('department-service') {
                    // Build the department-service using Maven
                    sh 'mvn clean package'

                    // Deploy the department-service WAR file to Tomcat
                    sh 'curl --upload-file target/department-service.war "http://localhost:8080/manager/text/deploy?path=/department-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Discovery Service') {
            steps {
                dir('discovery-service') {
                    // Build the discovery-service using Maven
                    sh 'mvn clean package'

                    // Deploy the discovery-service WAR file to Tomcat
                    sh 'curl --upload-file target/discovery-service.war "http://localhost:8080/manager/text/deploy?path=/discovery-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Employee Service') {
            steps {
                dir('employee-service') {
                    // Build the employee-service using Maven
                    sh 'mvn clean package'

                    // Deploy the employee-service WAR file to Tomcat
                    sh 'curl --upload-file target/employee-service.war "http://localhost:8080/manager/text/deploy?path=/employee-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Report Service') {
            steps {
                dir('report-service') {
                    // Build the report-service using Maven
                    sh 'mvn clean package'

                    // Deploy the report-service WAR file to Tomcat
                    sh 'curl --upload-file target/report-service.war "http://localhost:8080/manager/text/deploy?path=/report-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Scheduler Service') {
            steps {
                dir('sheduler-service') {
                    // Build the scheduler-service using Maven
                    sh 'mvn clean package'

                    // Deploy the scheduler-service WAR file to Tomcat
                    sh 'curl --upload-file target/scheduler-service.war "http://localhost:8080/manager/text/deploy?path=/scheduler-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Cleanup') {
            steps {
                // Clean up any artifacts or temporary files if needed
                deleteDir()
            }
        }
    }
}
