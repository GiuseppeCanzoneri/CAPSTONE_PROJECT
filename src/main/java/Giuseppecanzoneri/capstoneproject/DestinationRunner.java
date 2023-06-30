package Giuseppecanzoneri.capstoneproject;

import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Destination.repositories.DestinationRepository;
import Giuseppecanzoneri.capstoneproject.Users.User;
import Giuseppecanzoneri.capstoneproject.Users.repository.UserRepository;
import Giuseppecanzoneri.capstoneproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DestinationRunner implements CommandLineRunner {
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Destination> destinationDB = destinationRepository.findAll();
        if (destinationDB.isEmpty()) {
            User currentUser = userRepository.findByUsername("Giuseppe23")
                    .orElseThrow(() -> new NotFoundException("Utente non trovato"));

            createDestination(currentUser, "Roma",
                    "GIORNO 1 "+"Mattina: Visita al Colosseo" +
                    "Pomeriggio: Esplorazione del Foro Romano" +
                    "Sera: Passeggiata serale a Trastevere" +
                    "Giorno 2:" +
                    "Mattina: Visita ai Musei Vaticani e alla Cappella Sistina" +
                    "Pomeriggio: Esplorazione di San Pietro e la Basilica di San Pietro" +
                    "Sera: Cena in un ristorante tipico romano" +
                    "Giorno 3:" +
                    "Mattina: Esplorazione di Villa Borghese e visita alla Galleria Borghese" +
                    "Pomeriggio: Visita alla Fontana di Trevi e al Pantheon" +
                    "Sera: Passeggiata serale lungo il Lungotevere" +
                    "Giorno 4:" +
                    "Mattina: Visita al Mercato di Campo de' Fiori e degustazione di prodotti locali" +
                    "Pomeriggio: Esplorazione di Piazza Navona e dei suoi caffè" +
                    "Sera: Spettacolo di opera o musica classica all'Opera di Roma" +
                    "Giorno 5:" +
                    "Mattina: Escursione al Vaticano e visita ai Giardini Vaticani" +
                    "Pomeriggio: Esplorazione di Castel Sant'Angelo e del Ponte Sant'Angelo" +
                    "Sera: Cena in un ristorante panoramico con vista sulla città" +
                    "Giorno 6:"+
                    "Mattina: Visita al Quartiere dell'EUR e al Museo della Civiltà Romana" +
                    "Pomeriggio: Esplorazione del quartiere Trionfale e shopping in Via Cola di Rienzo" +
                    "Sera: Passeggiata lungo il Lungomare di Ostia e cena in un ristorante di pesce" +
                    "Giorno 7:"+
                    "Mattina: Escursione a Villa d'Este a Tivoli" +
                    "Pomeriggio: Visita a Villa Adriana a Tivoli" +
                    "Sera: Serata di relax e cena in un ristorante tradizionale romano", "https://i.imgur.com/5SFKsao.jpeg");



            createDestination(currentUser, "Parigi", "Giorno 1:" +
                    "Mattina: Visita alla Torre Eiffel" +
                    "Pomeriggio: Esplorazione del Museo del Louvre" +
                    "Sera: Crociera sulla Senna al tramonto" +
                    "Giorno 2:" +
                    "Mattina: Visita alla Cattedrale di Notre-Dame" +
                    "Pomeriggio: Esplorazione del quartiere di Montmartre e della Basilica del Sacré-Cœur" +
                    "Sera: Spettacolo di cabaret al Moulin Rouge" +
                    "Giorno 3:" +
                    "Mattina: Visita al Palazzo di Versailles" +
                    "Pomeriggio: Esplorazione del quartiere di Saint-Germain-des-Prés" +
                    "Sera: Cena in un ristorante gastronomico parigino" +
                    "Giorno 4:" +
                    "Mattina: Visita al Museo d'Orsay" +
                    "Pomeriggio: Esplorazione dei Giardini di Lussemburgo" +
                    "Sera: Passeggiata lungo la Senna e ammirare l'illuminazione dei monumenti" +
                    "Giorno 5:" +
                    "Mattina: Visita alla Cattedrale di Sainte-Chapelle e alla Conciergerie" +
                    "Pomeriggio: Esplorazione del quartiere di Le Marais" +
                    "Sera: Cena in un bistro parigino tradizionale" +
                    "Giorno 6:" +
                    "Mattina: Visita al Museo dell'Orangerie" +
                    "Pomeriggio: Esplorazione del Quartiere Latino e del Pantheon" +
                    "Sera: Spettacolo al Teatro dell'Opera di Parigi" +
                    "Giorno 7:" +
                    "Mattina: Escursione al Museo dell'Orangerie e visita ai giardini di Tuileries" +
                    "Pomeriggio: Esplorazione di Montparnasse e salita sulla Torre Montparnasse per una vista panoramica" +
                    "Sera: Crociera notturna sulla Senna con cena a bordo", "https://i.imgur.com/BSRjxpM.jpeg");



            createDestination(currentUser, "Londra", "Giorno 1:" +
                    "Mattina: Visita alla Torre di Londra e alle Crown Jewels" +
                    "Pomeriggio: Esplorazione del Tower Bridge e passeggiata lungo il Tamigi" +
                    "Sera: Spettacolo teatrale nel West End" +
                    "Giorno 2:" +
                    "Mattina: Visita al British Museum" +
                    "Pomeriggio: Esplorazione di Covent Garden e del mercato di Camden" +
                    "Sera: Cena in un pub tradizionale londinese" +
                    "Giorno 3:" +
                    "Mattina: Visita al Palazzo di Buckingham e al cambio della guardia" +
                    "Pomeriggio: Esplorazione di Hyde Park e Kensington Gardens" +
                    "Sera: Passeggiata lungo South Bank e ammirare la vista sul London Eye" +
                    "Giorno 4:" +
                    "Mattina: Visita alla Cattedrale di San Paolo" +
                    "Pomeriggio: Esplorazione di Notting Hill e del mercato di Portobello Road" +
                    "Sera: Cena in un ristorante sulla riva del fiume con vista sulla City di Londra" +
                    "Giorno 5:" +
                    "Mattina: Visita al Museo di Storia Naturale" +
                    "Pomeriggio: Esplorazione di Camden Town e del canale di Little Venice" +
                    "Sera: Esplorazione del quartiere di Soho e cena in un ristorante etnico" +
                    "Giorno 6:" +
                    "Mattina: Visita alla National Gallery" +
                    "Pomeriggio: Esplorazione di Greenwich e visita al Royal Observatory" +
                    "Sera: Crociera sul Tamigi al tramonto" +
                    "Giorno 7:" +
                    "Mattina: Visita alla Westminster Abbey" +
                    "Pomeriggio: Esplorazione del quartiere di Shoreditch e del mercato di Brick Lane" +
                    "Sera: Spettacolo musicale o concerto in una delle famose sale da concerto di Londra", "https://i.imgur.com/KaMzN9X.jpeg");
            // Aggiungi altre destinazioni con le rispettive attività e immagini di copertina

        }
    }

    private void createDestination(User user, String name, String activities, String coverImageURL) {
        Destination destination = new Destination(name, activities, coverImageURL);
        destination.setUser(user);
        destinationRepository.save(destination);
    }
}
