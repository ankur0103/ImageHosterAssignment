package ImageHoster.repository;


import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public void createComment(Comment inputComment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(inputComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return ;
    }

    public List<Comment> getComments(Image image) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i where i.image =:image", Comment.class).setParameter("image", image);
        List<Comment> resultList = query.getResultList();

        return resultList;
    }

}
