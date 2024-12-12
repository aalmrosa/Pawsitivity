package com.pawsitivity.server.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pawsitivity.server.TestDataUtil;
import com.pawsitivity.server.dto.PostDto;
import com.pawsitivity.server.service.PostService;

@SpringBootTest
public class PostServiceUnitTests {
    
    private PostService underTest;

    public PostServiceUnitTests(PostService underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatPostCanBeCreatedAndRetrieved(){

        PostDto post1 = TestDataUtil.createTestPostA();
        PostDto post2 = TestDataUtil.createTestPostB();
        PostDto post3 = TestDataUtil.createTestPostC();

        underTest.createPost(post1);
        underTest.createPost(post2);
        underTest.createPost(post3);

        PostDto res1 = underTest.getPost(1L);
        PostDto res2 = underTest.getPost(2L);
        PostDto res3 = underTest.getPost(3L);

        assert(res1.equals(post1));
        assert(res2.equals(post1));
        assert(res3.equals(post1));
    }

    @Test
    public void testsThatPostCanBeEdited(){
        PostDto post = TestDataUtil.createTestPostB();
        underTest.createPost(post);
        PostDto res = underTest.getPost(1L);
        assert(res.equals(post));

        post.setContent("HELLOWORLD");
        underTest.editPost(1L, post.getContent());
        assert(res.equals(post));
    }
}
