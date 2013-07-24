workspaceWorking
================

Detta är den fungerande versionen av mitt program där problemet är löst utan att applicera någon utav de listade möjliga vidareutvecklingarna.

Projektet består utav fyra bundles: 
pontus.osgi.fibonacci - Här ligger service interfacet
pontus.osgi.fibonacciservice - Detta är logiken/modelen som tillhandahåller de olika fibonaccitalen 
pontus.osgi.clienta och pontus.osgi.clienta - Klienterna som tar vars fyra fibonaccital och skriver ut dessa.

Anledningen till att jag lade interfacet och logiken i två olika bundles motiverar jag med att man enkelt ska kunna byta ut hur fibonaccitalen genereras. Vidare så består fibonacciservice av en klass där uträkningen sker kopplat till en Activator klass. Mina klienter använder samma struktur som fibonacciservice men där jag valde att tråda klienterna så att de kontinuerligt kunde komma åt fibonacciservice.

Med tanken på att kunna göra någon utav de listade vidareutvecklingarna så använde jag mig av felix-framework vid körning. Jag har påbörjat vidareutvecklingen för möjligheten att dynamiskt kunna konfigurera pontus.osgi.fibonacciservice under körning för att bestämma hur många tal vardera klient ska kunna erhålla. Jag var påväg att konvertera pontus.osgi.fibonacciservice till en ManagedService vars update-metod skulle läsa in en config-fil som genererades utav ett Configuration Admin objekt. På grund av tidsbristen han jag endast läst på men inte riktigt imlementerat denna lösning men jag har har fått en god uppfattning om hur jag ska gå tillväga.


Körinstruktioner--------------------------

För att köra programmet så använde jag mig av felix-framework-4.2.1. I felix-framework-4.2.1 skapade jag en map deploy.

Körinstruktioner:
1. Exportera projektets filer som plugins/bundles till ..path/felix-framework-4.2.1/deploy
2. Kör kommandotolken i ..dir/felix-framework-4.2.1 (jag kör windows)
3. I kommandotolken kör kommandot: -Dfelix.fileinstall.dir=./deploy -jar bin/felix.jar
4. Lista alla installerade bundles med kommandot felix:lb för att se vilket id de installerade pluginen har blitvit tilldelade 
5. Kör igång pluginen med felix:start plugin-id där pluginen startas i ordningen felix:start:"id för fibonacci" "id för fibonacciservice" "id för clienta" "id för clientb"
6. Skåda den vackra utskriften



