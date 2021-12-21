package claim.newssite.repositories;

import claim.newssite.entities.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog,Integer> {

   public void deleteById(Integer id);


}