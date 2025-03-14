# Festival Culturale

Benvenuto nel repository del progetto **Festival Culturale**. Questo progetto è stato sviluppato per la gestione e l'organizzazione di eventi culturali, offrendo funzionalità per la gestione degli eventi, la registrazione degli utenti e la visualizzazione delle informazioni.

## Struttura del Progetto

Il progetto segue la struttura tipica di un'applicazione Java con Gradle.

### Struttura della directory `src`

La cartella `src` è organizzata nel seguente modo:

- **`src/main/java`**: Contiene il codice sorgente principale dell'applicazione.
  - **`com.festivalculturale`**: Il package principale del progetto.
    - **`model`**: Contiene le classi che rappresentano gli oggetti del dominio, come `Evento`, `Utente` e `Prenotazione`.
    - **`service`**: Contiene la logica di business dell'applicazione, con classi per la gestione degli eventi e degli utenti.
    - **`repository`**: Se il progetto utilizza un database, questa cartella conterrà le interfacce per l'accesso ai dati.
    - **`controller`**: Contiene i controller che gestiscono le richieste dell'utente e interagiscono con i servizi.
    - **`util`**: Eventuali classi di utilità e helper.

- **`src/main/resources`**: Contiene risorse come file di configurazione, template HTML e altre risorse statiche.
  - **`static`**: File statici come CSS, JavaScript e immagini.
  - **`templates`**: File HTML per la visualizzazione (se il progetto include una parte frontend server-side).
  - **`application.properties`** o **`application.yml`**: Configurazioni dell'applicazione, come impostazioni del database e parametri di runtime.

- **`src/test/java`**: Contiene i test unitari e di integrazione.

## Tecnologie Utilizzate

- **Java**: Linguaggio di programmazione principale.
- **Gradle**: Sistema di build e gestione delle dipendenze.
- **Spring Boot** *(se incluso nel progetto)*: Framework per lo sviluppo di applicazioni web in Java.
- **HTML, CSS, JavaScript**: Per la parte frontend dell'applicazione.
- **Database SQL o NoSQL** *(se implementato)*: Per la gestione dei dati persistenti.

## Come Iniziare

Assicurati di avere installato **Java** e **Gradle**. Se non hai Gradle installato globalmente, puoi utilizzare Gradle Wrapper incluso nel progetto.

1. **Clona il repository**:
   ```bash
   git clone https://github.com/pepperagosta7/festivalculturale.git
   ```

2. **Accedi alla directory del progetto**:
   ```bash
   cd festivalculturale
   ```

3. **Esegui il build del progetto**:
   ```bash
   ./gradlew build  # Su Unix/MacOS
   gradlew.bat build  # Su Windows
   ```

4. **Avvia l'applicazione**:
   ```bash
   ./gradlew bootRun  # Se si utilizza Spring Boot
   ```

## Contributi

Se desideri contribuire al progetto, puoi fare un fork del repository e inviare una pull request con le tue modifiche. Tutti i contributi sono ben accetti!

## Licenza

Questo progetto non ha una licenza specificata. Contatta l'autore per maggiori dettagli.

---

**Nota:** Questa descrizione è basata sulle informazioni attualmente disponibili nel repository e potrebbe richiedere aggiornamenti in base alle funzionalità implementate.

