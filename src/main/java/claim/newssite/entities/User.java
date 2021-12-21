package claim.newssite.entities;

import javax.persistence.*;


import java.util.List;

@Entity
@Table(name="users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "password", nullable = false)
        private String password;

        @OneToMany(mappedBy="user")
        private List<Blog> blogs;

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPassword(String password) {
              this.password = password;
        }

        public String getPassword() {
                return password;
        }

        public List<Blog> getBlogs()
        {
                return blogs;
        }
        public void setBlogs(List<Blog> blogs)
        {
                this.blogs = blogs;
        }



        @Override public String toString() {
                return "User:" + "" + email + "" + password + "";
        }

}




