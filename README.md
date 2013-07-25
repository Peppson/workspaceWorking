Pontus egna ord och instruktioner för körning
================

Detta är den fungerande versionen av mitt program där fibonacci problemet är löst enligt specifikation men utan att applicera någon av de listade vidareutvecklingarna (gjort ett försök). Eftersom jag inte har någon erfarenhet av OSGi ramverket sedan innan har en hel del tid ägnats åt att skaffa förståelse för ramverket samt få rätt på alla kringliggande moduler som måste fungera för att till slut få en utskrift. Modulerna skrevs i Eclipse IDE som har bra stöd för Equinox.

Projektet består utav fyra plugins:<br/>
pontus.osgi.fibonacci - Här ligger service interfacet<br/>
pontus.osgi.fibonacciservice - Detta är logiken/modellen som tillhandahåller de olika fibonaccitalen<br/>
pontus.osgi.clienta och pontus.osgi.clientb - Klienterna som tar vars fyra fibonaccital och skriver ut dessa i System.out

Anledningen till att jag placerade interfacet och logiken i två olika plugins motiverar jag med att man enkelt ska kunna byta ut hur fibonaccitalen genereras (mot en effektivare modell om möjligt). Vidare så består fibonacciservice utav två paket med en klass vardera. Uträkningen sker i MyFibonacciService.java som sedan är kopplat till en Activator.java klass för att starta och stoppa pluginet. Mina klienter använder samma struktur som fibonacciservice men där jag valde att tråda klienterna för att snyggare komma åt getNextFib().

Med vidareutvecklingarna i bakhuvudet så använde jag mig av felix-framework vid körning. Jag har påbörjat vidareutvecklingen för möjligheten att dynamiskt kunna konfigurera pontus.osgi.fibonacciservice under körning. Jag var på väg att konvertera pontus.osgi.fibonacciservice till en ManagedService där tanken var att update-metoden skulle läsa in en en konfugiration som i sin tur genererades utav ett Configuration Admin objekt. Detta skulle genomföras med hjälp av ett  Felix file installer plugin. På grund av tidsbristen hann jag endast läsa på och få mig en god uppfattning om konfigurerings möjligheterna och hur man går till väga men jag hann inte riktigt med att implementera klart lösningen.

Jag valde att lägga vidareutvecklingen av konfigurationslösningen i en annan repository (https://github.com/Peppson/workspace.git) eftersom att jag inte kom så långt pga. tisdbristen. Lite implementation har skett i pontus.osgi.fibonacciservice.

Körinstruktioner
================================================================================

Förarbete:<br/>För att köra programmet så använde jag mig av felix-framework-4.2.1 vilket laddas ner från http://felix.apache.org/downloads.cgi som en zip och packas upp på valfri destination. I mappen /felix-framework-4.2.1 skapade jag en map deploy. Ladda hem filen org.apache.felix.fileinstall-3.2.6.jar från http://felix.apache.org/downloads.cgi och placera denna i ..\felix-framework-4.2.1\bundle.

Steg för steg:<br/>
1. Exportera projektets filer som plugins/bundles till ..path/felix-framework-4.2.1/deploy<br/>
2. Kör kommandotolken i ..dir/felix-framework-4.2.1 (jag kör windows)<br/>
3. I kommandotolken kör kommandot: -Dfelix.fileinstall.dir=./deploy -jar bin/felix.jar<br/>
4. Lista alla installerade bundles med kommandot felix:lb för att se vilket id de installerade pluginen har blivit tilldelade <br/>
5. Kör igång pluginen med felix:start "plugin-id" där pluginen startas i ordningen felix:start:"id för fibonacci" "id för fibonacciservice" "id för clienta" "id för clientb"<br/>
6. Skåda den vackra utskriften<br/>

Mvh Pontus Johansson


