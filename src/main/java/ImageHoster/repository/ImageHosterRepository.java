package ImageHoster.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class ImageHosterRepository {
    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    protected EntityManagerFactory emf;

}
