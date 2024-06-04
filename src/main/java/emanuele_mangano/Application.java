package emanuele_mangano;

import emanuele_mangano.DAO.EventDAO;
import emanuele_mangano.Entities.Evento;
import emanuele_mangano.Enums.EventType;
import emanuele_mangano.Exception.EventNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2-Gestione-Eventi");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        EntityManager em = emf.createEntityManager();
        EventDAO dao = new EventDAO(em);

        while (true) {
            System.out.println("1. Add an event to the database\n2. Search an event \n3. Remove an event from the database\n0. Exit");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter the title of the event:  ");
                    String title = sc.nextLine();
                    System.out.println("Enter the date of the event:  ");
                    String date = sc.nextLine();
                    System.out.println("Enter a description of the event:  ");
                    String description = sc.nextLine();
                    System.out.println("Enter a max number of Participants:");
                    int maxParticipants = Integer.parseInt(sc.nextLine());

                    dao.save(new Evento(title, date, description, EventType.PRIVATE, maxParticipants));
                    break;

                case 2:
                    System.out.println("Enter the ID to search: ");
                    int id = Integer.parseInt(sc.nextLine());
                    try {
                        Evento foundedEvent = dao.findById(id);
                        System.out.println(foundedEvent);
                        break;
                    } catch (EventNotFoundException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                case 3:
                    System.out.println("Enter the ID to search: ");
                    id = Integer.parseInt(sc.nextLine());
                    try {
                        dao.deleteById(id);
                        break;
                    } catch (EventNotFoundException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
            }
        }
    }
}
