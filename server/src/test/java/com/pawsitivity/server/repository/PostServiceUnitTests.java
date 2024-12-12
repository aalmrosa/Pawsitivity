package com.pawsitivity.server.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pawsitivity.server.TestDataUtil;
import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.service.PostService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PostServiceUnitTests {
    
    private PostService underTest;

    @Autowired
    public PostServiceUnitTests(PostService underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatPostCanBeCreatedAndRetrieved(){

        PostDto post1 = TestDataUtil.createTestPostA();
        post1.setId(1L);
        PostDto post2 = TestDataUtil.createTestPostB();
        post2.setId(2L);
        PostDto post3 = TestDataUtil.createTestPostC();
        post3.setId(3L);

        underTest.createPost(post1);
        underTest.createPost(post2);
        underTest.createPost(post3);

        PostDto res1 = underTest.getPost(1L);
        PostDto res2 = underTest.getPost(2L);
        PostDto res3 = underTest.getPost(3L);

        assertEquals(post1, res1);
        assertEquals(post2, res2);
        assertEquals(post3, res3);
    }

    @Test
    public void testsThatPostCanBeEdited(){
        PostDto post = TestDataUtil.createTestPostB();
        post.setId(1L);
        underTest.createPost(post);
        PostDto res = underTest.getPost(1L);
        assert(res.equals(post));

        post.setContent("HELLOWORLD");
        res = underTest.editPost(1L, post.getContent());
        assertEquals(post, res);
    }
}
