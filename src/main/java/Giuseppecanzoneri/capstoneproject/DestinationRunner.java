package Giuseppecanzoneri.capstoneproject;



import Giuseppecanzoneri.capstoneproject.Destination.Destination;
import Giuseppecanzoneri.capstoneproject.Destination.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DestinationRunner implements CommandLineRunner {
    @Autowired
    DestinationRepository destinationRepo;

    @Override
    public void run(String... args) throws Exception {
        List<Destination> destinationDB = destinationRepo.findAll();
        if (destinationDB.size() == 0) {
            Destination film1 = new Destination("Roma", "Day1:Giro in barca," +
                    "Day2:giro in gondola" +
                    "day3:halo","https://i.imgur.com/ydO73kB.jpg" );

//            Destination film2 = new Destination("Super Mario Bros", "https://i.imgur.com/gGmic94.jpg", Categoria.ANIMAZIONE,
//                    "Super Mario, il famoso idraulico, e Luigi si ritrovano in un mondo magico. Luigi viene rapito da Bowser, mentre Mario cerca di salvarlo. Il film animato offre una narrazione piatta ma con elementi tecnici di qualità, presentando una principessa Peach attiva e un Luigi con un percorso formativo diverso. Mario rappresenta le insicurezze sociali contemporanee.",
//                    "3.5/5", "1h 32m", "2023");
//
//            Destination film3 = new Destination("John Wick 4", "https://i.imgur.com/6Q12zQQ.jpg", Categoria.AZIONE,
//                    "John Wick, l'implacabile assassino, torna per vendicarsi della Gran Tavola della fantamafia. Senza una trama definita, il film si basa su lotte spettacolari e adrenalina costante. Il regista Chad Stahelski celebra gli stuntman e crea un'epica contemporanea senza compromessi. Una saga che consacra Stahelski come autore nel genere d'azione.",
//                    "4.5/5", "2h 49m", "2023");
//
//            Destination film4 = new Destination("Star Wars: L'attacco dei cloni", "https://i.imgur.com/karn0mi.jpg",
//                    Categoria.FANTASCIENZA,
//                    "In Star Wars: L'attacco dei cloni, il secondo capitolo della trilogia prequel, l'Ordine dei Jedi affronta una crescente minaccia separatista. Obi-Wan Kenobi e Anakin Skywalker sono inviati in una missione per proteggere la senatrice Padmé Amidala e scoprire l'origine dell'esercito di cloni. Nel frattempo, Anakin si innamora di Padmé e affronta le tentazioni del lato oscuro della Forza. La trama si sviluppa con intrighi politici, battaglie intergalattiche e il misterioso piano del Signore Oscuro dei Sith, Darth Sidious.",
//                    "2.6/5", "2h 22m", "2002");
//
//            Destination film5 = new Destination("Lo hobbit: Un viaggio inaspettato", "https://i.imgur.com/FFcoNKl.jpg",
//                    Categoria.FANTASY,
//                    "Lo Hobbit: Un viaggio inaspettato è un avventuroso film fantasy. Bilbo Baggins viene coinvolto da Gandalf il Grigio in una missione per recuperare il Regno dei Nani di Erebor. Unendosi a una compagnia di tredici nani guidata da Thorin Scudodiquercia, affrontano pericoli, creature malvagie e un incontro inaspettato con Gollum, nel tentativo di reclamare il tesoro nascosto e sconfiggere il terribile drago Smaug.",
//                    "3/5", "2h 49m", "2012");
//
//            Destination film6 = new Destination("Tolo Tolo", "https://i.imgur.com/jmPMWgD.jpg", Categoria.COMMEDIA,
//                    "Checco Zalone interpreta Pieraccioni, un giovane italiano che emigra in Africa per cercare lavoro, sperando di migliorare la sua vita. Tuttavia, si trova coinvolto in una serie di situazioni comiche e imbarazzanti, mentre cerca disperatamente di adattarsi alla cultura e alle tradizioni locali. Un viaggio che gli permetterà di confrontarsi con se stesso e di scoprire il vero significato della felicità.",
//                    "3.5/5", "1h 43m", "2020");
//
//            Destination film7 = new Destination("Shazam!", "https://i.imgur.com/9Bheuav.jpg", Categoria.AZIONE,
//                    "Thaddeus, trascurato dalla famiglia, viene provato dal mago Shazam, ma soccombe alle tentazioni. Anni dopo, ottiene poteri oscuri, mentre il mago trova un nuovo campione virtuoso. Quando Thaddeus pronuncia \"Shazam!\", diventa un eroe pronto a combattere per il mondo.",
//                    "3/5", "2h 12m", "2019");
//
//            Destination film8 = new Destination("Luca", "https://i.imgur.com/0bADGjF.jpg", Categoria.ANIMAZIONE,
//                    "Luca, una creatura marina dedita alla pastorizia subacquea, incontra un suo simile, Alberto, insieme al quale, sotto sembianze umane, si avventura verso Portorosso, un villaggio di pescatori della riviera ligure. L’incontro con Giulietta e la partecipazione ad una gara mette a repentaglio il loro segreto.",
//                    "4.5/5", "1h 35m", "2021");
//
//            Destination film9 = new Destination("Shutter Island", "https://i.imgur.com/aHpHA72.jpg", Categoria.THRILLER,
//                    "1954. L’agente federale Teddy Daniels si reca a Shutter Island, al largo di Boston, dove si trova l’Ashecliffe Hospital, un manicomio criminale. Deve ritrovare una detenuta scomparsa, Rachel Salando. Un uragano si abbatte sull’isola…",
//                    "3/5", "2h 18m", "2010");
//
//            Destination film10 = new Destination("Creed 3", "https://i.imgur.com/pjMcwyY.jpg", Categoria.DRAMMATICO,
//                    "Adonis Creed sta prosperando nella sua carriera e nella sua vita familiare. Quando un amico d’infanzia ed ex prodigio del pugilato ricompare dopo aver scontato la pena in carcere, ansioso di dimostrare di meritare la sua occasione sul ring, la situazione sfuggirà presto di mano…",
//                    "2.5/5", "1h 56m", "2023");
            destinationRepo.save(film1);
//            destinationRepo.save(film2);
//            destinationRepo.save(film3);
//            destinationRepo.save(film4);
//            destinationRepo.save(film5);
//            destinationRepo.save(film6);
//            destinationRepo.save(film7);
//            destinationRepo.save(film8);
//            destinationRepo.save(film9);
//            destinationRepo.save(film10);

        }
    }

}
