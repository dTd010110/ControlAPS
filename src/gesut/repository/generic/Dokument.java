package gesut.repository.generic;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;

public class Dokument {
    private Identyfikator idIIP;
    private LocalDateTime startObiekt;
    private CyklZyciaInfo cyklZycia;
    private LocalDateTime koniecObiekt;
    private String tytul;
    private String nazwaTworcyDokumentu;
    private String opisDokumentu;
    private String rodzajDokumentu;
    private String sygnaturaDokumentu;
    private URL zasobSieciowy;
    private Date dataDokumentu;
    private String oznKancelaryjneDokumentu;
}
