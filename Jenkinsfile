pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your repository
                git branch: 'master', url: 'https://github.com/Vihanga22365/springboot-assignment.git'
            }
        }

        stage('Build and Deploy Discovery Service') {
            steps {
                dir('discovery-service') {

                    echo "Inside Discovery Server up"
                    // Build the discovery-service using Maven
                    bat 'mvn clean compile package'

                    echo "Inside Discovery Server down"
                    // Stop the local Tomcat server
                    // Stop the local Tomcat server
                                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server

                                    // Copy the newly built WAR file to the Tomcat webapps directory
                                    bat 'copy target/discovery-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'

                                    // Start the Tomcat server
                                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
                }
            }
        }

        stage('Build and Deploy Configuration Service') {
            steps {
                dir('configuaration-server') {
                    // Build the configuration-service using Maven
                    sh 'mvn clean compile package'

                    // Deploy the configuration-service WAR file to Tomcat
                    sh 'curl --upload-file target/configuration-server.war "http://localhost:8080/manager/text/deploy?path=/configuration-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Department Service') {
            steps {
                dir('department-service') {
                    // Build the department-service using Maven
                    sh 'mvn clean compile package'

                    // Deploy the department-service WAR file to Tomcat
                    sh 'curl --upload-file target/department-service.war "http://localhost:8080/manager/text/deploy?path=/department-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Employee Service') {
            steps {
                dir('employee-service') {
                    // Build the employee-service using Maven
                    sh 'mvn clean compile package'

                    // Deploy the employee-service WAR file to Tomcat
                    sh 'curl --upload-file target/employee-service.war "http://localhost:8080/manager/text/deploy?path=/employee-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Report Service') {
            steps {
                dir('report-service') {
                    // Build the report-service using Maven
                    sh 'mvn clean compile package'

                    // Deploy the report-service WAR file to Tomcat
                    sh 'curl --upload-file target/report-service.war "http://localhost:8080/manager/text/deploy?path=/report-service&update=true" --user admin:admin'
                }
            }
        }

        stage('Build and Deploy Scheduler Service') {
            steps {
                dir('sheduler-service') {
                    // Build the scheduler-service using Maven
                    sh 'mvn clean compile package'

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
