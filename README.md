# cicddemo
CI CD demo using Spring boot and Docker deployment

The CI CD demo project provides a springboot sample Java Application. The CI & CD process is managed via Jenkins and AWS CLI. The Jenkins 
task gets executed whenever there is a change in the github repository. Once the compilation and execution of tests are successful, the 
Jenkins job initiates the SonarQube check to ensure no high priority issues are introduced in this branch. The github also ensures that
push requests are peer-reviewed before the final check-in is complete.

Changes to be done to be able to deploy this app in your AWS environment
1. Create an EC2 instance server that has the jenkins server installed
2. Import the jenkins job from the resources/jenkins folder
3. Setup the credentials for docker hub in the maven repository by using the server tag inside the settings.xml file. 
Add the following server configurations
<servers>
  <server>
    <id>docker-hub</id>
    <username>REPLACE_USER_NAME</username>
    <password>REPLACE_PASSWORD</password>
    <configuration>
      <email>REPLACE_EMAIL</email>
    </configuration>
  </server>
</servers>

4. Add the serverID attribute in pom.xml within the configuration section inside <artifactId>docker-maven-plugin</artifactId>
  <configuration>
      [...]
      <serverId>docker-hub</serverId>
    </configuration>
5  You can also setup the docker-hub credentials by logging in to the docker hub from the EC2 instance that is running the Jenkins server. 
You can skip step 3 and 4 if you do this. You can use the command "docker login" to provide the credentials. These credentials will be 
logged for a period of 12 hours. This may work fine for temporary testing, however for proper CI / CD process, steps 3 and 4 will be 
necessary. You can encrypt the password using maven configuration tools
6.



