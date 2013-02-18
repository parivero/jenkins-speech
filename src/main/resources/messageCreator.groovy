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

// Mapa donde se relacionan los estados con las listas
Map messageMap = [SUCCESS:["El proyecto ${nombreProyecto} terminó exitosamente. FELICITACIONES !!!!",
                           "Quien lo diría. El proyecto ${nombreProyecto} terminó todo bien.",
                           "El proyecto ${nombreProyecto} terminó con éxito. Chupate esta mandarina.",
                           "Aprovechá y sacale una foto al proyecto ${nombreProyecto} que terminó exitosamente.",
                           "El proyecto ${nombreProyecto} terminó exitosamente. Una manteca nene !!!!"],
                  BUILDING:["El proyecto ${nombreProyecto} se esta ejecutando. Sale con fritas !!!!", 
                            "Aguanta un rato, ${nombreProyecto}, se está ejecutando.",
                            "20 pesos al proyecto ${nombreProyecto}, que esta en ejecución.",
                            "Marche un ${nombreProyecto}, que comenzo su ejecución",
                            "Acaba de partir el proyecto ${nombreProyecto}, le deseamos un buen viaje."],
                  FAILURE:["El proyecto ${nombreProyecto} terminó con errores", 
                           "Macacos, el proyecto ${nombreProyecto} se hizo pelota y no funciona.",
                           "Se estrelló feo el proyecto ${nombreProyecto} y quedó como tirado en una zanja.",
                           "Ojo muchachos que el proyecto ${nombreProyecto} terminó con errores",
                           "Pedile una ambulancia a ${nombreProyecto}, que quedo destruido"],
                  UNSTABLE:["El proyecto ${nombreProyecto} terminó inestable", 
                            "El proyecto ${nombreProyecto} está hecho un flancito endeble, terminó todo raro.",
                            "Pegale una mirada al proyecto ${nombreProyecto} que quedo inestable",
                            "${nombreProyecto} busca psicólogo, esta medio inestable.",
                            "El proyecto ${nombreProyecto} está inestable como chigua gua esquizofrénico."],
                  ABORTED:["El proyecto ${nombreProyecto} fue abortado", 
                           "Ufff, y si se deciden? Abortaron la ejecución de ${nombreProyecto}",
                           "El proyecto ${nombreProyecto} hizo trabajar demás a Jenkins porque lo abortaron.",
                           "A ver quién abortó al proyecto ${nombreProyecto}, hay tabla",
                           "Ojo al piojo que abortaron el proyecto ${nombreProyecto}"]];

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