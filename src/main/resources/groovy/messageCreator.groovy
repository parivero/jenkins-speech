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
Map messageMap = [SUCCESS:["${nombreProyecto} terminó exitosamente. FELICITACIONES !!!!",
                           "Quien lo diría. El proyecto ${nombreProyecto} terminó todo bien.",
                           "${nombreProyecto} terminó con éxito. Chupate esta mandarina.",
                           "Aprovechá y sacale una foto al proyecto ${nombreProyecto} que terminó exitosamente.",
                           "${nombreProyecto} terminó exitosamente. Una manteca nene !!!!",
                           "${nombreProyecto} terminó perfecto. Tan perfecto como el sitio Comunidad Fusa"],
                  BUILDING:["${nombreProyecto} se esta ejecutando. Sale con fritas !!!!", 
                            "Aguanta un rato, ${nombreProyecto}, se está ejecutando.",
                            "20 pesos al proyecto ${nombreProyecto}, que esta en ejecución.",
                            "Marche un ${nombreProyecto}, que comenzo su ejecución",
                            "Acaba de partir el proyecto ${nombreProyecto}, le deseamos un buen viaje.",
                            "Se anuncia la partida de ${nombreProyecto}, gracias por volar por Jenkins"],
                  FAILURE:["${nombreProyecto} terminó con errores", 
                           "Macacos, el proyecto ${nombreProyecto} se hizo pelota y no funciona.",
                           "Se estrelló feo el proyecto ${nombreProyecto} y quedó como tirado en una zanja.",
                           "Ojo muchachos que el proyecto ${nombreProyecto} terminó con errores",
                           "Pedile una ambulancia a ${nombreProyecto}, que quedo destruido"],
                  UNSTABLE:["${nombreProyecto} terminó inestable", 
                            "${nombreProyecto} está hecho un flancito endeble, terminó todo raro.",
                            "Pegale una mirada al proyecto ${nombreProyecto} que quedo inestable",
                            "${nombreProyecto} busca psicólogo, esta medio inestable.",
                            "${nombreProyecto} está inestable como chigua gua esquizofrénico.",
                            "Apa, apa… el proyecto ${nombreProyecto} esta inestable… apa, apa, apa… pe pe e pe pe pe pe."],
                  ABORTED:["${nombreProyecto} fue abortado", 
                           "Ufff, y si se deciden? Abortaron la ejecución de ${nombreProyecto}",
                           "${nombreProyecto} hizo trabajar demás a Jenkins porque lo abortaron.",
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