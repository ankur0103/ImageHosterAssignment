package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void createComment(Comment inputComment) {
        commentRepository.createComment(inputComment);
    }

    public List<Comment> getComments(Image image) {
        return commentRepository.getComments(image);
    }
}
