// Estructura de un job 
// {"name":"miJob",
//  "lastBuild":{"building":false,
//               "duration":371121,
//               "result":"SUCCESS",
//               "timestamp":1263334567000}}

Random random = new Random();
String mensaje;

// Se reemplazan los guiones por espacios en el nombre de proyecto
String nombreProyecto = payload.name.replaceAll("-"," ");

// Cuando el proyecto se esta compilando el atributo result se encuentra en null
String result = payload.lastBuild.result == null ? "BUILDING" : payload.lastBuild.result;

// Listas para crear mensajes dependiendo del estado
List listBuilding = ["El proyecto ${nombreProyecto} se esta ejecutando. Sale con fritas !!!!", 
                    "Aguanta un rato que el proyecto ${nombreProyecto} se está ejecutando.",
                    "20 pesos al proyecto ${nombreProyecto} que se esta ejecutando."];

List listSuccess = ["El proyecto ${nombreProyecto} terminó exitosamente. FELICITACIONES !!!!",
                    "Quien lo diría. El proyecto ${nombreProyecto} terminó todo bien.",
                    "El proyecto ${nombreProyecto} terminó con éxito. Chupate esta mandarina.",
                    "Aprovechá y sacale una foto al proyecto ${nombreProyecto} que terminó exitosamente.",
                    "El proyecto ${nombreProyecto} terminó exitosamente. Una manteca nene !!!!"];

List listFail = ["El proyecto ${nombreProyecto} terminó con errores", 
                 "Macacos, el proyecto ${nombreProyecto} se hizo pelota y no funciona.",
                 "Se estrelló feo el proyecto ${nombreProyecto} y quedó como tirado en una zanja.",
                 "Ojo muchachos que el proyecto ${nombreProyecto} terminó con errores"];

List listUnstable = ["El proyecto ${nombreProyecto} terminó inestable", 
                     "El proyecto ${nombreProyecto} está hecho un flancito endeble, terminó todo raro.",
                     "Pegale una mirada al proyecto ${nombreProyecto} que quedo inestable"];

List listAborted = ["El proyecto ${nombreProyecto} fue abortado", 
                    "Ufff, y si se deciden? Abortaron la ejecución de ${nombreProyecto}",
                    "El proyecto ${nombreProyecto} hizo trabajar demás a Jenkins porque lo abortaron.",
                    "A ver quién abortó al proyecto ${nombreProyecto}, hay tabla",
                     "Ojo al piojo que abortaron el proyecto ${nombreProyecto}"];

// Mapa donde se relacionan los estados con las listas
Map messageMap = [SUCCESS:listSuccess,
                  BUILDING:listBuilding,
                  FAILURE:listFail,
                  UNSTABLE:listUnstable,
                  ABORTED:listAborted];

// Obtenemos la lista correspondiente al estado
List messageList = messageMap.get(result);

if (messageList == null) {
    println "El proyecto ${nombreProyecto} tiene el estado ${result} que es desconocido para el sistema";
    mensaje = "El sistema no puede reconocer el estado ${result} con el que terminó el proyecto ${nombreProyecto}";
} else {
    // Se obtiene de manera aleatoria el mensaje a reproducir.
    mensaje = messageList[random.nextInt(messageList.size())];
}

return mensaje;