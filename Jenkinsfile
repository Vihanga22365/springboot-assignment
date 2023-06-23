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
                    // Build the discovery-service using Maven
                    bat 'mvn clean compile package'

                    // Stop the local Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server

                    // Copy the newly built WAR file to the Tomcat webapps directory
                    bat 'copy target/discovery-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'

                    // Start the Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
                }
            }
        }

//         stage('Build and Deploy Configuration Service') {
//             steps {
//                 dir('configuaration-server') {
//                     // Build the discovery-service using Maven
//                     bat 'mvn clean compile package'
//
//                     // Stop the local Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server
//
//                     // Copy the newly built WAR file to the Tomcat webapps directory
//                     bat 'copy target/configuaration-server-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
//
//                     // Start the Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
//                 }
//             }
//         }

        stage('Build and Deploy Department Service') {
            steps {
                dir('department-service') {
                    // Build the discovery-service using Maven
                    bat 'mvn clean compile package'

                    // Stop the local Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server

                    // Copy the newly built WAR file to the Tomcat webapps directory
                    bat 'copy target/department-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'

                    // Start the Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
                }
            }
        }

        stage('Build and Deploy Employee Service') {
            steps {
                dir('employee-service') {
                    // Build the discovery-service using Maven
                    bat 'mvn clean compile package'

                    // Stop the local Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server

                    // Copy the newly built WAR file to the Tomcat webapps directory
                    bat 'copy target/employee-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'

                    // Start the Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
                }
            }
        }

        stage('Build and Deploy Report Service') {
            steps {
                dir('report-service') {
                    // Build the discovery-service using Maven
                    bat 'mvn clean compile package'

                    // Stop the local Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server

                    // Copy the newly built WAR file to the Tomcat webapps directory
                    bat 'copy target/report-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'

                    // Start the Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
                }
            }
        }

        stage('Build and Deploy Scheduler Service') {
            steps {
                dir('sheduler-service') {
                    // Build the discovery-service using Maven
                    bat 'mvn clean compile package'

                    // Stop the local Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server

                    // Copy the newly built WAR file to the Tomcat webapps directory
                    bat 'copy target/sheduler-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'

                    // Start the Tomcat server
                    bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
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
