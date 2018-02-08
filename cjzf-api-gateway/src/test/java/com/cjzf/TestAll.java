package com.cjzf;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cjzf.web.controller.JWTControllerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JWTControllerTest.class
})
public class TestAll {
}
