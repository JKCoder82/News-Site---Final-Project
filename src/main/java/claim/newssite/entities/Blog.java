package claim.newssite.entities;

import javax.persistence.*;



@Table(name="blogs")
@Entity
public class Blog {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String blogTitle;
    @Column(name="description")
    private String blogBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    private User user;

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogBody(String blogBody) {
        this.blogBody = blogBody;
    }

    public String getBlogBody() {
        return blogBody;
    }

    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Blog: +" + "" + blogTitle +  "" + blogBody + "";
    }

}

