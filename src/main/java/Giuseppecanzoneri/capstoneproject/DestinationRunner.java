package Giuseppecanzoneri.capstoneproject;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Destination.repositories.DestinationRepository;
import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.repository.UserRepository;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DestinationRunner implements CommandLineRunner {

    private final DestinationRepository destinationRepository;
    private final UserRepository userRepository;

    @Autowired
    public DestinationRunner(DestinationRepository destinationRepository, UserRepository userRepository) {
        this.destinationRepository = destinationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Destination> destinationDB = destinationRepository.findAll();
        if (destinationDB.isEmpty()) {
            User currentUser = userRepository.findByUsername("Giuseppe23")
                    .orElseThrow(() -> new NotFoundException("Utente non trovato"));

            createDestination(currentUser, "Roma",
                    Arrays.asList(
                            "GIORNO 1 - Mattina: Visita al Colosseo",
                            "Pomeriggio: Esplorazione del Foro Romano",
                            "Sera: Passeggiata serale a Trastevere",
                            "GIORNO 2 - Mattina: Visita ai Musei Vaticani e alla Cappella Sistina",
                            "Pomeriggio: Esplorazione di San Pietro e la Basilica di San Pietro",
                            "Sera: Cena in un ristorante tipico romano",
                            "GIORNO 3 - Mattina: Esplorazione di Villa Borghese e visita alla Galleria Borghese",
                            "Pomeriggio: Visita alla Fontana di Trevi e al Pantheon",
                            "Sera: Passeggiata serale lungo il Lungotevere",
                            "GIORNO 4 - Mattina: Visita al Mercato di Campo de' Fiori e degustazione di prodotti locali",
                            "Pomeriggio: Esplorazione di Piazza Navona e dei suoi caffè",
                            "Sera: Spettacolo di opera o musica classica all'Opera di Roma",
                            "GIORNO 5 - Mattina: Escursione al Vaticano e visita ai Giardini Vaticani",
                            "Pomeriggio: Esplorazione di Castel Sant'Angelo e del Ponte Sant'Angelo",
                            "Sera: Cena in un ristorante panoramico con vista sulla città",
                            "GIORNO 6 - Mattina: Visita al Quartiere dell'EUR e al Museo della Civiltà Romana",
                            "Pomeriggio: Esplorazione del quartiere Trionfale e shopping in Via Cola di Rienzo",
                            "Sera: Passeggiata lungo il Lungomare di Ostia e cena in un ristorante di pesce",
                            "GIORNO 7 - Mattina: Escursione a Villa d'Este a Tivoli",
                            "Pomeriggio: Visita a Villa Adriana a Tivoli",
                            "Sera: Serata di relax e cena in un ristorante tradizionale romano"
                    ),
                    "https://i.imgur.com/5SFKsao.jpeg");


            createDestination(currentUser, "Parigi",
                    Arrays.asList(
                            "GIORNO 1",
                            "Mattina: Visita alla Torre Eiffel",
                            "Pomeriggio: Esplorazione del Museo del Louvre",
                            "Sera: Passeggiata lungo la Senna",
                            "Giorno 2:",
                            "Mattina: Visita a Notre-Dame e all'Île de la Cité",
                            "Pomeriggio: Esplorazione di Montmartre e la Basilica del Sacré-Cœur",
                            "Sera: Cena in un ristorante tipico parigino",
                            "Giorno 3:",
                            "Mattina: Escursione a Versailles e visita al Palazzo di Versailles",
                            "Pomeriggio: Esplorazione del Quartiere latino",
                            "Sera: Spettacolo al Moulin Rouge",
                            "Giorno 4:",
                            "Mattina: Visita alla Sainte-Chapelle e all'Île Saint-Louis",
                            "Pomeriggio: Esplorazione di Montparnasse e la Torre Montparnasse",
                            "Sera: Passeggiata lungo i Champs-Élysées e visita all'Arco di Trionfo",
                            "Giorno 5:",
                            "Mattina: Visita al Museo d'Orsay",
                            "Pomeriggio: Esplorazione di Saint-Germain-des-Prés",
                            "Sera: Cena in un ristorante panoramico con vista sulla città",
                            "Giorno 6:",
                            "Mattina: Escursione a Giverny e visita ai giardini di Claude Monet",
                            "Pomeriggio: Esplorazione del Quartiere Marais",
                            "Sera: Passeggiata serale a Le Marais e visita al Centre Pompidou",
                            "Giorno 7:",
                            "Mattina: Visita alla Basilica di Saint-Denis",
                            "Pomeriggio: Esplorazione di La Défense e il Grande Arco",
                            "Sera: Serata di relax e cena in un ristorante tradizionale parigino"
                    ),
                    "https://i.imgur.com/8nXoA5I.jpeg"
            );


            createDestination(currentUser, "Londra",
                    Arrays.asList(
                            "Giorno 1:",
                            "Mattina: Visita alla Torre di Londra e alle Crown Jewels",
                            "Pomeriggio: Esplorazione del Tower Bridge e passeggiata lungo il Tamigi",
                            "Sera: Spettacolo teatrale nel West End",
                            "Giorno 2:",
                            "Mattina: Visita al British Museum",
                            "Pomeriggio: Esplorazione di Covent Garden e del mercato di Camden",
                            "Sera: Cena in un pub tradizionale londinese",
                            "Giorno 3:",
                            "Mattina: Visita al Palazzo di Buckingham e al cambio della guardia",
                            "Pomeriggio: Esplorazione di Hyde Park e Kensington Gardens",
                            "Sera: Passeggiata lungo South Bank e ammirare la vista sul London Eye",
                            "Giorno 4:",
                            "Mattina: Visita alla Cattedrale di San Paolo",
                            "Pomeriggio: Esplorazione di Notting Hill e del mercato di Portobello Road",
                            "Sera: Cena in un ristorante sulla riva del fiume con vista sulla City di Londra",
                            "Giorno 5:",
                            "Mattina: Visita al Museo di Storia Naturale",
                            "Pomeriggio: Esplorazione di Camden Town e del canale di Little Venice",
                            "Sera: Esplorazione del quartiere di Soho e cena in un ristorante etnico",
                            "Giorno 6:",
                            "Mattina: Visita alla National Gallery",
                            "Pomeriggio: Esplorazione di Greenwich e visita al Royal Observatory",
                            "Sera: Crociera sul Tamigi al tramonto",
                            "Giorno 7:",
                            "Mattina: Visita alla Westminster Abbey",
                            "Pomeriggio: Esplorazione del quartiere di Shoreditch e del mercato di Brick Lane",
                            "Sera: Spettacolo musicale o concerto in una delle famose sale da concerto di Londra"
                    ),
                    "https://i.imgur.com/KaMzN9X.jpeg"
            );



            createDestination(currentUser, "Tenerife",
                    Arrays.asList(
                            "Giorno 1:",
                            "Mattina: Arrivo a Tenerife e check-in presso il tuo hotel. Visita la città di Santa Cruz de Tenerife, esplora la sua vivace piazza principale Plaza de España e visita il Museo de la Naturaleza y el Hombre.",
                            "Pomeriggio: Dirigiti verso il Parco Nazionale del Teide e prendi la funivia per raggiungere la cima del Monte Teide, il vulcano attivo più alto della Spagna.",
                            "Sera: Ammira il tramonto dal Monte Teide e torna in hotel per una cena rilassante.",
                            "Giorno 2:",
                            "Mattina: Dedica la mattina alle spiagge di Costa Adeje. Rilassati sulla spiaggia di Playa del Duque o prova alcuni sport acquatici come lo snorkeling o il kayak.",
                            "Pomeriggio: Visita il Siam Park, un parco acquatico famoso per i suoi scivoli e attrazioni emozionanti.",
                            "Sera: Esplora la vivace zona di Playa de las Américas, piena di ristoranti, bar e locali notturni.",
                            "Giorno 3:",
                            "Mattina: Prendi un'escursione in barca per avvistare le balene e i delfini al largo della costa di Los Gigantes.",
                            "Pomeriggio: Visita il pittoresco villaggio di Masca e fai una passeggiata attraverso la sua splendida valle.",
                            "Sera: Goditi una cena tradizionale canaria in un ristorante locale e assapora piatti tipici dell'isola.",
                            "Giorno 4:",
                            "Mattina: Esplora la città di La Laguna, dichiarata Patrimonio dell'Umanità dall'UNESCO. Visita la Cattedrale di San Cristóbal de La Laguna e perdi tempo a passeggiare per le sue pittoresche strade.",
                            "Pomeriggio: Trascorri del tempo nel Parco Rurale di Anaga, famoso per la sua bellezza naturale e le splendide escursioni.",
                            "Sera: Rilassati in un tradizionale bar di tapas e prova le prelibatezze locali.",
                            "Giorno 5:",
                            "Mattina: Visita il Loro Parque a Puerto de la Cruz, un famoso parco tematico con spettacoli di animali esotici.",
                            "Pomeriggio: Esplora i giardini botanici di Puerto de la Cruz e goditi una passeggiata tra la flora tropicale.",
                            "Sera: Trascorri una serata romantica a El Médano, una cittadina affascinante famosa per le sue spiagge di sabbia e il suo ambiente rilassato.",
                            "Giorno 6:",
                            "Mattina: Dedica la mattina a visitare il Mercado de Nuestra Señora de Africa a Santa Cruz de Tenerife, dove potrai acquistare prodotti freschi locali.",
                            "Pomeriggio: Visita il Museo de la Ciencia y el Cosmos per scoprire di più sulle scienze e l'astronomia.",
                            "Sera: Esplora la vivace vita notturna di Puerto de la Cruz e scopri i suoi bar e locali notturni.",
                            "Giorno 7:",
                            "Mattina: Fai una passeggiata lungo la costa di Los Cristianos e goditi la vista sull'oceano.",
                            "Pomeriggio: Rilassati sulla spiaggia di Playa de las Vistas e goditi l'ultimo giorno di sole e mare.",
                            "Sera: Goditi una cena d'addio in uno dei ristoranti sulla spiaggia e festeggia la tua ultima serata a Tenerife."
                    ),
                    "https://i.imgur.com/CQg225T.jpeg"
            );



            createDestination(currentUser, "Prizzi",
                    Arrays.asList(
                            "GIORNO 1 - Mattina: Esplora il centro storico di Prizzi",
                            "Pomeriggio: Visita il Castello di Prizzi e goditi la vista panoramica",
                            "Sera: Assaggia la cucina tradizionale siciliana in un ristorante locale",
                            "GIORNO 2 - Mattina: Escursione alla vicina riserva naturale di Monte Carcaci",
                            "Pomeriggio: Scopri il bellissimo Lago Sant'Anna",
                            "Sera: Passeggia per le affascinanti strade di Prizzi",
                            "GIORNO 3 - Mattina: Visita la Chiesa di San Nicola e ammira le sue opere d'arte",
                            "Pomeriggio: Fai un'escursione panoramica nel pittoresco paese di Corleone",
                            "Sera: Assisti a una performance di musica popolare siciliana",
                            "GIORNO 4 - Mattina: Esplora la campagna rurale e gli uliveti",
                            "Pomeriggio: Scopri le tradizioni agricole locali presso una fattoria",
                            "Sera: Rilassati e goditi la tranquillità di Prizzi",
                            "GIORNO 5 - Mattina: Visita il Santuario di Maria SS. dell'Alto",
                            "Pomeriggio: Scopri il sito archeologico di Monte Genuardo",
                            "Sera: Cena in una trattoria di famiglia e assapora le delizie siciliane",
                            "GIORNO 6 - Mattina: Fai un tour guidato di una cantina locale e assaggia i vini regionali",
                            "Pomeriggio: Scopri l'arte tradizionale della ceramica a Santo Stefano Quisquina",
                            "Sera: Goditi un picnic al tramonto con vista sulla campagna",
                            "GIORNO 7 - Mattina: Partecipa a una lezione di cucina e impara a preparare piatti siciliani",
                            "Pomeriggio: Rilassati nelle terme di Acquaviva Platani",
                            "Sera: Cena di arrivederci con specialità locali e musica dal vivo"
                    ),
                    "https://i.imgur.com/9q00fAK.jpg"
            );

        }
    }

    private void createDestination(User user, String name, List<String> activities, String coverImageURL) {
        Destination destination = new Destination(name, String.join("\n", activities), coverImageURL);
        destination.setUser(user);
        destinationRepository.save(destination);
    }
}
