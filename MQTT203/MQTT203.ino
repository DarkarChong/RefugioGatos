#include <WiFiS3.h>
#include <PubSubClient.h>
#include "ArduinoGraphics.h"
#include "Arduino_LED_Matrix.h"

ArduinoLEDMatrix matrix;
int flag = 0;
// CONSTANTES EN LOS PINES DE ARDUINO
// PUEDES DECLARAR NUEVAS VARIABLES
const int red = 4;
const int green = 5;
const int button = 3;

/////////////////////////
// WiFi - MODIFICA ESTA SECCIÓN
/////////////////////////
char ssid[] = "iPhone de Néstor";
char pass[] = "12345678";

/////////////////////////
// MQTT - MODIFICA ESTA SECCIÓN
/////////////////////////
char mqtt_server[] = "791e994ec89d4df2af8121dad40fe04d.s1.eu.hivemq.cloud";
int mqtt_port = 8883;
char mqtt_user[] = "DDANestorNarcizo";
char mqtt_pass[] = "Dda_NN26";
const char* topic = "Panico";

WiFiSSLClient wifiClient;
PubSubClient client(wifiClient);

/////////////////////////
// Configuración de scroll
/////////////////////////
String mensaje = "";  // Mensaje recibido
int scrollX = 12;     // Empieza fuera de la matriz (12 columnas)
unsigned long lastScroll = 0;
int scrollSpeed = 150; // milisegundos entre desplazamientos

/////////////////////////
// Callback MQTT
/////////////////////////
void callback(char* topic, byte* payload, unsigned int length) {
 
  
  mensaje = "";
  for (unsigned int i = 0; i < length; i++) {
    mensaje += (char)payload[i];
  }

  Serial.print("Mensaje recibido: ");
  Serial.println(mensaje);

// PUEDES MODIFICAR ESTE MENSAJE
  if(mensaje == "Néstor has an emergency"){
    flag = 1;
  }

  // Agrega las condiciones aquí para cada mensaje que recibas

  // Make it scroll!
  matrix.beginDraw();

  matrix.stroke(0xFFFFFFFF);
  matrix.textScrollSpeed(100);

  // add the text
  const char text[] = "    Hello World!    ";
  matrix.textFont(Font_5x7);
  matrix.beginText(0, 1, 0xFFFFFF);
  matrix.println(mensaje);
  matrix.endText(SCROLL_LEFT);

  matrix.endDraw();
  mensaje = " ";
}

/////////////////////////
// Reconexión MQTT
/////////////////////////
void reconnect() {
  while (!client.connected()) {
    Serial.print("Conectando a MQTT...");
    if (client.connect("UNO_R4_Client", mqtt_user, mqtt_pass)) {
      Serial.println(" conectado!");
      client.subscribe(topic);
    } else {
      Serial.print(" fallo, rc=");
      Serial.print(client.state());
      Serial.println(" intentando otra vez en 5 segundos");
      delay(5000);
    }
  }
}

/////////////////////////
// Setup
/////////////////////////
void setup() {
  Serial.begin(9600);
  delay(2000);

  // MODIFICA ESTA PARTE PARA AGREGAR MAS INPUTS O OUTPUTS
  pinMode(button, INPUT);
  pinMode(red, OUTPUT);
  pinMode(green, OUTPUT);

  // Conectar WiFi
  Serial.println("Conectando a WiFi...");
  while (WiFi.begin(ssid, pass) != WL_CONNECTED) {
    Serial.print(".");
    delay(1000);
  }
  Serial.println("\nWiFi conectado!");

  //Inicializando la matrix
  matrix.begin();

  matrix.beginDraw();
  matrix.stroke(0xFFFFFFFF);
  // add some static text
  // will only show "UNO" (not enough space on the display)
  const char text[] = "UNO r4";
  matrix.textFont(Font_4x6);
  matrix.beginText(0, 1, 0xFFFFFF);
  matrix.println(text);
  matrix.endText();

  matrix.endDraw();

  // Configurar MQTT
  client.setServer(mqtt_server, mqtt_port);
  client.setCallback(callback);
  mensaje = " ";
}

/////////////////////////
// Loop
/////////////////////////

void loop() {
  // Reconexión si es necesario
  if (!client.connected()) reconnect();
  client.loop();

// ESTE IF CONTROLA UNA VARIABLE PARA ENCENDER LOS LEDS
// SI NO HAY ALERTA SE ENCIENDE EL VERDE
// SI HAY ALERTA SE ENCIENDE EL ROJO
  if (flag == 0){
  digitalWrite(red, LOW);
  digitalWrite(green, HIGH);
  }
  else if(flag == 1)
  {
  digitalWrite(red, HIGH);
  digitalWrite(green, LOW);
  }

  static unsigned long lastMsg = 0;
  // MODIFICA ESTA SECCIÓN PARA AGREGAR LOS BOTONES 
  // Y EL MENSAJE PARA CADA MIEMBRO DEL EQUIPO
  if (digitalRead(button)==HIGH) {
    flag = 0;
    client.publish(topic, "We are on the way"); // ESTA LINEA ES LA QUE ENVIA EL MENSAJE
    
    delay(1000);
    }
}
