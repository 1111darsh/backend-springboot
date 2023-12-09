# backend-springboot
This is simple java spring boot application 


# Block

DOCKER IMAGE IS NOT BUILDING

Install openjdk 17
```bash
sudo apt install wget -y

wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb

sudo apt install ./jdk-17_linux-x64_bin.deb


java --version
export JAVA_HOME=/usr/lib/jvm/jdk-17/
export PATH=$PATH:$JAVA_HOME/bin

```

To run Application

```bash
git clone https://github.com/1111darsh/backend-springboot.git
./gradlew bootRun
./gradlew build




java -jar build/libs/backend-springboot-0.0.1-SNAPSHOT.jar 


```