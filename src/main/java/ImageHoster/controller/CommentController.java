package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class CommentController {

    private CommentService commentService;
    private ImageService imageService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String postComment(@RequestParam("comment") String comment, @PathVariable("imageId") Integer imageId,
                              @PathVariable("imageTitle") String imageTitle,
                              Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggeduser");
        commentService.postComment(comment, imageService.getImage(imageId), user);
        return "redirect:/images/{imageId}/{imageTitle}";
    }
}
