import org.example.tp_jeudevinette.repository.DevinetteRepository;
import org.example.tp_jeudevinette.repository.PropositionRepository;
import org.example.tp_jeudevinette.service.DevinetteService;
import org.example.tp_jeudevinette.utils.HibernateSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DevinetteServiceTest {
    private DevinetteService service;

    @BeforeEach
    void initDevinetteService() {
        service = new DevinetteService(
                HibernateSession.getSessionFactory(),
                new DevinetteRepository(),
                new PropositionRepository()
        );
    }

    @Test
    void givenQuestionReponseWhenCreateDevinetteThenNotRaiseRepositoryException() {
//        service = new DevinetteService(HibernateSession.getSessionFactory(), new DevinetteRepository());
        String question = "question";
        String reponse = "reponse";

        Assertions.assertDoesNotThrow(() -> service.createDevinette(question, reponse));
    }

    @Test
    void givenQuestionReponseWhenCreateDevinetteThenTrue() {
//        service = new DevinetteService(HibernateSession.getSessionFactory(), new DevinetteRepository());
        String question = "question";
        String reponse = "reponse";

        Assertions.assertDoesNotThrow(() -> {
            boolean result = service.createDevinette(question, reponse);
            Assertions.assertTrue(result);
        });
    }

    @Test
    void givenPropositionWhenSubmitPropositionThenTrue() {
        String proposition = "reponse";

        Assertions.assertDoesNotThrow(() -> {
            boolean result = service.submitProposition(1L, proposition);
            Assertions.assertTrue(result);
        });
    }
}
