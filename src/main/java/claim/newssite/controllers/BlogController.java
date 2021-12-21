package claim.newssite.controllers;

import claim.newssite.entities.Blog;
import claim.newssite.entities.User;
import claim.newssite.repositories.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class BlogController {

    public static final Logger LOG = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    BlogRepository blogRepository;


    //Rendering the page to create a blog
    @GetMapping(value="blogs/createblog") 
        public ModelAndView getBlogPage() {
            return new ModelAndView("blogs");
    }

    //Method for creating a Blog
    @PostMapping(value = "blogs/createblog")
        public ModelAndView createBlog (@ModelAttribute("Blogs") Blog blog) {
            ModelAndView blogPage = new ModelAndView("blogs");
            Blog newBlog = new Blog();
            newBlog.setBlogTitle(blog.getBlogTitle());
            newBlog.setBlogBody(blog.getBlogBody());
            blogRepository.save(newBlog);
            LOG.info("Blog Saved Successfully!");
            blogPage.addObject("message","Blog Saved!");
            blogPage.addObject("blogs",newBlog);
            blogPage.addObject("id",blog.getId());
            return blogPage;
        }

 // The "Edit Post" feature is supposed to function, but I've had some problems with getting
 // this to work as desired. Needs to be added. 
    
        //Edit Posts
    @GetMapping("blogs/edit/{id}")
    public String editBlogs (@ModelAttribute("Blogs") Blog blog, @PathVariable(name="id") Integer id) {
        ModelAndView page = new ModelAndView("editBlogs");
        User user = new User();
        blog.setBlogTitle(blog.getBlogTitle());
        blog.setBlogBody(blog.getBlogBody());
        blogRepository.save(blog);
        LOG.info("Editing Blog...");
        page.addObject("blog", blog);
        return "redirect:/blogs";
    }

    //Method to delete a blog from the database and redirect back to the create blog page

    @GetMapping("blogs/delete/{id}")
    public ModelAndView deleteBlog (@PathVariable(name = "id") Integer id, HttpServletResponse response) {
        ModelAndView page = new ModelAndView("showBlogs");
        blogRepository.deleteById(id);
        LOG.info("Blog has been deleted");
        page.addObject("id", id);
        page.addObject("deleteMessage","Blog has been deleted");
        page.addObject("remainingBlogs",blogRepository.findAll());
        return page;
    }

    //Method fetches all the saved blogs in the database and shows them using JSP pages (see webapp/WEBINF/jsp for more details)
    @GetMapping("blogs/view")
    public ModelAndView showAllBlogs (@ModelAttribute("Blogs") Blog blogs) {
        ModelAndView page = new ModelAndView("showBlogs");
        List<Blog> allBlogs = (List<Blog>) blogRepository.findAll();
        page.addObject("blogs", allBlogs);
        return page;
    }
}


