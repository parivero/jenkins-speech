jenkins-speech
==============
Aplicación java que habla los resultados de Jenkins. Esta aplicación está desarrollada con [Spring Integration](http://www.springsource.org/spring-integration) y utiliza la librería [java-google-translate-text-to-speech](http://code.google.com/p/java-google-translate-text-to-speech/) para la reproducción del audio.

Compilación y ejecución:
==============
Clonar el proyecto, ejecutar el comando “mvn install“, este comando genera tres distribuibles en el directorio target, solo hay que descomprimir el archivo en un directorio y ejecutar la aplicación.
```
java -jar jenkins-speech-1.0.RELEASE.jar
```
En caso de estar detrás de un proxy:
```
java -Dhttp.proxyHost=localProxy.com -Dhttp.proxyPort=8080 -Dhttp.nonProxyHosts=myHost  -jar jenkins-speech-1.0.RELEASE.jar
```
Configuración:
==============
El archivo [jenkins-speech.properties](https://github.com/parivero/jenkins-speech/blob/master/src/main/resources/jenkins-speech.properties) contiene las variables utilizadas por la aplicación, la más importante es `jenkins.url.home`, esta variable debe apuntar al home de Jenkins. Después están las variables que indican la frecuencia de ejecución `trigger.request.cron` donde se configura la expresión cron y `trigger.request.fixedRate` donde se debe configurar en milisegundos cada cuanto se dispara la ejecución, esto último es para poder realizar el cálculo de fechas y poder filtrar las ejecuciones viejas. En este archivo también están configurados el idioma en que se quiere reproducir el audio y el script encargado de armar el texto a reproducir, cambiando estos dos valores es posible modificar los textos y el idioma de reproducción.
