package Giuseppecanzoneri.capstoneproject;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Destination.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DestinationRunner implements CommandLineRunner {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationRunner(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Destination> destinations = destinationRepository.findAll();
        if (destinations.isEmpty()) {
            String itinerary = "Giorno 1:\n" +
                    "   Mattina: Visita alla Torre di Londra e alle Crown Jewels\n" +
                    "   Pomeriggio: Esplorazione del Tower Bridge e passeggiata lungo il Tamigi\n" +
                    "   Sera: Spettacolo teatrale nel West End\n" +
                    "Giorno 2:\n" +
                    "   Mattina: Visita al British Museum\n" +
                    "   Pomeriggio: Esplorazione di Covent Garden e del mercato di Camden\n" +
                    "   Sera: Cena in un pub tradizionale londinese\n" +
                    "Giorno 3:\n" +
                    "   Mattina: Visita al Palazzo di Buckingham e al cambio della guardia\n" +
                    "   Pomeriggio: Esplorazione di Hyde Park e Kensington Gardens\n" +
                    "   Sera: Passeggiata lungo South Bank e ammirare la vista sul London Eye\n" +
                    "Giorno 4:\n" +
                    "   Mattina: Visita alla Cattedrale di San Paolo\n" +
                    "   Pomeriggio: Esplorazione di Notting Hill e del mercato di Portobello Road\n" +
                    "   Sera: Cena in un ristorante sulla riva del fiume con vista sulla City di Londra\n" +
                    "Giorno 5:\n" +
                    "   Mattina: Visita al Museo di Storia Naturale\n" +
                    "   Pomeriggio: Esplorazione di Camden Town e del canale di Little Venice\n" +
                    "   Sera: Esplorazione del quartiere di Soho e cena in un ristorante etnico\n" +
                    "Giorno 6:\n" +
                    "   Mattina: Visita alla National Gallery\n" +
                    "   Pomeriggio: Esplorazione di Greenwich e visita al Royal Observatory\n" +
                    "   Sera: Crociera sul Tamigi al tramonto\n" +
                    "Giorno 7:\n" +
                    "   Mattina: Visita alla Westminster Abbey\n" +
                    "   Pomeriggio: Esplorazione del quartiere di Shoreditch e del mercato di Brick Lane\n" +
                    "   Sera: Spettacolo musicale o concerto in una delle famose sale da concerto di Londra";

            Destination destination = new Destination("Londra", itinerary, "https://i.imgur.com/KaMzN9X.jpeg");
            destinationRepository.save(destination);


            String itinerary1 = "Giorno 1:\n" +
                    "   Mattina: Visita al Colosseo e al Foro Romano\n" +
                    "   Pomeriggio: Esplorazione del Palatino e del Campidoglio\n" +
                    "   Sera: Passeggiata lungo il Lungotevere e cena in un ristorante tradizionale romano\n" +
                    "Giorno 2:\n" +
                    "   Mattina: Visita alla Città del Vaticano e alla Basilica di San Pietro\n" +
                    "   Pomeriggio: Esplorazione dei Musei Vaticani e della Cappella Sistina\n" +
                    "   Sera: Cena in un ristorante caratteristico nei dintorni di Trastevere\n" +
                    "Giorno 3:\n" +
                    "   Mattina: Visita alla Fontana di Trevi e al Pantheon\n" +
                    "   Pomeriggio: Esplorazione di Piazza Navona e del quartiere di Campo de' Fiori\n" +
                    "   Sera: Passeggiata lungo Via del Corso e shopping nelle vie principali\n" +
                    "Giorno 4:\n" +
                    "   Mattina: Visita alla Galleria Borghese\n" +
                    "   Pomeriggio: Esplorazione di Villa Borghese e del parco\n" +
                    "   Sera: Cena in un ristorante con vista panoramica su Roma\n" +
                    "Giorno 5:\n" +
                    "   Mattina: Visita al Castel Sant'Angelo\n" +
                    "   Pomeriggio: Esplorazione di Trastevere e del quartiere ebraico\n" +
                    "   Sera: Spettacolo musicale o teatrale presso il Teatro dell'Opera\n" +
                    "Giorno 6:\n" +
                    "   Mattina: Visita al Mercato di Testaccio e degustazione di prodotti tipici\n" +
                    "   Pomeriggio: Esplorazione di San Giovanni in Laterano e della Basilica di San Clemente\n" +
                    "   Sera: Cena in un ristorante caratteristico nei pressi di Piazza di Spagna\n" +
                    "Giorno 7:\n" +
                    "   Mattina: Visita ai Fori Imperiali\n" +
                    "   Pomeriggio: Esplorazione del quartiere Monti e shopping vintage\n" +
                    "   Sera: Passeggiata serale a Trinità dei Monti e vista panoramica da Piazza del Popolo";

            Destination destination1 = new Destination("Roma", itinerary1, "https://i.imgur.com/5SFKsao.jpeg");
            destinationRepository.save(destination1);



            String itinerary2 = "Giorno 1:\n" +
                    "   Mattina: Visita alla Torre Eiffel e ammirare la vista panoramica\n" +
                    "   Pomeriggio: Esplorazione di Montmartre e visita alla Basilica del Sacré-Cœur\n" +
                    "   Sera: Cena in un ristorante caratteristico nel quartiere latino\n" +
                    "Giorno 2:\n" +
                    "   Mattina: Visita al Louvre e ammirare la Gioconda\n" +
                    "   Pomeriggio: Esplorazione di Île de la Cité e visita alla Cattedrale di Notre-Dame\n" +
                    "   Sera: Crociera sulla Senna al tramonto\n" +
                    "Giorno 3:\n" +
                    "   Mattina: Visita ai Champs-Élysées e all'Arco di Trionfo\n" +
                    "   Pomeriggio: Esplorazione di Saint-Germain-des-Prés e del Quartiere Latino\n" +
                    "   Sera: Spettacolo di cabaret al Moulin Rouge\n" +
                    "Giorno 4:\n" +
                    "   Mattina: Visita al Palazzo di Versailles\n" +
                    "   Pomeriggio: Esplorazione dei Giardini di Versailles\n" +
                    "   Sera: Cena in un ristorante con vista sulla Senna\n" +
                    "Giorno 5:\n" +
                    "   Mattina: Visita al Museo d'Orsay e ammirare le opere impressioniste\n" +
                    "   Pomeriggio: Esplorazione di Montparnasse e visita alla Torre Montparnasse\n" +
                    "   Sera: Passeggiata lungo il canale Saint-Martin e cena in un bistrot tipico\n" +
                    "Giorno 6:\n" +
                    "   Mattina: Visita al Quartiere Le Marais e al Museo Picasso\n" +
                    "   Pomeriggio: Esplorazione di Canal Saint-Martin e giro in bicicletta lungo le rive\n" +
                    "   Sera: Cena in un ristorante di cucina francese gourmet\n" +
                    "Giorno 7:\n" +
                    "   Mattina: Visita alla Basilica di Saint-Denis\n" +
                    "   Pomeriggio: Esplorazione di Belleville e del Parc des Buttes-Chaumont\n" +
                    "   Sera: Spettacolo di luce al Grand Palais";

            Destination destination2 = new Destination("Parigi", itinerary2, "https://i.imgur.com/8nXoA5I.jpeg");
            destinationRepository.save(destination2);


            String itinerary3 = "Giorno 1:\n" +
                    "   Mattina: Visita al Parco Nazionale del Teide\n" +
                    "   Pomeriggio: Esplorazione di Santa Cruz de Tenerife\n" +
                    "   Sera: Cena in un ristorante di pesce sul lungomare\n" +
                    "Giorno 2:\n" +
                    "   Mattina: Visita a Puerto de la Cruz e al Lago Martiánez\n" +
                    "   Pomeriggio: Relax in una delle spiagge di Tenerife\n" +
                    "   Sera: Passeggiata sul lungomare di Los Cristianos\n" +
                    "Giorno 3:\n" +
                    "   Mattina: Escursione alle dune di Maspalomas a Gran Canaria\n" +
                    "   Pomeriggio: Esplorazione di Las Palmas de Gran Canaria\n" +
                    "   Sera: Cena in un ristorante tipico delle Canarie\n" +
                    "Giorno 4:\n" +
                    "   Mattina: Visita al Parco Nazionale di Garajonay a La Gomera\n" +
                    "   Pomeriggio: Esplorazione di San Sebastián de La Gomera\n" +
                    "   Sera: Spettacolo di folklore canario\n" +
                    "Giorno 5:\n" +
                    "   Mattina: Escursione alle piscine naturali di Los Charcones a Lanzarote\n" +
                    "   Pomeriggio: Esplorazione di Teguise\n" +
                    "   Sera: Cena in un ristorante di pesce a Playa Blanca\n" +
                    "Giorno 6:\n" +
                    "   Mattina: Visita al Parco Nazionale di Timanfaya a Lanzarote\n" +
                    "   Pomeriggio: Relax in una delle spiagge di Lanzarote\n" +
                    "   Sera: Passeggiata sul lungomare di Puerto del Carmen\n" +
                    "Giorno 7:\n" +
                    "   Mattina: Escursione al Parco Nazionale di La Caldera de Taburiente a La Palma\n" +
                    "   Pomeriggio: Esplorazione di Santa Cruz de la Palma\n" +
                    "   Sera: Cena in un ristorante con vista sull'oceano";

            Destination destination3 = new Destination("Isole Canarie", itinerary3, "https://i.imgur.com/CQg225T.jpeg");
            destinationRepository.save(destination3);


            String itinerary4 = "Giorno 1:\n" +
                    "   Mattina: Arrivo alle Maldive e trasferimento in resort\n" +
                    "   Pomeriggio: Relax in spiaggia e nuotate nelle acque cristalline\n" +
                    "   Sera: Cena romantica a base di pesce fresco sulla spiaggia\n" +
                    "Giorno 2:\n" +
                    "   Mattina: Escursione di snorkeling nelle barriere coralline\n" +
                    "   Pomeriggio: Esplorazione di una delle isole locali\n" +
                    "   Sera: Sunset cruise e cena a bordo\n" +
                    "Giorno 3:\n" +
                    "   Mattina: Giornata dedicata al relax e al benessere presso la spa del resort\n" +
                    "   Pomeriggio: Attività acquatiche come kayak, jet ski o windsurf\n" +
                    "   Sera: Cena gourmet in un ristorante sull'acqua\n" +
                    "Giorno 4:\n" +
                    "   Mattina: Escursione di pesca sportiva in mare aperto\n" +
                    "   Pomeriggio: Snorkeling con le mante a Hanifaru Bay\n" +
                    "   Sera: Serata di intrattenimento con spettacoli culturali\n" +
                    "Giorno 5:\n" +
                    "   Mattina: Escursione in idrovolante per ammirare le Maldive dall'alto\n" +
                    "   Pomeriggio: Esplorazione di una riserva naturale o un'isola deserta\n" +
                    "   Sera: Cena romantica sulla spiaggia sotto le stelle\n" +
                    "Giorno 6:\n" +
                    "   Mattina: Escursione in barca per avvistare i delfini\n" +
                    "   Pomeriggio: Attività ricreative come beach volleyball o yoga\n" +
                    "   Sera: Cena in un ristorante di pesce sul mare\n" +
                    "Giorno 7:\n" +
                    "   Mattina: Ultima mattinata di relax in spiaggia e nuotate\n" +
                    "   Pomeriggio: Trasferimento in aeroporto e partenza\n" +
                    "   Sera: Arrivo a casa e fine del viaggio";

            Destination destination4 = new Destination("Maldive", itinerary4, "https://i.imgur.com/yh4sQm1.jpeg");
            destinationRepository.save(destination4);
        }
    }
}



