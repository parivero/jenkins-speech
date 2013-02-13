jenkins-speech
==============
Aplicación java que habla los resultados de Jenkins. Esta aplicación está desarrollada con [Spring Integration](http://www.springsource.org/spring-integration) y utiliza la librería [java-google-translate-text-to-speech](http://code.google.com/p/java-google-translate-text-to-speech/) para la reproducción del audio.

Compilación y ejecución:
==============
Clonar el proyecto, ejecutar el comando “mvn install“, este comando genera tres distribuibles en el directorio target, solo hay que descomprimir el archivo en un directorio y ejecutar la aplicación.

java -jar jenkins-speech-1.0.RELEASE.jar

En caso de estar detrás de un proxy:

java -Dhttp.proxyHost=localProxy.com -Dhttp.proxyPort=8080 -Dhttp.nonProxyHosts=myHost  -jar jenkins-speech-1.0.RELEASE.jar
