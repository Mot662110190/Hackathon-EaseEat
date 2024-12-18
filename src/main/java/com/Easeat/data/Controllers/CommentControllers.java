package com.Easeat.data.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Easeat.data.Entity.Comment;
import com.Easeat.data.Entity.Strain;
import com.Easeat.data.services.CommentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // อนุญาตทุก Origin (หรือระบุเฉพาะ Origin ที่ต้องการ)

public class CommentControllers {

    private CommentService commentService;

 @Autowired
     public CommentControllers(CommentService commentService) {
        this.commentService = commentService;
    }

   @PostMapping("/comment")
    public Comment addComment (@RequestBody Comment comment){
        comment.setId(0);
               return commentService.save(comment);
    }

     @GetMapping("/comment")
    public List<Comment> getAllComment(){
        return commentService.findAll();
    }
    @GetMapping("/comment/{id}")
    public Comment getComment(@PathVariable int id){
        Comment myComment =  commentService.findById(id);
       if(myComment==null){
        throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
    }
    return myComment;
    }
    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable int id){
        Comment myComment =  commentService.findById(id);
        if(myComment==null){
            throw new RuntimeException("เกิดข้อผิดพลาดในกระบวนการทำงาน");
        }
        commentService.deleteById(id);
        return "ลบข้อมูลแล้ว";
    }
    @PutMapping("/comment")
    public Comment updateComment (@RequestBody Comment comment){
        return commentService.save(comment);
}
 @GetMapping("/comment/all/{user_id}")
    public List<Comment> getAllstrain(@PathVariable("user_id") Integer user_id) {
        List<Comment> List_comment1 = commentService.findAll();

        List<Comment> List_comment2 = new ArrayList<>();

        for (Comment Comment1 : List_comment1) {
            if (Comment1.getPost() != null) {
                System.out.println("-----> " + Comment1.getPost() + " - " + user_id);
                if (Comment1.getPost().getId() == user_id) {
                    List_comment2.add(Comment1);
                }
            }
        }

        return List_comment2;
    }
}
