package emanuele_mangano.DAO;

import emanuele_mangano.Entities.Evento;
import emanuele_mangano.Exception.EventNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventDAO {

    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("Saved successfully");
    }

    public Evento findById(int idToFind) {
        Evento foundEvent = this.em.find(Evento.class, idToFind);
        if (foundEvent == null) throw new EventNotFoundException(idToFind);
        return foundEvent;
    }

    public void deleteById(int idToDelete) {
        Evento eventToDelete = findById(idToDelete);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(eventToDelete);
        transaction.commit();
        System.out.println("Removed successfully");
    }
}
