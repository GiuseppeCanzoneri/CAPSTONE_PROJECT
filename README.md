# CAPSTONE_PROJECT
Il mio Capstone Project su GitHub è un repository completo che rappresenta il risultato del mio corso di apprendimento con Epicode. Contiene codice, documentazione e risorse per comprendere e replicare il progetto.

Travel Planner: Pianifica e Gestisci i Tuoi Viaggi

Travel Planner è un'applicazione completa per la pianificazione e la gestione dei
viaggi, che sfrutta le potenzialità di React per la parte frontend, Spring Boot per il
backend e Redux per la gestione dello stato. Con Travel Planner, gli utenti
possono facilmente organizzare i loro viaggi, ottenere itinerari personalizzati e
gestire le proprie informazioni utente, il tutto in un'unica piattaforma intuitiva.
Attraverso il componente principale dell'app, chiamato App Component, gli
utenti possono navigare tra le diverse pagine, inclusa la pagina di accesso (Login
Component) e la pagina di registrazione (Register Component). Dopo aver
effettuato l'accesso, gli utenti possono accedere alla Dashboard, dove possono
inserire la destinazione del viaggio utilizzando il DestinationForm Component e
ottenere un itinerario personalizzato. L'itinerario viene visualizzato attraverso
l'ItineraryComponent, che fornisce informazioni sulle attrazioni turistiche e le
attività disponibili.
Per fornire un'esperienza completa, Travel Planner offre anche una mappa
interattiva con il MapComponent, consentendo agli utenti di visualizzare
visivamente i luoghi dell'itinerario. Inoltre, gli utenti possono accedere alla
propria pagina del profilo tramite il ProfileComponent, dove possono
visualizzare e modificare le informazioni personali.
Il backend del progetto è implementato utilizzando Spring Boot e PostgreSQL. La
gestione dell'autenticazione e dell'autorizzazione degli utenti è gestita dal
UserController e dalla SecurityConfig. Le operazioni di accesso al database per gli
utenti sono gestite dal UserRepository, mentre le operazioni relative alla
destinazione del viaggio sono gestite dal DestinationController e dal
DestinationRepository.
Per garantire un'esperienza fluida e reattiva, Redux viene utilizzato per la
gestione dello stato dell'app. L'AuthActions e l'AuthReducer si occupano delle
azioni e dello stato relativi all'autenticazione, mentre le DestinationActions e il
DestinationReducer gestiscono le operazioni e lo stato relativi alla destinazione
del viaggio e all'itinerario. Tutti i reducer vengono combinati nel RootReducer
per creare lo stato globale dell'app.
In sintesi, Travel Planner è un'applicazione potente e completa che offre agli
utenti la possibilità di pianificare e gestire i propri viaggi in modo semplice e
coinvolgente. Sfruttando le tecnologie moderne come React, Spring Boot e Redux,
l'applicazione fornisce un'esperienza personalizzata e intuitiva, garantendo allo
stesso tempo la sicurezza delle informazioni utente.
