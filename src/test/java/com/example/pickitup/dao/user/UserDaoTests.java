package com.example.pickitup.dao.user;

import com.example.pickitup.domain.dao.user.UserDAO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDaoTests {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void getDetail(){
        log.info("한명의 유저" + userDAO.read(22L));
    }

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("a45665n@naber.com");
        userVO.setPassword("dfdf");
        userVO.setNickname("nickname");
        userVO.setPhone("5454544545");
        userVO.setAddress("서울특별시 용산구 갈월");
        userDAO.register(userVO);
    }

    @Test
    public void updateTest(){
        UserVO userVO = new UserVO();
        userVO.setNum(2L);
        userVO.setEmail("fgdg@naber.com");
        userVO.setPassword("fgdfg");
        userVO.setNickname("dfgdf");
        userVO.setPhone("01000000000");
        userVO.setAddress("서울특별시 zdfgdfg 역삼동");
        userVO.setProfileFileName("adfffaaa");
        userVO.setProfileUploadPath("fffffff");
        log.info("수정"+ userDAO.update(userVO));
    }

    @Test
    public void deleteTest(){
        log.info("삭제"+userDAO.remove(22L));
    }

    @Test
    public void loginTest(){
        int check=1;
        if(check==userDAO.login("ddd","dddd")){
            log.info("로그인 성공");
        }
    }

    public void getInProductTest() {
        userDAO.getInProjectList(2L);
    }
}