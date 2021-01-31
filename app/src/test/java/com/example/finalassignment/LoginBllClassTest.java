package com.example.finalassignment;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

//import static org.junit.Assert.assertTrue;

public class LoginBllClassTest {
    private LoginBllClass loginBllClass;
    @Before
    public void setUp(){
        loginBllClass = new LoginBllClass();
    }


    @Test
    public void checkValidUser () throws  Exception {
        assertFalse(loginBllClass.checkuser("bishalhad@gmail.com","hada"));
    }

    @Test
    public void checkValidUserF () throws  Exception {
        assertTrue(loginBllClass.checkuser("bishalhad@gmail.com","hada"));
    }

    @Test
    public void checkValidLogin () throws  Exception {
        assertTrue(loginBllClass.isSuccess=true);
    }

    @Test
    public void checkValidLoginF () throws  Exception {
        assertFalse(loginBllClass.isSuccess=true);
    }

    @Test
    public void checkUser () throws  Exception {
        assertEquals("bishalhada@gmail.com", "hada@gmail.com");
    }
        @Test
        public void checkUserP () throws  Exception {
            assertEquals("bishalhada@gmail.com","bishalhada@gmail.com");

    }
    @Test
    public void checkuser ()  {
        LoginBllClass loginBll = new LoginBllClass();
        boolean result = loginBll.checkuser("bishalhada@gmail.com","hada");
        assertEquals(false,result);
    }

}
