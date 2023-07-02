pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your repository
                git branch: 'master', url: 'https://github.com/Vihanga22365/springboot-assignment.git'
            }
        }

        stage('Check Coverage, Cucumber Result and then Deploy Employee Service') {
            steps {
                script {

                    def coveragePercentage = findCoveragePercentage()
                    def cucumberTestResult = runCucumberTests()
                    echo "Unit test coverage: ${coveragePercentage}%"
                    echo "Cucumber: ${cucumberTestResult}"
                    if (coveragePercentage > 30) {
                        dir('employee-service') {
                            bat 'mvn clean compile package'
                            bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"'
                            bat 'copy target\\employee-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
                            bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
                        }
                    } else {
                        echo "Unit test coverage is below 30%. Skipping deployment of Employee Service."
                    }
                }
            }
        }


//         stage('Build and Deploy Discovery Service') {
//             steps {
//                 dir('discovery-service') {
//                     // Build the discovery-service using Maven
//                     bat 'mvn clean compile package'
//
//                     // Stop the local Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server
//
//                     // Copy the newly built WAR file to the Tomcat webapps directory
//                     bat 'copy target\\discovery-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
//
//                     // Start the Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
//                 }
//             }
//         }

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
//                     bat 'copy target\\configuaration-server-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
//
//                     // Start the Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
//                 }
//             }
//         }

//         stage('Build and Deploy Department Service') {
//             steps {
//                 dir('department-service') {
//                     // Build the discovery-service using Maven
//                     bat 'mvn clean compile package'
//
//                     // Stop the local Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server
//
//                     // Copy the newly built WAR file to the Tomcat webapps directory
//                     bat 'copy target\\department-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
//
//                     // Start the Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
//                 }
//             }
//         }

//         stage('Build and Deploy Employee Service') {
//             steps {
//                 dir('employee-service') {
//                     // Build the discovery-service using Maven
//                     bat 'mvn clean compile package'
//
//                     // Stop the local Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server
//
//                     // Copy the newly built WAR file to the Tomcat webapps directory
//                     bat 'copy target\\employee-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
//
//                     // Start the Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
//                 }
//             }
//         }

//         stage('Build and Deploy Report Service') {
//             steps {
//                 dir('report-service') {
//                     // Build the discovery-service using Maven
//                     bat 'mvn clean compile package'
//
//                     // Stop the local Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server
//
//                     // Copy the newly built WAR file to the Tomcat webapps directory
//                     bat 'copy target\\report-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
//
//                     // Start the Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
//                 }
//             }
//         }

//         stage('Build and Deploy Scheduler Service') {
//             steps {
//                 dir('sheduler-service') {
//                     // Build the discovery-service using Maven
//                     bat 'mvn clean compile package'
//
//                     // Stop the local Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/shutdown.bat"' // Stop the Tomcat server
//
//                     // Copy the newly built WAR file to the Tomcat webapps directory
//                     bat 'copy target\\sheduler-service-0.0.1-SNAPSHOT.war "C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/webapps/"'
//
//                     // Start the Tomcat server
//                     bat '"C:/Program Files/Apache Software Foundation/Tomcat 8.5_Tomcat8.1/bin/startup.bat"'
//                 }
//             }
//         }

        stage('Cleanup') {
            steps {
                // Clean up any artifacts or temporary files if needed
                deleteDir()
            }
        }
    }
}

def findCoveragePercentage() {
    dir('employee-service') {
        bat 'mvn clean test -P unitTest'
        def coverageReport = readFile(file: 'target/site/jacoco/index.html')

        def pattern = /<td class="ctr2">([\d.]+)%<\/td>/
        def matcher = (coverageReport =~ pattern)
        if (matcher.find()) {
            return matcher.group(1).toFloat()
        } else {
            return 0
        }
    }
}

def runCucumberTests() {
    dir('employee-service') {
        bat 'mvn clean verify -P cucumberTest'

        // Assuming you have a Cucumber report in XML format
            def cucumberReport = readFile(file: 'target/cucumber-results.xml')
    def cucumberTestResult = 0

    if (cucumberJsonFile.exists()) {
        def json = new JsonSlurper().parseText(cucumberJsonFile.text)
        def totalScenarios = json[0].elements.size()
        def passedScenarios = json[0].elements.findAll { it.status == 'passed' }.size()

        if (totalScenarios > 0) {
            cucumberTestResult = (passedScenarios * 100) / totalScenarios
        }
    }

    return cucumberTestResultss
    }
}