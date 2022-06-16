package springRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/blog")
    public  List<Blog> index(){
        return blogRepository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRepository.findById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String,String> body){
        String searchTerm = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String,String> body){
        int id= Integer.parseInt(body.get("id"));
        String title=body.get("title");
        String content=body.get("content");
        return blogRepository.save(new Blog(title, content));
    }

  /*  @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String,String> body){
        int blogId = Integer.parseInt(id);
        Optional<Blog> blog = blogRepository.findById(blogId);
        String title = body.get("title");
        String content =body.get("content");
        return blogRepository.save(blog);
    }*/

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        blogRepository.deleteById(blogId);
        return true;
    }
}
