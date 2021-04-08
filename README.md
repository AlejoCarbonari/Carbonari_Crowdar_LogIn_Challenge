# Carbonari_Crowdar_LogIn_Challenge

Bienvenidos a mi Challenge.

# Installation

Para correr las siguientes pruebas, deberemos contar con la última versión estable de Chrome. <br />

# Linux OS

* Chrome
Suponiendo que ya tiene instalada la clave de Repositorio Google Linux, siga los siguientes pasos: <br />

Dado el caso de no tener instalado el Repositorio Google Linux, consulte más abajo.

En caso de no tener instalado chrome ejecute el siguiente comando en la terminal (CTRL+ALT+T): <br />
$ sudo apt-get install google-chrome-beta <br />

De lo contrario, si necesita actualizar su navegador, ejecute lo siguiente: <br />
$ sudo apt-get --only-upgrade install google-chrome-stable <br />

Una vez completados los pasos necesarios para la actualización del navegador, queda matar los procesos activos de chrome que pueden estar corriendo en segundo plano: <br />
$ sudo pkill chrome <br />

* Firefox <br />
$ sudo add-apt-repository ppa:ubuntu-mozilla-security/ppa <br />
$ sudo apt update <br />
$ sudo apt install Firefox <br />

$ sudo apt install --only-upgrade firefox <br />

# Instalación del Repositorio google-chrome
*Siga los mismos pasos que en la instalación de Chrome <br />

$ wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add - <br />
$ sudo sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list' <br />
$ sudo apt update <br />

# Instalación y configuration de MAVEN

$ sudo apt install maven <br />
           or <br />
$ wget https://www-us.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-X.X.X-bin.tar.gz -P /tmp/ <br />
$ sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt/ <br />
$ sudo ln -s /opt/apache-maven-3.5.4 /opt/maven <br />

*Configuramos PATH <br />
$ export MAVEN_HOME="/opt/maven" <br />
$ export M2_HOME="/opt/maven" <br />
$ PATH=$M2_HOME/bin:$PATH <br />
$ export PATH=${M2_HOME}/bin:${PATH} <br />
$ sudo chmod +x /etc/profile.d/maven.sh <br />
$ source /etc/profile.d/maven.sh <br />

$ mvn -v >
OUTPUT: Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fexx; 2018-06-17T15:33:14-03:00) <br />

# MAC OS

# Brew Installation

$ /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)" <br />

* Chrome <br />
$ brew install --cask google-chrome <br />

* Firefox <br />
$ brew install --cask firefox <br />

# HOW TO RUN TESTS IN LINUX

*Clean all
$ mvn clean

*Chrome <br />
$ mvn test -Dwebdriver.chrome.driver="src/test/resources/drivers/chromedriver" <br />

*Firefox <br />
$ $ mvn test -Dwebdriver.gecko.driver="src/test/resources/drivers/geckodriver" <br />

# HOW TO RUN TESTS IN MAC OS

*Chrome <br />
$ mvn test -Dwebdriver.chrome.driver="src/test/resources/drivers/chromedriver_mac" <br />

*Firefox <br />
$ mvn test -Dwebdriver.gecko.driver="src/test/resources/drivers/geckodriver_mac" <br />

# HOW TO RUN TESTS IN WINDOWS

*Chrome <br />
$ mvn test -Dwebdriver.chrome.driver="src/test/resources/drivers/chromedriver.exe" <br />

*Firefox <br />
$ mvn test -Dwebdriver.gecko.driver="src/test/resources/drivers/geckodriver.exe" <br />



# TEST CASES

FEATURES: LogIn HAPPY PATH

Background:
> ✅ Dado que el usuario abre el navegador <br />
✅ Y navega hacia Saucedemo <br />
✅ Entonces debería visualizar la página de inicio <br />

First Scenario: Usuario válido
> ✅ Cuando el usuario ingresa "<username>" en el campo username <br />
✅ Y "<password>" en el campo password <br />
✅ Y hace click en el botón submit <br />
✅ Entonces debería visualizar el inventario de productos <br />

      Ejemplos:
         | username                | password     |
         | standard_user           | secret_sauce |

Second Scenario: Usuario bloqueado & credenciales erróneas
> ✅ Cuando el usuario ingresa "<username>" en el campo username <br />
✅ Y "<password>" en el campo password <br />
✅ Y hace click en el botón submit <br />
✅ Entonces debería visualizar un error con el siguiente mensaje: "<expectedMessage>" <br />

      Ejemplos:
            | username                | password     | expectedMessage                                                           |
            | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
            | error_username          | secret_sauce | Epic sadface: Username and password do not match any user in this service |
            |                         | no_username  | Epic sadface: Username is required                                        |
            | no_password             |              | Epic sadface: Password is required                                        |
      
Esquema del escenario: Usuario con problemas
> ✅ Cuando el usuario ingresa "<username>" en el campo username <br />
✅ Y "<password>" en el campo password <br />
✅ Y hace click en el botón submit <br />
✅ Entonces debería visualizar correctamente las imágenes en el inventario <br />

      Ejemplos:
            | username                | password     |
            | problem_user            | secret_sauce |

   Éste último paso fallará!
