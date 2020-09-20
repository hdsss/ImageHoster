package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@Repository
public class CommentRepository extends ImageHosterRepository {

    public List<Comment> getComments(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("searchByImgId").setParameter("imgId", imageId);
        List<Comment> comments = query.getResultList();
        if (comments == null) {
            comments = new ArrayList<>();
        }
        return comments;
    }

    public void postComment(String comment, Image image, User user) {
        Comment newComment = new Comment();
        newComment.setText(comment);
        newComment.setUser(user);
        newComment.setImage(image);
        newComment.setCreatedDate(LocalDate.n


                :ow());
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
